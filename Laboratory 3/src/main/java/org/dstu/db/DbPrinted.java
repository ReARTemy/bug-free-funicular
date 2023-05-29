package org.dstu.db;

import org.dstu.util.CsvReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbPrinted {
    public static void populateFromFile(String fileName) {
        List<String[]> strings = CsvReader.readCsvFile(fileName, ";");
        Connection conn = DbConnection.getConnection();
        try {
            Statement cleaner = conn.createStatement();
            System.out.println(cleaner.executeUpdate("DELETE FROM books"));
            System.out.println(cleaner.executeUpdate("DELETE FROM magazines"));
            PreparedStatement booksSt = conn.prepareStatement(
                    "INSERT INTO books (name, pages, publisher, language, country, author, genre, published) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement magazinesSt = conn.prepareStatement(
                    "INSERT INTO magazines (name, pages, publisher, language, country, type, editor, first_issue) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            for (String[] line: strings) {
                if (line[0].equals("0")) {
                    booksSt.setString(1, line[1]);
                    booksSt.setInt(2, Integer.parseInt(line[2]));
                    booksSt.setString(3, line[3]);
                    booksSt.setString(4, line[4]);
                    booksSt.setString(5, line[5]);
                    booksSt.setString(6, line[6]);
                    booksSt.setString(7, line[7]);
                    booksSt.setInt(8, Integer.parseInt(line[8]));
                    booksSt.addBatch();
                } else {
                    magazinesSt.setString(1, line[1]);
                    magazinesSt.setInt(2, Integer.parseInt(line[2]));
                    magazinesSt.setString(3, line[3]);
                    magazinesSt.setString(4, line[4]);
                    magazinesSt.setString(5, line[5]);
                    magazinesSt.setString(6, line[6]);
                    magazinesSt.setString(7, line[7]);
                    magazinesSt.setInt(8, Integer.parseInt(line[8]));
                    magazinesSt.addBatch();
                }
            }
            int[] stRes = booksSt.executeBatch();
            int[] teacherRes = magazinesSt.executeBatch();
            for (int num: stRes) {
                System.out.println(num);
            }

            for (int num: teacherRes) {
                System.out.println(num);
            }
            cleaner.close();
            booksSt.close();
            magazinesSt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void demoQuery() {
        Connection conn = DbConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books WHERE pages > 500");
            while (rs.next()) {
                System.out.print(rs.getString("name"));
                System.out.print(" ");
                System.out.print(rs.getString("pages"));
                System.out.print(" ");
                System.out.println(rs.getString("author"));
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dirtyReadDemo() {
        Runnable first = () -> {
            Connection conn1 = DbConnection.getNewConnection();
            if (conn1 != null) {
                try {
                    conn1.setAutoCommit(false);
                    conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement upd = conn1.createStatement();
                    upd.executeUpdate("UPDATE magazines SET first_issue='2000' WHERE first_issue='1869'");
                    Thread.sleep(2000);
                    conn1.rollback();
                    upd.close();
                    Statement st = conn1.createStatement();
                    System.out.println("In the first thread:");
                    ResultSet rs = st.executeQuery("SELECT * FROM magazines");
                    while (rs.next()) {
                        System.out.println(rs.getString("first_issue"));
                    }
                    st.close();
                    rs.close();
                    conn1.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };

        Runnable second = () -> {
            Connection conn2 = DbConnection.getNewConnection();
            if (conn2 != null) {
                try {
                    Thread.sleep(500);
                    conn2.setAutoCommit(false);
                    conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement st = conn2.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM books");
                    while (rs.next()) {
                        System.out.println(rs.getString("author"));
                    }
                    rs.close();
                    st.close();
                    conn2.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };
        Thread th1 = new Thread(first);
        Thread th2 = new Thread(second);
        th1.start();
        th2.start();
    }
}

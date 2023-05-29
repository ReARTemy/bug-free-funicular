package org.dstu;

import org.dstu.db.DbPrinted;

public class MainApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must specify input file name!");
            return;
        }
        DbPrinted.populateFromFile(args[0]);
        DbPrinted.demoQuery();
        DbPrinted.dirtyReadDemo();
    }
}

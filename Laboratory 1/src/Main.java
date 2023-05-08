import domain.Book;
import domain.Magazine;
import domain.PrintedType;
import util.CSVReader;
import util.SerializeUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must specify data file name and serialize file name!");
            return;
        }

        String sourceFile = args[0];
        String binFile = args[1];

        List<String[]> strings = CSVReader.readCsvFile(sourceFile, ";");
        List<PrintedType> printed = new ArrayList<>();
        for (String[] line: strings) {
            if (line[0].equals("0")) {
                printed.add(new Book(line));
            } else {
                printed.add(new Magazine(line));
            }
        }
        printed.forEach(System.out::println);

       SerializeUtils.serialize(printed, binFile);
        List<PrintedType> newPrinted = (List<PrintedType>) SerializeUtils.deserialize(binFile);
        System.out.println("Новые печатные издания:");
        newPrinted.forEach(System.out::println);
    }
}
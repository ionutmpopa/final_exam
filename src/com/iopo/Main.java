package com.iopo;


import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final String MY_FILE = "resources" + File.separator + "testfile.csv";

    public static void main(String[] args) {

        valuesForPackages();

        new Thread(new Runnable() {
            @Override
            public void run() {
                groupByValues();

            }
        }).start();
    }


    private static void groupByValues() {
        ImportFromFile myData = new ImportFromFile();
        List<Package> importedData = myData.readFromFileAndPassResultsToList(MY_FILE, false);

        Map<String, List<Package>> map = importedData.stream().collect(
                Collectors.groupingBy(row -> row.toString()));

        System.out.println(map);


    }

    public static void valuesForPackages() {
        ImportFromFile myData = new ImportFromFile();
        List<Package> importedData = myData.readFromFileAndPassResultsToList(MY_FILE, false);

        int sum = 0;

        for (int i = 0; i < importedData.size(); i++) {
            sum = sum + importedData.get(i).getPackageValue();
        }

        System.out.println("Total sum of all delivered packages is: " + sum);

    }
}

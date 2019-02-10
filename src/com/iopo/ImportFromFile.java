package com.iopo;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImportFromFile {

    private Package myPackage;

    public Package getPackage() {
        return myPackage;
    }

    public List<Package> readFromFileAndPassResultsToList(String fileToBeParsed, boolean headerTrueOrFalse) {

        List<Package> myEmList = new ArrayList<>();
        Path theFile = Paths.get(fileToBeParsed);

        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(theFile, charset)) {

            String line;
            int iteration = 0;
            while ((line = reader.readLine()) != null) {
                if (headerTrueOrFalse) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                }
                Package myPack = buildPackageList(line);
                myEmList.add(myPack);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return myEmList;
    }

    public Package buildPackageList(String expression) {

        List<Package> myPackList = new ArrayList<>();

        String[] myFirstSplit = expression.split("\n");

        for (String myLine : myFirstSplit) {

            String[] mySecondSplit = myLine.split(",");

            Integer myIntValue = Integer.parseInt(mySecondSplit[1]);
            Integer mySecondIntValue = Integer.parseInt(mySecondSplit[2]);

            Package eachPackage = new Package(mySecondSplit[0], myIntValue, mySecondIntValue, mySecondSplit[3]);

            myPackList.add(eachPackage);

            for (Package eachPack : myPackList) {
                myPackage = eachPack;
                return myPackage;
            }
        }
        return null;
    }

}

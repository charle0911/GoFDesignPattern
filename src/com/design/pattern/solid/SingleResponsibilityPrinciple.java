package com.design.pattern.solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int cnt = 0;

    public void addEntry(String text) {
        entries.add("" + (++cnt) + ": " + text);
    }

    public void removeEntry(int idx) {
        entries.remove(idx);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    public void save(String fileName) throws FileNotFoundException {
        try (PrintStream out = new PrintStream((fileName))) {
            out.println(toString());
        }
    }

    public void load(String fileName) {
    }

    public void load(URL url) {
    }
}

class Persistence {
    public void saveToFile(Journal journal, String fileName, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream(fileName)){
                out.println(journal.toString());
            }
        }
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) throws IOException {
        Journal j = new Journal();
        j.addEntry("Today is first day of week");
        j.addEntry("Today is last day of week");
        System.out.println(j);


        Persistence p = new Persistence();
        String fileName = "D:\\journal.txt";
        try {
            p.saveToFile(j, fileName, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().exec("notepad.exe " + fileName);
    }
}

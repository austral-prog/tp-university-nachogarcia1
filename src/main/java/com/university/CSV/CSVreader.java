package com.university.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVreader {

    private String filename;
    private List<String[]> allData = new ArrayList<String[]>();

    public CSVreader(String filename) {
        this.filename = filename;
    }

    public void read(String delimiter){

        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(delimiter);
                allData.add(data);
            }

        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

    }
    public List<String[]> getData() {
        return allData;
    }
}

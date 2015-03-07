package mschulkind.smile_test;

import java.io.*;
import smile.data.parser.*;
import smile.data.*;

public class App {
    public static void main( String[] args ) {
        try {
            DelimitedTextParser parser = new DelimitedTextParser();
            parser.setColumnNames(true);
            parser.setDelimiter(",");
            parser.setResponseIndex(new NumericAttribute("MEDV"), 13);

            Dataset dataset = parser.parse("housing.csv");

            System.out.println("FOO!");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

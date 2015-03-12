package mschulkind.smile_test;

import java.io.*;
import smile.data.parser.*;
import smile.data.*;
import smile.regression.*;

public class App {
    public static void main( String[] args ) {
        try {
            DelimitedTextParser parser = new DelimitedTextParser();
            parser.setColumnNames(true);
            parser.setDelimiter(",");
            parser.setResponseIndex(new NumericAttribute("MEDV"), 13);

            AttributeDataset dataset = parser.parse("housing.csv");

            double[][] x = dataset.toArray(new double[dataset.size()][]);
            double[] y = dataset.toArray(new double[dataset.size()]);

            System.out.println("before generating forest");
            RandomForest forest = 
                new RandomForest(dataset.attributes(), x, y, 200);
            System.out.println("after generating forest");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

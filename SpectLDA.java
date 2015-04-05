package homework3;

import java.util.Scanner;

import shared.DataSet;
import shared.Instance;
import shared.filt.IndependentComponentAnalysis;
import shared.filt.LinearDiscriminantAnalysis;
import util.linalg.Matrix;
import util.linalg.RectangularMatrix;

/**
 * A class for testing
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @author Pujun Bhatnagar
 * @version 1.0
 */
public class SpectLDA {
    
    /**
     * The test main
     * @param args ignored
     */
	
    public static void main(String[] args) {
    	int numInstances = 267;
    	int numAttributes = 22;
    	String fileLocation = "src/Homework3/SPECT.txt";
    	DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation, true).getIntanceArray());
    	LinearDiscriminantAnalysis filter = new LinearDiscriminantAnalysis(set);
        filter.filter(set);
        System.out.println(filter.getProjection());
        System.out.println("After LDA");
        System.out.println(set);
        filter.reverse(set);
        System.out.println("After reconstructing");
        System.out.println(set);
    }

}
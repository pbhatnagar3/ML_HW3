package homework3;

import java.util.Scanner;

import shared.DataSet;
import shared.Instance;
import shared.filt.IndependentComponentAnalysis;
import util.linalg.Matrix;
import util.linalg.RectangularMatrix;

/**
 * A class for testing
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @author Pujun Bhatnagar
 * @version 1.0
 */
public class SpectICA {
    
    /**
     * The test main
     * @param args ignored
     */
	
    public static void main(String[] args) {
    	int numInstances = 267;
    	int numAttributes = 22;
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number of reduced dimentions: ");
    	int numReducedDimentions = scan.nextInt();
    	String fileLocation = "src/Homework3/SPECT.txt";
    	DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray());
        System.out.println("Before ICA");
        System.out.println(set);
        IndependentComponentAnalysis filter = new IndependentComponentAnalysis(set, numReducedDimentions);
        filter.filter(set);
        System.out.println("After ICA");
        System.out.println(set);
          
    }

}
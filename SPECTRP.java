package homework3;
/**
 * to apply random projections to Ionosphere data set 
 * @author Pujun Bhatnagar
 *
 */


import java.io.BufferedReader;
import java.io.FileReader;


import java.util.Scanner;

import shared.DataSet;
import shared.Instance;
import shared.filt.RandomizedProjectionFilter;
public class SpectRP {

	public static void main(String[] args){
		int numInstances = 267;
		int numAttributes = 23;
		String fileLocation = "src/Homework3/SPECT.txt";
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number of reduced dimentions: ");
    	int numReducedDimentions = scan.nextInt();
		DataSet dataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
		DataSet backupDataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
		System.out.println("Before Randomized projections");
		System.out.println(dataSet);
		RandomizedProjectionFilter filter = new RandomizedProjectionFilter(numReducedDimentions, numAttributes);
		System.out.println("Randomized vectors to which data will be projected");
		System.out.println(filter.getProjection().transpose());
		System.out.println("\n**********\n");
		filter.filter(dataSet);
		System.out.println("\n**********\n");
		System.out.println(dataSet);
		System.out.println("\n**********\n");
		filter.reverse(dataSet);
		System.out.println("original values");
		System.out.println(backupDataSet);
		System.out.println("compare it to");
		System.out.println("filtered and reverse filtered result");
		System.out.println(dataSet);
	}
}

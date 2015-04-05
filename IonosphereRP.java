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
/**
 * 
 * @author Pujun Bhatnagar
 *
 */

public class IonosphereRP {

	public static void main(String[] args){
		int numInstances = 351;
		int numAttributes = 34;
		String fileLocation = "src/Homework3/ionosphere.txt";
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number of reduced dimentions: ");
    	int numReducedDimentions = scan.nextInt();
		// will create an array of all the instances
		//since we will have to create a set from the instances
		
		DataSet dataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
		DataSet backupDataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
		System.out.println("Before Randomized projections\n");
//		System.out.println(dataSet);
		RandomizedProjectionFilter filter = new RandomizedProjectionFilter(numReducedDimentions, numAttributes);
		System.out.println("Randomized vectors to which data will be projected");
		System.out.println(filter.getProjection().transpose());
		System.out.println("\n**********\n");
		filter.filter(dataSet);
		System.out.println("\n**********\n");
		System.out.println("Projected Data");
		System.out.println(dataSet);
		System.out.println("\n**********\n");
//		filter.reverse(dataSet);
//		System.out.println(dataSet);
	}
}

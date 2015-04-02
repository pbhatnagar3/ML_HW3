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
public class SPECTRP {

	public static void main(String[] args){
		int numInstances = 267;
		int numAttributes = 23;
		String fileLocation = "src/Homework3/SPECT.txt";
		// will create an array of all the instances
		//since we will have to create a set from the instances
		
		DataSet dataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
		DataSet backupDataSet = new DataSet((new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray()));
//		System.out.println("Before Randomized projections");
//		System.out.println(dataSet);
		RandomizedProjectionFilter filter = new RandomizedProjectionFilter(7, numAttributes);
//		System.out.println("Randomized vectors to which data will be projected");
//		System.out.println(filter.getProjection().transpose());
//		System.out.println("\n**********\n");
		filter.filter(dataSet);
//		System.out.println("\n**********\n");
//		System.out.println(dataSet);
//		System.out.println("\n**********\n");
//		System.out.println("BACKUP DATASET");
//		System.out.println(backupDataSet);
		filter.reverse(dataSet);
		System.out.println("original values");
		System.out.println(backupDataSet.get(0));
		System.out.println("compare it to");
		System.out.println("filtered and reverse filtered result");
		System.out.println(dataSet.get(0));
	}
}

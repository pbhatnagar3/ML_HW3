package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import shared.Instance;
/**
 * Reading the dataset from the specified file Location
 * @author Pujun Bhatnagar
 *
 */

public class CreateDataSet {

	Instance[] instances;
	public CreateDataSet(int numInstances, int numAttributes, String fileLocation){
		instances = new Instance[numInstances];
	
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			for(int i = 0; i < numInstances; i++){
				Scanner scan = new Scanner(br.readLine());
				scan.useDelimiter(",");	
				double[] attributes = new double[numAttributes];
				for(int j = 0; j < numAttributes; j++){
					attributes[j] = Double.parseDouble(scan.next());
				}
				//add the attribute array to the instance array as an instance				
				instances[i] = new Instance(attributes);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Instance[] getIntanceArray(){
		return instances;
	}
	
}

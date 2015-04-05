package homework3;

import shared.DataSet;
import shared.Instance;

/**
 * Finds the root mean squared error of two datasets
 * @author Pujun Bhatnagar
 *
 */
public class RootMeanSquaredError {

	private static double errorValue;
	private static double numInstances;
	public static double calculateRMSError(DataSet s1, DataSet s2){
		errorValue = 0;
		numInstances = 0;
		for(int i = 0; i< s1.size(); i++){
			Instance i1 = s1.get(i);
			Instance i2 = s2.get(i);
			for(int j = 0; j< i1.size(); j++){
				errorValue += Math.pow(Math.abs(i1.getContinuous(j)-i2.getContinuous(j)), 2);
				numInstances += 1;
			}
		}
		return Math.sqrt(errorValue/ numInstances);
		
	}
	
}

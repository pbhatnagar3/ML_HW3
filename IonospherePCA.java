package homework3;

import java.util.Scanner;

import shared.DataSet;
import shared.Instance;
import shared.filt.PrincipalComponentAnalysis;
import util.linalg.Matrix;

/**
 * A class for testing
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @author Pujun Bhatnagar
 * @version 1.0
 */
public class IonospherePCA {
    
    /**
     * The test main
     * @param args ignored
     */
    public static void main(String[] args) {
    	int numInstances = 351;
    	int numAttributes = 34;
    	String fileLocation = "src/Homework3/ionosphere.txt";
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number of reduced dimentions: ");
    	int numReducedDimentions = scan.nextInt();
        DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray());
        System.out.println("Before PCA");
        System.out.println(set);
        PrincipalComponentAnalysis filter = new PrincipalComponentAnalysis(set);
        System.out.println(filter.getEigenValues());
        System.out.println(filter.getProjection().transpose());
        filter.filter(set);
        System.out.println("After PCA");
        System.out.println(set);
        Matrix reverse = filter.getProjection().transpose();
        for (int i = 0; i < set.size(); i++) {
            Instance instance = set.get(i);
            instance.setData(reverse.times(instance.getData()).plus(filter.getMean()));
        }
        System.out.println("After reconstructing");
        System.out.println(set);
        
    }

}


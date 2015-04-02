package homework3;

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
public class IonosphereICA {
    
    /**
     * The test main
     * @param args ignored
     */
	
    public static void main(String[] args) {
    	int numInstances = 351;
    	int numAttributes = 34;
    	String fileLocation = "src/Homework3/ionosphere.txt";
        DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray());
        System.out.println("Before randomizing");
        System.out.println(set);
        Matrix projection = new RectangularMatrix(new double[][]{ {.6, .6}, {.4, .6}});
        for (int i = 0; i < set.size(); i++) {
            Instance instance = set.get(i);
            instance.setData(projection.times(instance.getData()));
        }
        System.out.println("Before ICA");
        System.out.println(set);
        IndependentComponentAnalysis filter = new IndependentComponentAnalysis(set, 1);
        filter.filter(set);
        System.out.println("After ICA");
        System.out.println(set);
          
    }

}
package homework3;

/*
 * public void setReduceProjectionMatrixSize(int numEigenVectors) {
		// TODO Auto-generated method stub
		updatedProjection = new RectangularMatrix(numEigenVectors, projection.m()); 
		for(int i = 0; i < numEigenVectors; i++){
			updatedProjection.setRow(i, projection.getRow(i));
		}
		Matrix temp = projection;
		projection = updatedProjection;
		updatedProjection = temp;
	}
 */

import java.util.ArrayList;
import java.util.Scanner;

import shared.DataSet;
import shared.Instance;
import shared.filt.PrincipalComponentAnalysis;
import util.linalg.Matrix;
import util.linalg.RectangularMatrix;

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
        DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray());
        System.out.println("Before PCA");
//        System.out.println(set);
        Scanner scan = new Scanner(System.in);
        PrincipalComponentAnalysis filter = new PrincipalComponentAnalysis(set);
        System.out.println(filter.getEigenValues());
        ArrayList<Double> mainDiagonalValues = MainDiagonalValues.getMainDiagonal(filter.getEigenValues());
        System.out.println(mainDiagonalValues);
        System.out.println(filter.getProjection().transpose());
        System.out.println("projection matrix dimensions are " + filter.getProjection().m() + " and " + filter.getProjection().n());
        System.out.println("enter the proposed number of eigenvectors to use: ");
        filter.setReduceProjectionMatrixSize(scan.nextInt());
        System.out.println(filter.getProjection().transpose());
        System.out.println("projection matrix dimensions are " + filter.getProjection().m() + " and " + filter.getProjection().n());
        System.out.println("does the updated eigenvector matrix look okay. Hit Y to continue: ");
        scan.next();
        filter.filter(set);
        System.out.println("After PCA");
        System.out.println(set);
        Matrix reverse = filter.getProjection().transpose();
        for (int i = 0; i < set.size(); i++) {
            Instance instance = set.get(i);
            instance.setData(reverse.times(instance.getData()).plus(filter.getMean()));
        }
        System.out.println("After reconstructing");
//        System.out.println(set);
        
    }

}


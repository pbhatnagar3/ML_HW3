package homework3;

import java.util.ArrayList;
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
public class SpectPCA {

	/**
	 * The test main
	 * @param args ignored
	 */
	public static void main(String[] args) {
		int numInstances = 267;
		int numAttributes = 22;
		String fileLocation = "src/Homework3/SPECT.txt";
		DataSet set = new DataSet(new CreateDataSet(numInstances, numAttributes, fileLocation).getIntanceArray());
		System.out.println("Before PCA");
		//        System.out.println(set);
		Scanner scan = new Scanner(System.in);
		PrincipalComponentAnalysis filter = new PrincipalComponentAnalysis(set);
		System.out.println("EIGENVALUE MATRIX: ");
		System.out.println(filter.getEigenValues());
		System.out.println("LIST OF EIGENVALUES: ");
		ArrayList<Double> mainDiagonalValues = MainDiagonalValues.getMainDiagonal(filter.getEigenValues());
		System.out.println(mainDiagonalValues);
		System.out.println("EIGENVECTORS: ");
		System.out.println(filter.getProjection().transpose());
		System.out.println("projection matrix dimensions are " + filter.getProjection().m() + " and " + filter.getProjection().n());
		System.out.println("enter the proposed number of eigenvectors to use: ");
		filter.setReduceProjectionMatrixSize(scan.nextInt());
		System.out.println(filter.getProjection().transpose());
		System.out.println("projection matrix dimensions are " + filter.getProjection().m() + " and " + filter.getProjection().n());
		System.out.println("does the updated eigenvector matrix look okay. Hit Y to continue: ");
		scan.next();
		System.out.println("TRANSFORMED DATA: ");
		filter.filter(set);
		System.out.println("After PCA");
		System.out.println(set);
		Matrix reverse = filter.getProjection().transpose();
		for (int i = 0; i < set.size(); i++) {
			Instance instance = set.get(i);
			instance.setData(reverse.times(instance.getData()).plus(filter.getMean()));
		}
		//        System.out.println("After reconstructing");
		//        System.out.println(set);

	}

}




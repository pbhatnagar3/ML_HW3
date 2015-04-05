package homework3;

import java.text.DecimalFormat;
import java.util.ArrayList;

import util.linalg.Matrix;

public class MainDiagonalValues {

	public static void printMainDiagonal(Matrix m){
		for(int i = 0; i< m.m(); i++){
			System.out.println(m.get(i, i));
		}
	}
	
	public static ArrayList<Double> getMainDiagonal(Matrix m){
		ArrayList<Double> output = new ArrayList<Double>();
		DecimalFormat f = new DecimalFormat("##.00");
		for(int i = 0; i< m.m(); i++){
			output.add(Double.parseDouble(f.format(m.get(i, i))));
			
		}
		
		return output;
	}
}

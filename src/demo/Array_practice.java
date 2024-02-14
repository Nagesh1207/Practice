package demo;

import java.util.Scanner;

public class Array_practice {
	public static void main (String[] args) {
		// Define 4 D array with diamention 2x2x2x3
		Scanner scan = new Scanner(System.in);
		int [][][][] hiru = {{{{1,2,3},{4,3,2}},{{0,1,2},{3,2,1}}},
				{{{1,2,3},{2,3,4}},{{5,6,7},{8,6,5}}}};

		
		//	System.out.println(hiru[1][2][0][0]);
		for (int [][][]subArray3D : hiru)
		{	//scan.nextLine();
			for (int [][] subArray2D: subArray3D) {
				for(int [] subArray : subArray2D) {
					for (int value : subArray) {
						System.out.println("value of" + scan.nextLine() + value);
						//System.out.println(value);
					}
				}
			}
		}
		
	}

}

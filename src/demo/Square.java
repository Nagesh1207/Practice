package demo;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		int n=6;
		for( i=n;i>=1;i++) {
			System.out.print("*");

			for( j=1;j< n-i;j++) {
				System.out.print(" ");
			}
			for(j=0;j<=n;j++) {
				System.out.println();
			}
		}
}
}
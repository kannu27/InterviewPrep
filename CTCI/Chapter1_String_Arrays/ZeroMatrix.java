import java.util.Scanner;

public class ZeroMatrix {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[][] matrix  = new int[n][m];
		
		
		//get 
		for(int i = 0; i <n; i++){
			for(int j = 0; j <m; j++){
				matrix[i][j] = in.nextInt();
			}
			
		}
		printArray(matrix);
		//zeroMatrixBigO_SPACE_N(matrix);
		zeroMatrixBigO_SPACE_1(matrix);
		printArray(matrix);
		
		
	}

	private static void zeroMatrixBigO_SPACE_1(int[][] matrix) {
		boolean rowFirstZero = false;
		boolean colFirstZero = false;
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		//Check for first column for zero
		for(int i = 0; i < n; i++){
			if(matrix[i][0]==0){
				colFirstZero = true;
				break;
			}
		}
		
		//Check for first row for zero
		for(int i = 0; i < m; i++){
			if(matrix[0][i]==0){
				rowFirstZero = true;
				break;
			}
		}
		
		//check for the rest of the array
		for(int i = 1; i < n;i++){
			for(int j = 1; j < m; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] =0;
					matrix[0][j] =0;
				}
			}
		}
		printArray(matrix);
		//nullify the columns based on the first row 
		for(int i = 1; i < m; i++){
			if(matrix[0][i]==0){
				nullifyCol(matrix, i);
			}
		}
		System.out.println("nullify the columns based on the first row ");
		printArray(matrix);
		//nullify the rows based on the first column 
				for(int i = 1; i < n; i++){
					if(matrix[i][0]==0){
						nullifyRow(matrix, i);
					}
				}
		
	System.out.println("nullify the rows based on the first column  ");
		if(rowFirstZero){
			nullifyRow(matrix, 0);
		}
		
		if(colFirstZero){
			nullifyCol(matrix, 0);
		}
		
	}

	private static void printArray(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

	private static void zeroMatrixBigO_SPACE_N(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[] rowArray = new int[n];
		
		int[] colArray = new int[m];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(matrix[i][j] == 0){
					rowArray[i] = 1;
					colArray[j] = 1;
				}
			}
		}
		
		//nullify the recorded row
		for(int i = 0; i < n; i++){
			if(rowArray[i] == 1){
				nullifyRow(matrix, i);
			}
			
		}
		
		//nullify the recorded columns
		for(int i = 0; i < m; i++){
			if(colArray[i] == 1){
				nullifyCol(matrix, i);
			}
		
			
		}
		
	}

	private static void nullifyCol(int[][] matrix, int col) {
		int n = matrix.length;
		for(int row = 0; row < n; row ++){
			matrix[row][col] =0;
		}
		
		
	}

	private static void nullifyRow(int[][] matrix, int row) {
		int m = matrix[0].length;
		for(int col = 0; col < m; col ++){
			matrix[row][col] =0;
		
		}

		}
	
}

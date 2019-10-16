package assignment.three;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int n;
    private boolean[][] matrix;

    public Matrix(int n){
        this.n = n;
        this.matrix = createMatrix(this.n);
    }


    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private boolean[][] createMatrix(int n){
        boolean[][] ret = new boolean[n][n];
        Scanner key = new Scanner(System.in);
        System.out.println("Enter each row of the matrix one row at a time.");
        for(int i = 0; i < n; i++){
            String temp = key.nextLine();
            boolean[] toPush = new boolean[n];
            int count = 0;
            for(int j = 0; j < temp.length(); j++){
                if(temp.charAt(j) == '1'){
                    toPush[count] = true;
                    count++;
                }else if(temp.charAt(j) == '0'){
                    toPush[count] = false;
                    count++;
                }else {

                }

            }
            for(int k = 0; k < toPush.length; k++){
                ret[i][k] = toPush[k];
            }
        }
        return ret;
    }
}

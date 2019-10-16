package assignment.three;

import java.util.Scanner;

public class Matrix {
    private int n;
    private boolean[][] matrix;

    public Matrix(int n){
        this.n = n;
        this.matrix = createMatrix(this.n);
    }

    public void setMatrix(boolean[][] newMatrix){
        this.matrix = newMatrix;
    }

    public void printMatrix(){
        String out = "";
        for(int i = 0; i < n; i++){
            out += "[";
            for(int j = 0; j < this.matrix[i].length; j++){
                if(this.matrix[i][j]){
                    out += "1, ";
                }else{
                    out += "0, ";
                }
            }
            out = out + "] \n";
        }
        System.out.println(out);
    }



    public void calculation(){
        boolean[][] finalMatrix = this.matrix;
        boolean[][] newMatrix = this.matrix;

        for(int i = 0; i <= n; i++) {
            newMatrix = booleanProduct(newMatrix);
            finalMatrix = orMatrices(finalMatrix , newMatrix);
        }
        setMatrix(newMatrix);
        System.out.println("A^n");
        printMatrix();
        System.out.println();
        setMatrix(finalMatrix);
    }

    private boolean[][] orMatrices(boolean[][] finalM , boolean[][] newM){
        boolean[][] ret = new boolean[n][n];

        for(int i = 0; i < finalM.length; i++){
            for(int k = 0; k < finalM[i].length; k++){
                ret[i][k] = (finalM[i][k] || newM[i][k]);
            }
        }
        return ret;
    }

    private boolean[][] booleanProduct(boolean[][] matrixA) {
        boolean[][] ret = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                ret[i][j] = false;

                for (int k = 0; k < n; k++) {
                    if(this.matrix[i][k] && matrixA[k][j]){
                        ret[i][j] = true;
                        break;
                    }
                }
            }
        }
        return ret;
    }



    // Creates the actual matrix and handles the conversion from strings of 1's and 0's into boolean values
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

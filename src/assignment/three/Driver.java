package assignment.three;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer n");
        int temp = keyboard.nextInt();
        Matrix test = new Matrix(temp);
        test.printMatrix();
    }
}

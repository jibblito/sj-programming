// We boolin wit some ODD SQUAIYRES

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Lab15 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter How Long You Desire Your Thingy (its gotta be odd)!: ");
        int size = scanner.nextInt();

        if(size%2 == 0) {

            size += 1;
            System.out.println("Sorry buddy, your number was changet to " + size + " ... thanks for following DIRECTIONS!");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("\n" + size + " x " + size + " GRID");
        for(int i = 0; i < size; i++) System.out.print("=== ");
        System.out.println();

        Magic m = new Magic();
        int[][] table = m.computeMagicSquare(size);

        m.displayIntMatrix(table);
        m.checkRows();
        m.checkColumns();
        m.checkHorizontal();

    }

}

class Magic {

    int col;
    int row;
    int[][] matrix;

    public int[][] computeMagicSquare(int size) {

        matrix = new int[size][size];
        col = size/2;
        row = 0;

        for(int i = 1; i <= size * size; i++) {

            matrix[row][col] = i;

            col+=1; row -=1;

            if(col == size && row == -1) {
                row +=2; col -=1;
                continue;
            }

            if(col == size) {
                col = 0;
                continue;
            }

            if(row == -1) {
                row = size - 1;
                continue;
            }

            if(checkTakenCell(col, row)) {
                row +=2; col -= 1;
                continue;
            }
        }

        return matrix;
    }

    // UTIL METHODS

    boolean checkTakenCell(int tX, int tY) {
        if(matrix[tY][tX] > 0) return true;
        else return false;
    }

    String addZeros(int a) {

        String s = "";
        String strA = "" + a;

        if(strA.length() > 3) return "OOB";
        for(int j = 0; j <= 2 - strA.length(); j++ ) s += "0";
        s += strA;
        return s;
    }


    // DISPLAY METHODS

    public void displayIntMatrix(int[][] mat) {
        for(int[] i : mat) {
            for(int j : i) {
                System.out.print(addZeros(j) + " ");
            }
            System.out.println();
        }
    }

    // CHECKING METHODS

    void checkRows() {

        System.out.println("\nCHECKING ROWS");
        for(int[] i : matrix) System.out.print("=== ");
        System.out.println();

        for(int[] row : matrix) {

            int sum = 0;
            String s = "";

            for(int i = 0; i < row.length - 1; i++) {

                sum += row[i];
                s += row[i] + " + ";

            }

            sum += row[row.length - 1];
            s += row[row.length - 1] + " = " + sum;
            System.out.println(s);

        }
    }

    void checkColumns() {

        System.out.println("\nCHECKING COLUMNS");
        for(int[] i : matrix) System.out.print("=== ");
        System.out.println();

        for(int i = 0; i <= matrix.length - 1; i++) {

            int sum = 0;
            String s = "";

            for(int j = 0; j < matrix.length - 1; j++) {

                sum += matrix[j][i];
                s += matrix[j][i] + " + ";

            }

            sum += matrix[matrix.length - 1][i];
            s += matrix[matrix.length - 1][i] + " = " + sum;
            System.out.println(s);

        }
    }

    void checkHorizontal() {

        System.out.println("\nCHECKING HORIZONTALS");
        for(int[] i : matrix) System.out.print("=== ");
        System.out.println();

        // BOTTOM-LEFT TO TOP-RIGHT

            int sum = 0;
            String s = "";
            int row = 0; int col = 0;

        for(int j = 0; j < matrix.length - 1; j++) {

            sum += matrix[row][col];
            s += matrix[row][col] + " + ";
            row++; col++;

        }

        sum += matrix[row][col];
        s += matrix[row][col] + " = " + sum;
        System.out.println(s);

        // TOP-LEFT TO BOTTOM-RIGHT

            sum = 0;
            s = "";
            row = matrix.length - 1; col = 0;

        for(int j = 0; j < matrix.length - 1; j++) {

            sum += matrix[row][col];
            s += matrix[row][col] + " + ";
            row--; col++;

        }

        sum += matrix[row][col];
        s += matrix[row][col] + " = " + sum;
        System.out.println(s);
    }

}

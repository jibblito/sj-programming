import java.awt.*;
import java.util.*;

public class DownhillMazeV2 {

    public static void main(String[] args) {

        char[][] testMaze1 = {{'3','3','3','3','2','1','S','8','9'},
                            {'3','1','1','3','3','0','6','8','7'},
                            {'1','2','2','4','3','2','5','9','7'},
                            {'1','2','1','5','4','3','4','4','6'},
                            {'1','1','X','6','4','4','5','5','5'}};

        char[][] testMaze2 = {{'S','7','6','5'},
                                {'6','9','9','5'},
                                {'9','9','9','4'},
                                {'X','1','2','3'}};

        Scanner input = new Scanner(System.in);

        System.out.println("Enter row column below.");

        String rc = input.nextLine();
        String[] row1 = rc.split(" ");
        int rows = Integer.parseInt(row1[0]);
        int cols = Integer.parseInt(row1[1]);

        char[][] maze = new char[rows][cols];

        System.out.println();
        System.out.println("Enter matrix with [ROWS:" + rows + " COLUMNS:" + cols + "] below.");

        for(int i = 0; i < rows; i++) {

            String[] sChars = input.nextLine().split(" ");

            for(int j = 0; j < cols; j++) {

                maze[i][j] = sChars[j].charAt(0);

            }

        }

        MazeSolverV2 solver = new MazeSolverV2(testMaze1);
        System.out.println();
        displayCharMatrix(testMaze1);
        displayCharMatrix(solver.returnSolvedMaze());

    }

    static void displayCharMatrix(char[][] mat) {
        System.out.println();
        for(char[] i : mat) {
            for(char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class MazeSolverV2 {

    char[][] mazeToBeSolved;
    char[][] solvedMaze;
    int rows; int cols;
    Point start;
    Point finish;
    int row, col;
    char val;

    public MazeSolverV2(char[][] inpMaze){

        rows = inpMaze.length;
        cols = inpMaze[0].length;

        mazeToBeSolved = inpMaze;
        solvedMaze = new char[rows][cols];
        for(int i = 0; i < rows; i++) {     // fill in blanks
            for(int j = 0; j < cols; j++) {
                solvedMaze[i][j] = '#';
            }
        }

        start = findStart();
        finish = findFinish();

        mazeToBeSolved[start.x][start.y] = '9';
        mazeToBeSolved[finish.x][finish.y] = '0';

        System.out.println("FINISH: " + finish.x + ", " + finish.y);
        System.out.println(solveMaze(start.x,start.y, start));

    }

    boolean found = false;

    boolean solveMaze(int row, int col, Point lastCell) {

        System.out.println(row + ", " + col);

        char right, left, up, down, current;

        try { right = mazeToBeSolved[row][col + 1]; } catch (IndexOutOfBoundsException e) { right = 'A'; }
        try { down = mazeToBeSolved[row + 1][col]; } catch (IndexOutOfBoundsException e) { down = 'A'; }
        try { left = mazeToBeSolved[row][col - 1]; } catch (IndexOutOfBoundsException e) { left = 'A'; }
        try { up = mazeToBeSolved[row - 1][col]; } catch (IndexOutOfBoundsException e) { up = 'A'; }

        current = mazeToBeSolved[row][col];

        boolean r,d,l,u;

        if (compareChars(current, right) && !(lastCell.x == row && lastCell.y == col + 1) && !found) {
            r = solveMaze(row, col + 1, new Point(row, col));
        } else r = false;

        if (compareChars(current, down) && !(lastCell.x == row + 1 && lastCell.y == col) && !found) {
            d = solveMaze(row + 1, col, new Point(row, col));
        } else d = false;

        if (compareChars(current, left) && !(lastCell.x == row && lastCell.y == col - 1) && !found) {
            l = solveMaze(row, col - 1, new Point(row, col));
        } else l = false;

        if (compareChars(current, up) && !(lastCell.x == row - 1 && lastCell.y == col) && !found) {
            u = solveMaze(row - 1, col, new Point(row, col));
        } else u = false;

        if (row == finish.x && col == finish.y)  {
            found = true;
            return true;
        }

        if (r || l || u || d) solvedMaze[row][col] = '.';
        return (r || l || u || d);

    }

    boolean compareChars(char current, char compared) {     // false if impossible

        if((int) current < (int) compared) return false;
        else return true;

    }


    Point findStart() {
        Point search = new Point();
        for(int i = 0; i < cols; i++) {
            if(mazeToBeSolved[0][i] == 'S') { search = new Point(0,i); break; }
            else search = new Point(999,999);
        }
        return search;
    }

    Point findFinish() {
        Point search = new Point();
        for(int i = 0; i < cols; i++) {
            if(mazeToBeSolved[rows-1][i] == 'X') { search = new Point(rows - 1, i); break; }
            else search = new Point(999,999);
        }
        return search;
    }

    public char[][] returnSolvedMaze() {
        solvedMaze[start.x][start.y] = 'S';
        solvedMaze[finish.x][finish.y] = 'X';
        return solvedMaze; }

}

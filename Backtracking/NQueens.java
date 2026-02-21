import java.util.*;
public class NQueens{
    public static void printBoard(char board[][]){
       System.out.println("==Chess Board==");
       for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        } 
    }
    public static boolean isSafe(char board[][], int row, int col){
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q')
                return false;
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                nQueens(board, row+1);
                board[row][col] = 'X';
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = in.nextInt();
        char board[][] = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
        in.close();
    }
}
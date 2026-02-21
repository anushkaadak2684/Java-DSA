import java.util.*;
public class NQueensII{
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
    public static boolean nQueens(char board[][], int row){
        if(row == board.length){
            return true;
        }
        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                if(nQueens(board, row+1))
                    return true;
                board[row][col] = 'X';
            }
        }
        return false;
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
        if(nQueens(board, 0)){
            System.out.println("Soltution exists...");
            printBoard(board);
        }
        else{
            System.out.println("Solution doesn't exist...");
        }
        in.close();
    }
}

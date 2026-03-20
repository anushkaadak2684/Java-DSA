import java.util.*;
public class FloodFill {
    public static void helper(int image[][], int sr, int sc, int origColor, int newColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;
        if(image[sr][sc] != origColor)
            return;
        image[sr][sc] = newColor;
        
        helper(image, sr, sc-1, origColor, newColor);
        helper(image, sr, sc+1, origColor, newColor);
        helper(image, sr-1, sc, origColor, newColor);
        helper(image, sr+1, sc, origColor, newColor);
    }

    public static void floodFill(int image[][], int sr, int sc, int newColor) {
        if(newColor == image[sr][sc])
            return;
        helper(image, sr, sc, image[sr][sc], newColor);
    }

    public static void printImage(int image[][]){
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++)
                System.out.print(image[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = in.nextInt();
        System.out.print("Enter n: ");
        int n = in.nextInt();

        int image[][] = new int[m][n];
        System.out.println("Enter the pixels: ");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                image[i][j] = in.nextInt();
        }

        System.out.print("Enter the starting row: ");
        int sr = in.nextInt();
        System.out.print("Enter the starting column: ");
        int sc = in.nextInt();
        System.out.print("Enter the new color: ");
        int newColor = in.nextInt();

        System.out.println("Before flood filling: ");
        printImage(image);

        floodFill(image, sr, sc, newColor);
        System.out.println("After flood filling: ");
        printImage(image);
        in.close();
    }
}

public class SpiralMatrix{
    public static void spiralMatrix(int matrix[][]){
        int sr=0, sc=0, er=matrix.length-1, ec=matrix[0].length-1;
        while(sr<=er && sc<=ec){
            for(int j=sc; j<=ec; j++){
                System.out.print(matrix[sr][j]+" ");
            }
            for(int i=sr+1; i<=er; i++){
                System.out.print(matrix[i][ec]+" ");
            }
            for(int j=ec-1; j>=sc; j--){
                if(sr == er)
                    break;
                System.out.print(matrix[er][j]+" ");
            }
            for(int i=er-1; i>=sr+1; i--){
                if(sc == ec)
                    break;
                System.out.print(matrix[i][sc]+" ");
            }
            sr++; er--; sc++; ec--;
        }
    }
    public static void main(String[] args){
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        spiralMatrix(matrix);
    }
}

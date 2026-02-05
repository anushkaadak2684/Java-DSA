public class DiagonalSumOptimized {
    public static void diagonalSum(int matrix[][]){
        int sum=0;
        for(int i=0; i<matrix.length; i++){
            sum += matrix[i][i];
            if(i != matrix.length-1-i)
                sum += matrix[i][matrix.length-1-i];
        }
        System.out.println("Diagonal Sum: "+ sum);
    }
    public static void main(String[] args){
        int matrix[][] = {{10, 20, 30},
                          {15, 25, 35},
                          {27, 29, 37}};
        diagonalSum(matrix);
    }
}


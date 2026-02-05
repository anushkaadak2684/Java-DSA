public class DiagonalSum {
    public static void diagonalSum(int matrix[][]){
        int sum=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(i==j || (i+j)==matrix.length-1)
                    sum+=matrix[i][j];
            }
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

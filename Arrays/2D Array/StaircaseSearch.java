public class StaircaseSearch{
    public static void staircase(int matrix[][], int key){
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == key){
                System.out.println("Key found");
                return;
            }
            else if(matrix[i][j] > key)
                j--;
            else
                i++;
        }
        System.out.println("Key NOT found");
    }
    public static void main(String[] args){
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        int key = 33;
        staircase(matrix, key);
    }
}


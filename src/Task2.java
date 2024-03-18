import java.util.Random;

public class Task2 {
    private final Random random = new Random();
    public Task2(int row, int column){
        int[][] matrix = makeMatrix(row, column);
        printMatrix(matrix);
    }
    private int[][] makeMatrix(int row, int column){
        int[][] temp_matrix = new int[row][column];
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    temp_matrix[i][j] = random.nextInt(100);
                }
            }
        return temp_matrix;
    }
    private void printMatrix(int[][] matrix){
        System.out.println("Your Matrix: ");
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}

public class Utils {
    public int[][] filterBrightness(int[][] pixelArray, int threshold) {
        int height = pixelArray.length;
        int width = pixelArray[0].length;

        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = (pixelArray[i][j] > threshold) ? 1 : 0;
            }
        }

        return result;
    }
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

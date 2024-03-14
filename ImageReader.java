import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    public static int[][] read(String filename) throws IOException {
        File file = new File(filename);
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        int[][] pixelArray = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color c = new Color(image.getRGB(x,y));
                int average = (c.getRed()+c.getBlue()+ c.getGreen()) / 3;
                pixelArray[y][x] = average;
            }
        }

        return pixelArray;
    }
    public  void saveImage(int[][] pixelArray, String filename) throws IOException {
        int width = pixelArray[0].length;
        int height = pixelArray.length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int value = pixelArray[y][x];
                int rgb = (value == 0) ? 0xFFFFFF : 0x000000;
                image.setRGB(x, y, rgb);
            }
        }

        File outputFile = new File(filename);
        ImageIO.write(image, "png", outputFile);
    }
}

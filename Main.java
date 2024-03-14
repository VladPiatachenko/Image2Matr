import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ImageReader ir=new ImageReader();
        Utils u=new Utils();
        int[][]image=ir.read("coa8.png");
        u.printMatrix(image);
        int[][]grayscale=u.filterBrightness(image,127);
        u.printMatrix(grayscale);
        ir.saveImage(grayscale,"mask.png");
    }
}

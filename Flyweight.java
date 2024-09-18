import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Flyweight {
    private static Map<BoothSize, Image> imageMap = new HashMap<>();

    public static Image getImg(BoothSize size) {
        Image img = imageMap.get(size);
        if (img == null) {
            img = createImage(size);
            imageMap.put(size, img);
        }
        return img;
    }

    private static Image createImage(BoothSize size) {
        int dimension = size.getDimension();
        Color color = size.getColor();

        // Create an image with the specified dimension and color
        BufferedImage img = new BufferedImage(
                dimension, dimension, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();

        // Set the color from the BoothSize enum
        g2d.setColor(color);
        g2d.fillRect(0, 0, dimension, dimension);
        g2d.dispose();

        return img;
    }
}

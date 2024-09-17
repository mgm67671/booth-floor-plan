import java.awt.Image;
import java.io.Serializable;

public class BoothImage implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Image image;
    private BoothSize size;
    private int dimension;

    public BoothImage(BoothSize size) {
        this.size = size;
        // Determine the dimension based on size
        switch (size) {
            case SMALL:
                dimension = 50;
                break;
            case MEDIUM:
                dimension = 75;
                break;
            case LARGE:
                dimension = 100;
                break;
        }
    }

    public Image getImage() {
        if (image == null) {
            // Create the image as a placeholder (could load an actual image)
            image = new javax.swing.ImageIcon(
                new java.awt.image.BufferedImage(dimension, dimension, java.awt.image.BufferedImage.TYPE_INT_ARGB)
            ).getImage();
        }
        return image;
    }

    public BoothSize getSize() { return size; }
    public int getDimension() { return dimension; }
}

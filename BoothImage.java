import java.awt.Image;

public class BoothImage {
    private Image image;
    private BoothSize size;

    public BoothImage(BoothSize size) {
        this.size = size;
        // Create the image based on size
        // For simplicity, we'll use colored rectangles
        // In a real application, you would load an image file
        int dimension = 0;
        switch (size) {
            case SMALL: dimension = 50; break;
            case MEDIUM: dimension = 75; break;
            case LARGE: dimension = 100; break;
        }
        image = new javax.swing.ImageIcon(
            new java.awt.image.BufferedImage(dimension, dimension, java.awt.image.BufferedImage.TYPE_INT_ARGB)
        ).getImage();
    }

    public Image getImage() { return image; }
    public BoothSize getSize() { return size; }
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

public class Booth implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient BoothImage boothImage; // Intrinsic state
    private BoothSize size;
    private Position position;               // Extrinsic state
    private String label;

    public Booth(BoothSize size, Position position, String label) {
        this.size = size;
        this.position = position;
        this.label = label;
        this.boothImage = FlyweightFactory.getBoothImage(size);
    }

    public void draw(Graphics g) {
        boothImage = FlyweightFactory.getBoothImage(size); // Ensure boothImage is initialized after deserialization
        Image img = boothImage.getImage();
        int width = boothImage.getDimension();
        int height = boothImage.getDimension();

        // Draw the booth as a colored rectangle
        switch (size) {
            case SMALL:
                g.setColor(Color.GREEN);
                break;
            case MEDIUM:
                g.setColor(Color.BLUE);
                break;
            case LARGE:
                g.setColor(Color.RED);
                break;
        }
        g.fillRect(position.getX(), position.getY(), width, height);
        g.setColor(Color.BLACK);
        g.drawRect(position.getX(), position.getY(), width, height);
        g.drawString(label, position.getX() + 5, position.getY() + 15);
    }

    // Getters and setters
    public BoothSize getSize() { return size; }
    public Position getPosition() { return position; }
    public String getLabel() { return label; }
}

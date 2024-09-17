import java.awt.Graphics;
import java.awt.Image;

public class Booth {
    private BoothImage boothImage; // Intrinsic state
    private Position position;     // Extrinsic state

    public Booth(BoothSize size, Position position) {
        this.boothImage = FlyweightFactory.getBoothImage(size);
        this.position = position;
    }

    public void draw(Graphics g) {
        Image img = boothImage.getImage();
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        g.drawImage(img, position.getX(), position.getY(), null);

        // Draw border and label for visualization
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(position.getX(), position.getY(), width, height);
        g.drawString(boothImage.getSize().name(), position.getX() + 5, position.getY() + 15);
    }

    public BoothSize getSize() { return boothImage.getSize(); }
    public Position getPosition() { return position; }
}

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Booth extends FloorPlanComp {
    private static final long serialVersionUID = 1L;
    BoothSize size;
    int x, y;
    transient Image img;

    public Booth(BoothSize size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        img = Flyweight.getImg(size);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    // Custom deserialization to reinitialize transient fields
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        // Reinitialize the transient image field
        img = Flyweight.getImg(size);
    }
}

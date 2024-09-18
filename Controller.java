import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Controller {
    FloorPlan fp = new FloorPlan();

    public void add(BoothSize size, int x, int y) {
        Booth b = new Booth(size, x, y);
        fp.add(b);
    }

    public void draw(Graphics g) {
        fp.draw(g);
    }

    public void saveFloorPlan(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFloorPlan(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            fp = (FloorPlan) ois.readObject();
            // Reinitialize transient fields
            fp.reinitialize();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FloorPlan getFloorPlan() {
        return fp;
    }
}

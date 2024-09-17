import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Controller {
    private FloorPlan floorPlan;

    public Controller(FloorPlan floorPlan) {
        this.floorPlan = floorPlan;
    }

    public void makeBooth(BoothSize size, Position position, String label) {
        Booth booth = new Booth(size, position, label);
        floorPlan.addBooth(booth);
    }

    public void drawBooths(Graphics g) {
        for (Booth booth : floorPlan) {
            booth.draw(g);
        }
    }

    public void saveFloorPlan(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(floorPlan);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFloorPlan(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            floorPlan = (FloorPlan) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FloorPlan getFloorPlan() {
        return floorPlan;
    }
}

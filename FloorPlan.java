import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloorPlan implements Iterable<Booth>, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Booth> booths;
    private double scale; // Scale of the floor plan (e.g., 1 inch represents 5 feet)

    public FloorPlan(double scale) {
        this.scale = scale;
        booths = new ArrayList<>();
    }

    public void addBooth(Booth booth) {
        booths.add(booth);
    }

    public void removeBooth(Booth booth) {
        booths.remove(booth);
    }

    public double getScale() { return scale; }
    public void setScale(double scale) { this.scale = scale; }

    @Override
    public Iterator<Booth> iterator() {
        return booths.iterator();
    }
}

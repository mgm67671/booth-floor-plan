import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloorPlan implements Iterable<Booth> {
    private List<Booth> booths;

    public FloorPlan() {
        booths = new ArrayList<>();
    }

    public void addBooth(Booth booth) {
        booths.add(booth);
    }

    @Override
    public Iterator<Booth> iterator() {
        return booths.iterator();
    }
}

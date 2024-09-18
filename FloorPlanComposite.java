import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloorPlanComposite extends FloorPlanComponent implements Iterable<FloorPlanComponent> {
    protected List<FloorPlanComponent> components = new ArrayList<>();

    public void add(FloorPlanComponent component) {
        components.add(component);
    }

    public void remove(FloorPlanComponent component) {
        components.remove(component);
    }

    @Override
    public void draw(Graphics g) {
        for (FloorPlanComponent component : components) {
            component.draw(g);
        }
    }

    @Override
    public Iterator<FloorPlanComponent> iterator() {
        return components.iterator();
    }
}

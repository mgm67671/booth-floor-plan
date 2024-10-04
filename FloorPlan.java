import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FloorPlan extends FloorPlanComp {
    private static final long serialVersionUID = 1L;
    Collection<FloorPlanComp> components = new ArrayList<FloorPlanComp>();

    public void add(FloorPlanComp e) {
        components.add(e);
    }

    @Override
    public void draw(Graphics g) {
        Iterator<FloorPlanComp> it = components.iterator();
        while (it.hasNext()) {
            it.next().draw(g);
        }
    }

    // Method to reinitialize transient fields in components after deserialization
    public void reinitialize() {
        for (FloorPlanComp comp : components) {
            if (comp instanceof Booth) {
                ((Booth) comp).img = Flyweight.getImg(((Booth) comp).size);
            }
            // If there are other component types, handle them here
        }
    }
}

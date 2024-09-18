public class FloorPlan extends FloorPlanComp {
    Collection<FloorPlanComp> c = new ArrayList<FloorPlanComp>();

    public void add(FloorPlanComp e) {
        c.add(e);
    }

    public void draw(Graphics g) {
        Iterator<FloorPlanComp> it = c.iterator();

        while(it.hasNext()) 
            it.next().draw(g);
    }
}

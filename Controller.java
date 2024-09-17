import java.awt.Graphics;

public class Controller {
    private FloorPlan floorPlan;

    public Controller(FloorPlan floorPlan) {
        this.floorPlan = floorPlan;
    }

    public void makeBooth(BoothSize size, Position position) {
        Booth booth = new Booth(size, position);
        floorPlan.addBooth(booth);
    }

    public void drawBooths(Graphics g) {
        for (Booth booth : floorPlan) {
            booth.draw(g);
        }
    }
}

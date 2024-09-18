import javax.swing.JPanel;
import java.awt.Graphics;

public class FloorPlanPanel extends JPanel {
    Controller controller;

    public FloorPlanPanel(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        controller.draw(g);
    }
}

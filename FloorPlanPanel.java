import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FloorPlanPanel extends JPanel {
    private Controller controller;
    private BoothSize selectedSize = BoothSize.SMALL; // Default size
    private boolean placingBooth = false;

    public FloorPlanPanel(Controller controller) {
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (placingBooth) {
                    Position position = new Position(e.getX(), e.getY());
                    controller.makeBooth(selectedSize, position);
                    repaint();
                    placingBooth = false;
                }
            }
        });
    }

    public void setSelectedSize(BoothSize size) {
        this.selectedSize = size;
        placingBooth = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw floor plan background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw booths
        controller.drawBooths(g);
    }
}

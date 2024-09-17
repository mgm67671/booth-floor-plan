import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FloorPlanPanel extends JPanel {
    private Controller controller;
    private BoothSize selectedSize = BoothSize.SMALL; // Default size
    private boolean placingBooth = false;
    private String boothLabel = "S1"; // Default label
    private int boothCount = 1;

    public FloorPlanPanel(Controller controller) {
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (placingBooth) {
                    Position position = new Position(e.getX(), e.getY());
                    String label = generateBoothLabel(selectedSize);
                    controller.makeBooth(selectedSize, position, label);
                    repaint();
                    placingBooth = false;
                }
            }
        });
    }

    private String generateBoothLabel(BoothSize size) {
        String prefix = "";
        switch (size) {
            case SMALL:
                prefix = "S";
                break;
            case MEDIUM:
                prefix = "M";
                break;
            case LARGE:
                prefix = "L";
                break;
        }
        return prefix + boothCount++;
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private FloorPlanPanel floorPlanPanel;

    public GUI(Controller controller) {
        setTitle("Booth Floor Plan Designer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        floorPlanPanel = new FloorPlanPanel(controller);

        // Toolbar for selecting booth sizes
        JToolBar toolBar = new JToolBar();
        JButton smallButton = new JButton("Small Booth");
        JButton mediumButton = new JButton("Medium Booth");
        JButton largeButton = new JButton("Large Booth");

        smallButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.SMALL);
        });

        mediumButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.MEDIUM);
        });

        largeButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.LARGE);
        });

        toolBar.add(smallButton);
        toolBar.add(mediumButton);
        toolBar.add(largeButton);

        add(toolBar, BorderLayout.NORTH);
        add(floorPlanPanel, BorderLayout.CENTER);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class GUI extends JFrame {
    private FloorPlanPanel floorPlanPanel;
    private Controller controller;

    public GUI(Controller controller) {
        this.controller = controller;
        setTitle("Booth Floor Plan Designer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        floorPlanPanel = new FloorPlanPanel(controller);

        // Toolbar for selecting booth sizes
        JToolBar toolBar = new JToolBar();
        JButton smallButton = new JButton("Small Booth");
        JButton mediumButton = new JButton("Medium Booth");
        JButton largeButton = new JButton("Large Booth");
        JButton saveButton = new JButton("Save Floor Plan");
        JButton loadButton = new JButton("Load Floor Plan");

        smallButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.SMALL);
        });

        mediumButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.MEDIUM);
        });

        largeButton.addActionListener((ActionEvent e) -> {
            floorPlanPanel.setSelectedSize(BoothSize.LARGE);
        });

        saveButton.addActionListener((ActionEvent e) -> {
            saveFloorPlan();
        });

        loadButton.addActionListener((ActionEvent e) -> {
            loadFloorPlan();
        });

        toolBar.add(smallButton);
        toolBar.add(mediumButton);
        toolBar.add(largeButton);
        toolBar.add(saveButton);
        toolBar.add(loadButton);

        add(toolBar, BorderLayout.NORTH);
        add(floorPlanPanel, BorderLayout.CENTER);
    }

    private void saveFloorPlan() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controller.saveFloorPlan(file.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "Floor plan saved successfully.");
        }
    }

    private void loadFloorPlan() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controller.loadFloorPlan(file.getAbsolutePath());
            floorPlanPanel.repaint();
            JOptionPane.showMessageDialog(this, "Floor plan loaded successfully.");
        }
    }
}

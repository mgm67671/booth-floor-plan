import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GUI extends JFrame {
    Controller controller;
    BoothSize selectedSize = BoothSize.SMALL; // Default size
    boolean placingBooth = false;

    public GUI(Controller controller) {
        this.controller = controller;
        setTitle("Booth Floor Plan Designer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FloorPlanPanel floorPlanPanel = new FloorPlanPanel(controller);

        // Toolbar for selecting booth sizes and saving/loading
        JToolBar toolBar = new JToolBar();
        JButton smallButton = new JButton("Small Booth");
        JButton mediumButton = new JButton("Medium Booth");
        JButton largeButton = new JButton("Large Booth");
        JButton saveButton = new JButton("Save Floor Plan");
        JButton loadButton = new JButton("Load Floor Plan");

        smallButton.addActionListener((ActionEvent e) -> {
            selectedSize = BoothSize.SMALL;
            placingBooth = true;
        });

        mediumButton.addActionListener((ActionEvent e) -> {
            selectedSize = BoothSize.MEDIUM;
            placingBooth = true;
        });

        largeButton.addActionListener((ActionEvent e) -> {
            selectedSize = BoothSize.LARGE;
            placingBooth = true;
        });

        saveButton.addActionListener((ActionEvent e) -> {
            saveFloorPlan();
        });

        loadButton.addActionListener((ActionEvent e) -> {
            loadFloorPlan();
            floorPlanPanel.repaint();
        });

        toolBar.add(smallButton);
        toolBar.add(mediumButton);
        toolBar.add(largeButton);
        toolBar.add(saveButton);
        toolBar.add(loadButton);

        add(toolBar, BorderLayout.NORTH);
        add(floorPlanPanel, BorderLayout.CENTER);

        floorPlanPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (placingBooth) {
                    controller.add(selectedSize, e.getX(), e.getY());
                    floorPlanPanel.repaint();
                    placingBooth = false;
                }
            }
        });
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
            JOptionPane.showMessageDialog(this, "Floor plan loaded successfully.");
        }
    }
}

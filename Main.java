public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FloorPlan floorPlan = new FloorPlan();
            Controller controller = new Controller(floorPlan);
            GUI gui = new GUI(controller);
            gui.setVisible(true);
        });
    }
}

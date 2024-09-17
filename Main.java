public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FloorPlan floorPlan = new FloorPlan(1.0); // Scale of 1 inch represents 5 feet can be set
            Controller controller = new Controller(floorPlan);
            GUI gui = new GUI(controller);
            gui.setVisible(true);
        });
    }
}

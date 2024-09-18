public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Controller controller = new Controller();
            GUI gui = new GUI(controller);
            gui.setVisible(true);
        });
    }
}

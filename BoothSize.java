import java.awt.Color;

public enum BoothSize {
    SMALL(50, Color.GREEN),
    MEDIUM(75, Color.BLUE),
    LARGE(100, Color.RED);

    private final int dimension;
    private final Color color;

    BoothSize(int dimension, Color color) {
        this.dimension = dimension;
        this.color = color;
    }

    public int getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }
}

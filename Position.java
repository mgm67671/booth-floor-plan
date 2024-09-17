import java.io.Serializable;

public class Position implements Serializable {
    private int x;
    private int y;

    // Constructor, getters, setters
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

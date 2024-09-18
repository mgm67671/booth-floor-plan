public class Booth {
    String size;
    int x, y;
    Image img;

    public Booth(String size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        img = Flyweight.getImg(size);
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
}

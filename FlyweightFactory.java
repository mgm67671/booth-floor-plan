import java.util.HashMap;

public class FlyweightFactory {
    private static HashMap<BoothSize, BoothImage> boothImages = new HashMap<>();

    public static BoothImage getBoothImage(BoothSize size) {
        BoothImage img = boothImages.get(size);
        if (img == null) {
            img = new BoothImage(size);
            boothImages.put(size, img);
        }
        return img;
    }
}

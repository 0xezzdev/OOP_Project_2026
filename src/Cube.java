import java.awt.*;

public class Cube extends ThreeDShape{

    private double side;


    public Cube(double side) {
        this.side = side;
    }
    public Cube(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "side=" + side +
                '}';
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        try {
            Color colorObj = Color.decode(getColor());
            g.setColor(colorObj);
        } catch (Exception e) {
            g.setColor(Color.BLACK);
        }

        int s = (int) side;
        int offset = s / 3;

        g.drawRect(x, y, s, s);

        g.drawRect(x + offset, y - offset, s, s);

        g.drawLine(x, y, x + offset, y - offset);
        g.drawLine(x + s, y, x + s + offset, y - offset);
        g.drawLine(x, y + s, x + offset, y + s - offset);
        g.drawLine(x + s, y + s, x + s + offset, y + s - offset);
    }
}

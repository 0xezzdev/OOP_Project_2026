import java.awt.*;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI *radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
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

        int diameter = (int) (radius * 2);

        g.drawOval(x, y, diameter, diameter);
    }
}

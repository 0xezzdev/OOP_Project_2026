import interfaces.Drawable;

import java.util.Date;

public abstract class Shape implements Drawable {

    private Date dateCrated;
    private String color;

    public Shape() {
        this.dateCrated = new Date();
        this.color = "Black";
    }

    public Shape(String color) {
        this();
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Date getDateCrated() {
        return dateCrated;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String howToDraw() {
        return "Drawing "+this.getClass();
    }
}

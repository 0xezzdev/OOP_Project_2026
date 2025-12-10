package interfaces;

import java.awt.*;

public interface Drawable {
    public abstract String howToDraw();
    public abstract void draw(Graphics g, int x, int y);
}

import java.awt.*;
import java.util.Random;

public class Diamond extends Shape {
    private int size;
    private Color color;
    private Random random;
    private Rectangle bounds;
    private int directionX;
    private int directionY;

    public Diamond(int x, int y, Rectangle bounds) {
        super(x, y);
        this.size = 50;
        this.color = Color.BLACK;
        this.random = new Random();
        this.bounds = bounds;
        this.directionX = getRandomDirection();
        this.directionY = getRandomDirection();
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {x, x + size / 2, x + size, x + size / 2};
        int[] yPoints = {y + size / 2, y, y + size / 2, y + size};
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 4);
    }

    @Override
    public void move() {
        int newX = x + directionX;
        int newY = y + directionY;

        if (newX < bounds.getX() || newX + size > bounds.getX() + bounds.getWidth()) {
            directionX = -directionX;
            newX = x + directionX;
        }
        if (newY < bounds.getY() || newY + size > bounds.getY() + bounds.getHeight()) {
            directionY = -directionY;
            newY = y + directionY;
        }

        x = newX;
        y = newY;
    }

    @Override
    public void resize() {
        size += getRandomOffset();
    }

    @Override
    public void changeColor() {
        color = getRandomColor();
    }

    private int getRandomOffset() {
        return random.nextInt(11) - 5;
    }

    private int getRandomDirection() {
        return random.nextBoolean() ? 1 : -1;
    }

    private Color getRandomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }
}

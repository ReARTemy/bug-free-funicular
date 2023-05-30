import javax.swing.*;
import java.awt.*;

public class Animator extends JPanel implements Runnable {
    private Shape shape;
    private Rectangle rectangle;
    private boolean isRunning;

    public Animator(Shape shape, Rectangle rectangle) {
        this.shape = shape;
        this.rectangle = rectangle;
        this.isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            shape.move();
            shape.resize();
            shape.changeColor();
            repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        rectangle.draw(g);
        shape.draw(g);
    }
}

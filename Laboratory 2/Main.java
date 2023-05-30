import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Shape Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Rectangle rectangle = new Rectangle(0, 0, 300, 250);
        Shape shape = new Diamond(100, 100, rectangle);

        Animator animator = new Animator(shape, rectangle);
        frame.add(animator);

        frame.setSize(400, 400);
        frame.setVisible(true);

        Thread animatorThread = new Thread(animator);
        animatorThread.start();

        try {
            Thread.sleep(1000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab9 extends JPanel {
    private static int radius = 10;
    private static boolean increasing = true;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Движение приближающегося и удаляющегося шара");
        frame.setPreferredSize(new Dimension(400, 400));
        final Lab9 panel = new Lab9();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Timer timer = new Timer(30, new ActionListener() {
            @Override            public void actionPerformed(ActionEvent e) {
                if (increasing) {
                    radius += 2;
                    if (radius >= 100) {
                        increasing = false;
                    }
                } else {
                    radius -= 2;
                    if (radius <= 10) {
                        increasing = true;
                    }
                }
                panel.repaint();
            }
        });
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }
}
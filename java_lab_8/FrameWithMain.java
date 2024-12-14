import javax.swing.*;
import java.awt.*;

public class FrameWithMain {
    public FrameWithMain() {}

    private double calculateZ(int n, int r) {
        double z = 0.0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                z += (double) (j * j + i) / (Math.pow(i, j) + j);
            }
        }
        return z;
    }

    public static double main(Object[] args) {
        FrameWithMain window = new FrameWithMain();
        int n = (int) args[0];
        int r = (int) args[1];

        return window.calculateZ(n, r);
    }
}




//import javax.swing.*;
//import java.awt.*;
//
//public class FrameWithMain extends JFrame {
//    private final JTextField inputN;
//    private final JTextField inputR;
//    private final JLabel resultLabel;
//
//    public FrameWithMain() {
//        super("Второй подход");
//        setSize(400, 400);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(5, 1, 10, 10));
//
//        inputN = new JTextField();
//        inputR = new JTextField();
//        resultLabel = new JLabel("Результат: ", SwingConstants.CENTER);
//
//        JButton calculateButton = new JButton("Считать");
//
//        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
//        inputPanel.add(new JLabel("Введите N:", SwingConstants.RIGHT));
//        inputPanel.add(inputN);
//        inputPanel.add(new JLabel("Введите R:", SwingConstants.RIGHT));
//        inputPanel.add(inputR);
//
//        add(inputPanel);
//        add(calculateButton);
//        add(resultLabel);
//
//        calculateButton.addActionListener(e -> {
//            try {
//                int n = Integer.parseInt(inputN.getText());
//                int r = Integer.parseInt(inputR.getText());
//                double z = calculateZ(n, r);
//                resultLabel.setText(String.format("Результат: %.4f", z));
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(
//                        this,
//                        "Введите корректные значения для N и R!",
//                        "Ошибка",
//                        JOptionPane.ERROR_MESSAGE
//                );
//            }
//        });
//    }
//
//    private double calculateZ(int n, int r) {
//        double z = 0.0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= r; j++) {
//                z += (double) (j * j + i) / (Math.pow(i, j) + j);
//            }
//        }
//        return z;
//    }
//
//    public static void main(String[] args) {
//        FrameWithMain window = new FrameWithMain();
//        window.setVisible(true);
//    }
//}

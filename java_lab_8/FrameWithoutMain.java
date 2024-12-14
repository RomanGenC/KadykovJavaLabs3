import javax.swing.*;

public class FrameWithoutMain extends JFrame {

    public FrameWithoutMain(String title) {}

    public double calculateZ(int n, double x, double y) {
        double z = 0.0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                z -= Math.pow(x, 2) / (i + 1); // - x^2 / (i + 1)
            } else {
                z += Math.pow(y, i) / (i + 1); // y^i / (i + 1)
            }
        }
        return z;
    }
}

class FirstStart {
    public static double main(Object[] args) {
        if (args.length < 3) {
            System.out.println("Необходимо передать 3 аргумента: n, x, y");
            return 0;
        }

        int n = (int) args[0];
        double x = (double) args[1];
        double y = (double) args[2];

        FrameWithoutMain frame = new FrameWithoutMain("Рассчет Z");
        return frame.calculateZ(n, x, y);
    }
}




//import javax.swing.*;
//        import java.awt.*;
//
//public class FrameWithoutMain extends JFrame {
//    private final JTextField inputN;
//    private final JTextField inputX;
//    private final JTextField inputY;
//    private final JLabel resultLabel;
//
//    public FrameWithoutMain() {
//        super("Первый подход");
//        setSize(400, 400);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(5, 1, 10, 10));
//
//        inputN = new JTextField();
//        inputX = new JTextField();
//        inputY = new JTextField();
//        resultLabel = new JLabel("Результат: ", SwingConstants.CENTER);
//
//        JButton calculateButton = new JButton("Считать");
//
//        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
//        inputPanel.add(new JLabel("Введите количество слагаемых:", SwingConstants.RIGHT));
//        inputPanel.add(inputN);
//        inputPanel.add(new JLabel("Введите X:", SwingConstants.RIGHT));
//        inputPanel.add(inputX);
//        inputPanel.add(new JLabel("Введите Y:", SwingConstants.RIGHT));
//        inputPanel.add(inputY);
//
//        add(inputPanel);
//        add(calculateButton);
//        add(resultLabel);
//
//        calculateButton.addActionListener(e -> {
//            try {
//                int n = Integer.parseInt(inputN.getText());
//                double x = Double.parseDouble(inputX.getText());
//                double y = Double.parseDouble(inputY.getText());
//                double result = calculateZ(n, x, y);
//                resultLabel.setText(String.format("Результат: %.4f", result));
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(
//                        this,
//                        "Введите корректные значения для N, X и Y!",
//                        "Ошибка",
//                        JOptionPane.ERROR_MESSAGE
//                );
//            }
//        });
//    }
//
//    private double calculateZ(int n, double x, double y) {
//        double z = 0.0;
//        for (int i = 0; i <= n; i++) {
//            if (i % 2 == 0) {
//                z -= Math.pow(x, 2) / (i + 1); // - x^2 / (i + 1)
//            } else {
//                // Четная итерация (положительное слагаемое)
//                z += Math.pow(y, i) / (i + 1); // y^i / (i + 1)
//            }
//        }
//        return z;
//    }
//}
//
//class FirstStart {
//    public static void main(String[] args) {
//        FrameWithoutMain window = new FrameWithoutMain();
//        window.setVisible(true);
//    }
//}

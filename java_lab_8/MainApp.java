import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    public MainApp() {
        this.setTitle("Вычисление выражения");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel labelX = new JLabel("Введите X: ");
        labelX.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField inputX = new JTextField(10);
        inputX.setMaximumSize(new Dimension(200, 30));
        inputX.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelY = new JLabel("Введите Y: ");
        labelY.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField inputY = new JTextField(10);
        inputY.setMaximumSize(new Dimension(200, 30));
        inputY.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelN = new JLabel("Введите N: ");
        labelN.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField inputN = new JTextField(10);
        inputN.setMaximumSize(new Dimension(200, 30));
        inputN.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelR = new JLabel("Введите R: ");
        labelR.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField inputR = new JTextField(10);
        inputR.setMaximumSize(new Dimension(200, 30));
        inputR.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputPanel.add(labelX);
        inputPanel.add(inputX);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(labelY);
        inputPanel.add(inputY);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(labelN);
        inputPanel.add(inputN);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(labelR);
        inputPanel.add(inputR);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        JRadioButton formula1Button = new JRadioButton("Формула 1");
        formula1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JRadioButton formula2Button = new JRadioButton("Формула 2");
        formula2Button.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonGroup formulaGroup = new ButtonGroup();
        formulaGroup.add(formula1Button);
        formulaGroup.add(formula2Button);
        formula1Button.setSelected(true);

        radioPanel.add(formula1Button);
        radioPanel.add(Box.createVerticalStrut(10));
        radioPanel.add(formula2Button);

        JButton calculateButton = new JButton("Считать");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(radioPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(calculateButton);

        this.add(mainPanel, BorderLayout.CENTER);

        formula1Button.addActionListener(e -> {
            labelX.setVisible(true);
            inputX.setVisible(true);
            labelY.setVisible(true);
            inputY.setVisible(true);
            labelN.setVisible(true);
            inputN.setVisible(true);
            labelR.setVisible(false);
            inputR.setVisible(false);
        });

        formula2Button.addActionListener(e -> {
            labelX.setVisible(false);
            inputX.setVisible(false);
            labelY.setVisible(false);
            inputY.setVisible(false);
            labelN.setVisible(true);
            inputN.setVisible(true);
            labelR.setVisible(true);
            inputR.setVisible(true);
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formula1Button.isSelected()) {
                    int n = Integer.parseInt(inputN.getText());
                    double x = Double.parseDouble(inputX.getText());
                    double y = Double.parseDouble(inputY.getText());
                    double result = FirstStart.main(new Object[]{n, x, y});

                    setTitle("Ответ: " + result);
                } else if (formula2Button.isSelected()) {
                    int n = Integer.parseInt(inputN.getText());
                    int r = Integer.parseInt(inputR.getText());
                    double result = FrameWithMain.main(new Object[]{n, r});

                    setTitle("Ответ: " + result);
                } else {
                    JOptionPane.showMessageDialog(
                        MainApp.this,
                        "Выберите подход для запуска!",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public static void main(String[] args) {
        MainApp window = new MainApp();
        window.setVisible(true);
    }
}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainApp extends JFrame {
//    private final JRadioButton firstApproach;
//    private final JRadioButton secondApproach;
//
//    public MainApp() {
//        super("Выбор подхода");
//        setSize(300, 200);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(3, 1, 10, 10));
//
//        firstApproach = new JRadioButton("Первый подход");
//        secondApproach = new JRadioButton("Второй подход");
//        ButtonGroup group = new ButtonGroup();
//        group.add(firstApproach);
//        group.add(secondApproach);
//
//        JButton startButton = new JButton("Запустить");
//
//        add(firstApproach);
//        add(secondApproach);
//        add(startButton);
//
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (firstApproach.isSelected()) {
//                    FirstStart.main(null);
//                } else if (secondApproach.isSelected()) {
//                    FrameWithMain.main(null);
//                } else {
//                    JOptionPane.showMessageDialog(
//                        MainApp.this,
//                        "Выберите подход для запуска!",
//                        "Ошибка",
//                        JOptionPane.ERROR_MESSAGE
//                    );
//                }
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        MainApp window = new MainApp();
//        window.setVisible(true);
//    }
//}

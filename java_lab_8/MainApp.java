import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private final JRadioButton firstApproach;
    private final JRadioButton secondApproach;

    public MainApp() {
        super("Выбор подхода");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        firstApproach = new JRadioButton("Первый подход");
        secondApproach = new JRadioButton("Второй подход");
        ButtonGroup group = new ButtonGroup();
        group.add(firstApproach);
        group.add(secondApproach);

        JButton startButton = new JButton("Запустить");

        add(firstApproach);
        add(secondApproach);
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstApproach.isSelected()) {
                    FirstStart.main(null);
                } else if (secondApproach.isSelected()) {
                    FrameWithMain.main(null);
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

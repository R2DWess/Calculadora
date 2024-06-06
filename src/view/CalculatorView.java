import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;
    private Font myFont = new Font("Arial", Font.BOLD, 30);

    public CalculatorView() {
        setTitle("Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        display = new JTextField();
        display.setFont(myFont);
        display.setEditable(false);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(display, gbc);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons = new JButton[8];
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (JButton btn : functionButtons) {
            btn.setFont(myFont);
            btn.setFocusable(false);
        }

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel(new GridBagLayout());
        gbc.gridwidth = 1;

        int gridX = 0, gridY = 1;

        for (int i = 1; i <= 9; i++) {
            addButtonToPanel(panel, numberButtons[i], gridX, gridY);
            gridX++;
            if (gridX == 3) {
                gridX = 0;
                gridY++;
            }
        }

        addButtonToPanel(panel, decButton, 0, 4);
        addButtonToPanel(panel, numberButtons[0], 1, 4);
        addButtonToPanel(panel, equButton, 2, 4);

        addButtonToPanel(panel, addButton, 3, 1);
        addButtonToPanel(panel, subButton, 3, 2);
        addButtonToPanel(panel, mulButton, 3, 3);
        addButtonToPanel(panel, divButton, 3, 4);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(panel, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(delButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(clrButton, gbc);
    }

    private void addButtonToPanel(JPanel panel, JButton button, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(button, gbc);
    }

    public JTextField getDisplay() {
        return display;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public JButton[] getFunctionButtons() {
        return functionButtons;
    }
}

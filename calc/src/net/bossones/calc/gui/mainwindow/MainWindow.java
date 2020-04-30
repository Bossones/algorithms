package net.bossones.calc.gui.mainwindow;

import net.bossones.calc.Calculator;
import net.bossones.calc.gui.components.buttons.Buttons;
import net.bossones.calc.gui.mainwindow.actions.ActionsToButtons;
import net.bossones.calc.gui.mainwindow.layouts.CalcLayout;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final JTextField textOfExpression = new JTextField("0");

    private MainWindow() {
        textOfExpression.setEditable(false);
        textOfExpression.setDragEnabled(false);
        textOfExpression.setFont(new Font("Calibri", Font.ITALIC, 20));
        textOfExpression.setHorizontalAlignment(JTextField.RIGHT);
    }

    public static void createGUI() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainWindow.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 250, 300, 500);
        mainWindow.setResizable(false);
        mainWindow.setIconImage(new ImageIcon("src\\net\\bossones\\calc\\gui\\resources\\icon2.png").getImage());
        mainWindow.setTitle("Calculator");
        mainWindow.add(mainWindow.createPanelAndAddButtons());
        mainWindow.setActionsToButtons();
        mainWindow.setVisible(true);
    }

    private void setActionsToButtons() {
        for (int i = 0; i < Buttons.allButtons.length - 3; i++)
            Buttons.allButtons[i].addActionListener(new ActionsToButtons(textOfExpression));
        Buttons.clearAll.addActionListener(e -> textOfExpression.setText("0"));
        Buttons.equals.addActionListener(e -> textOfExpression.setText("" + Calculator.calculate(textOfExpression.getText())));
        Buttons.backButton.addActionListener(e -> {
            if (textOfExpression.getText().length() > 1)
                textOfExpression.setText(textOfExpression.getText().substring(0, textOfExpression.getText().length() - 1));
            else
                textOfExpression.setText("0");
        });
    }

    private JPanel createPanelAndAddButtons() {
        JPanel panelButton = new JPanel();
        CalcLayout calcLayout = new CalcLayout();
        panelButton.setLayout(calcLayout);
        for (int i = 0; i < Buttons.allButtons.length; i++)
            panelButton.add(Buttons.allButtons[i]);
        panelButton.add(textOfExpression);
        calcLayout.layoutContainer(panelButton);
        return panelButton;
    }
}

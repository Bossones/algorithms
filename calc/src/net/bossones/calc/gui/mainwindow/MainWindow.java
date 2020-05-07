package net.bossones.calc.gui.mainwindow;

import net.bossones.calc.gui.components.buttons.Buttons;
import net.bossones.calc.gui.mainwindow.actions.*;
import net.bossones.calc.gui.mainwindow.layouts.CalcLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * GUI main window.
 */
public class MainWindow extends JFrame {

    private static final JTextField textOfExpression = new JTextField("0");

    /**
     * Create this {@code MainWindow} for GUI
     */
    private MainWindow() {
        textOfExpression.setEditable(false);
        textOfExpression.setDragEnabled(false);
        textOfExpression.setFont(new Font("Calibri", Font.ITALIC, 20));
        textOfExpression.setHorizontalAlignment(JTextField.RIGHT);
    }

    /**
     * Creates the GUI for calculator
     */
    public static void createGUI() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainWindow.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 250, 300, 500);
        mainWindow.setResizable(false);
        mainWindow.setIconImage(new ImageIcon("src\\net\\bossones\\calc\\gui\\resources\\icon2.png").getImage());
        mainWindow.setTitle("Calculator");
        JPanel panelButtons = mainWindow.createPanelAndAddButtons();
        mainWindow.add(panelButtons);
        mainWindow.setActionsToMainButtons(panelButtons);
        mainWindow.setFocusable(true);
       // mainWindow.setKeyStrokes(, panelButtons);
        mainWindow.setVisible(true);
    }

    /**
     * Sets actions for main buttons. And defines {@code KeyStroke} for main buttons.
     * There are used next buttons:
     * Digits:
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 0.
     * Operators:
     * *, -, +, /, =
     * Auxiliary buttons:
     * Opening/closing brackets, equals, clear all, backspace, point, extended button.
     */
    private void setActionsToMainButtons(JPanel panelButtons) {
        AtomicBoolean point = new AtomicBoolean(true);
        AtomicBoolean equals = new AtomicBoolean(false);

        AbstractAction actionToDigits = new ActionToDigit(textOfExpression, equals);
        AbstractAction actionToOperators = new ActionToOperators(textOfExpression, equals, point);
        AbstractAction actionToEquals = new ActionToEquals(textOfExpression, equals);
        AbstractAction actionToBackButton = new ActionToBackButton(textOfExpression, point);
        AbstractAction actionToPointButton = new ActionToPointButton(textOfExpression, point);

        InputMap inputMap = panelButtons.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panelButtons.getActionMap();

        for (int i = 0; i < Buttons.digitButtons.length; i++) {
            Buttons.digitButtons[i].addActionListener(actionToDigits);
            String digit = Buttons.digitButtons[i].getActionCommand();
            switch (digit) {
                case "(" -> {
                    inputMap.put(KeyStroke.getKeyStroke("shift 9"), digit);
                    actionMap.put(digit, actionToDigits);
                }
                case ")" -> {
                    inputMap.put(KeyStroke.getKeyStroke("shift 0"), digit);
                    actionMap.put(digit, actionToDigits);
                }
                default -> {
                    inputMap.put(KeyStroke.getKeyStroke(digit), digit);
                    actionMap.put(digit, actionToDigits);
                }
            }
        }

        for (int i = 0; i < Buttons.operatorButtons.length; i++) {
            Buttons.operatorButtons[i].addActionListener(actionToOperators);
            String operator = Buttons.operatorButtons[i].getActionCommand();
            switch (operator) {
                case "+" -> {
                    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), operator);
                    actionMap.put(operator, actionToOperators);
                } case "-" -> {
                    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), operator);
                    actionMap.put(operator, actionToOperators);
                } case "/" -> {
                    inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), operator);
                    actionMap.put(operator, actionToOperators);
                } case "*" -> {
                    inputMap.put(KeyStroke.getKeyStroke("shift 8"), operator);
                    actionMap.put(operator, actionToOperators);
                }
            }
        }

        Buttons.clearAll.addActionListener(e -> textOfExpression.setText("0"));
        inputMap.put(KeyStroke.getKeyStroke("C"), "C");
        actionMap.put("C", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOfExpression.setText("0");
            }
        });

        Buttons.equals.addActionListener(actionToEquals);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "=");
        actionMap.put("=", actionToEquals);

        Buttons.backButton.addActionListener(actionToBackButton);
        inputMap.put(KeyStroke.getKeyStroke(8, 0), "backspace");
        actionMap.put("backspace", actionToBackButton);

        Buttons.pointButton.addActionListener(actionToPointButton);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), ".");
        actionMap.put(".", actionToPointButton);
    }

    /**
     * Sets actions for extended buttons.
     * There are used next buttons:
     * Operators:
     * ^, sqrt.
     * @param window - main window of calculator's GUI.
     */
    private void setActionsToExtendedButtons(JFrame window) {

    }


    /**
     * Creates panel with buttons
     * @return this panel
     */
    private JPanel createPanelAndAddButtons() {
        JPanel panelButton = new JPanel();
        CalcLayout calcLayout = new CalcLayout();
        panelButton.setLayout(calcLayout);
        for (int i = 0; i < Buttons.operatorButtons.length; i++)
            panelButton.add(Buttons.operatorButtons[i]);
        for (int i = 0; i < Buttons.digitButtons.length; i++)
            panelButton.add(Buttons.digitButtons[i]);
        for (int i = 0; i < Buttons.otherButtons.length; i++)
            panelButton.add(Buttons.otherButtons[i]);
        panelButton.add(textOfExpression);
        calcLayout.layoutContainer(panelButton);
        return panelButton;
    }
}

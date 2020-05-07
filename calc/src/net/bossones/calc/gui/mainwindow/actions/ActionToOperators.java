package net.bossones.calc.gui.mainwindow.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActionToOperators extends AbstractAction {

    private final JTextField textOfExpression;
    private final AtomicBoolean point;
    private final AtomicBoolean equals;

    public ActionToOperators(JTextField textOfExpression, AtomicBoolean equals, AtomicBoolean point) {
        this.textOfExpression = textOfExpression;
        this.equals = equals;
        this.point = point;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder expression = new StringBuilder(textOfExpression.getText());
        switch (expression.charAt(expression.length() - 1)) {
            case '+', '-', '*', '/' -> {
                expression.setCharAt(expression.length() - 1, e.getActionCommand().charAt(0));
                textOfExpression.setText(expression.toString());
            }
            default -> {
                if (equals.get()) {
                    textOfExpression.setText(expression.substring(
                            expression.indexOf("=") + 1, expression.length()) + e.getActionCommand());
                    equals.set(false);
                } else
                    textOfExpression.setText(expression.append(e.getActionCommand()).toString());
            }
        }
        point.set(true);
    }
}

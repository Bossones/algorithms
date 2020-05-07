package net.bossones.calc.gui.mainwindow.actions;

import net.bossones.calc.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActionToEquals extends AbstractAction {

    private final JTextField textOfExpression;
    private final AtomicBoolean equals;

    public ActionToEquals(final JTextField textOfExpression, final AtomicBoolean equals) {
        this.textOfExpression = textOfExpression;
        this.equals = equals;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textOfExpression.getText();
        String result = "" + Calculator.calculate(expression);
        equals.set(true);
        if (result.length() > 3 &&
                result.charAt(result.length() - 2) == '.' &&
                result.charAt(result.length() - 1) == '0') {

            textOfExpression.setText(expression + "=" + result.substring(0, result.length() - 2));
        } else if (expression.equals("0"))
            textOfExpression.setText("0");
        else if (result.length() > 7)
            textOfExpression.setText(expression + "=" + result.substring(0, 7));
        else
            textOfExpression.setText(expression + "=" + result);
    }
}

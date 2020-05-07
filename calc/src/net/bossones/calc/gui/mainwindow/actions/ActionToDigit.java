package net.bossones.calc.gui.mainwindow.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActionToDigit extends AbstractAction {

    private final JTextField textOfExpression;

    private final AtomicBoolean equals;

    public ActionToDigit(JTextField textOfExpression, AtomicBoolean equals) {
        super("ActionToDigit");
        Objects.requireNonNull(textOfExpression);
        this.textOfExpression = textOfExpression;
        this.equals = equals;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textOfExpression.getText();
        if (expression.equals("0") || equals.get())
            textOfExpression.setText(e.getActionCommand());
        else
            textOfExpression.setText(expression + e.getActionCommand());
        equals.set(false);
    }
}

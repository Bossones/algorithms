package net.bossones.calc.gui.mainwindow.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActionToPointButton extends AbstractAction {
    private final JTextField textOfExpression;
    private final AtomicBoolean point;

    public ActionToPointButton(final JTextField textOfExpression, final AtomicBoolean point) {
        this.textOfExpression = textOfExpression;
        this.point = point;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textOfExpression.getText();
        if (expression.equals("0") || point.get() && Character.isDigit(expression.charAt(expression.length() - 1))) {
            textOfExpression.setText(expression + ".");
            point.set(false);
        }
    }
}

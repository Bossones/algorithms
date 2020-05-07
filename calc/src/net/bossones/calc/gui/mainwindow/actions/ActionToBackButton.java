package net.bossones.calc.gui.mainwindow.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActionToBackButton extends AbstractAction {

    private final JTextField textOfExpression;
    private final AtomicBoolean point;

    public ActionToBackButton(final JTextField textOfExpression, final AtomicBoolean point) {
        this.textOfExpression = textOfExpression;
        this.point = point;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textOfExpression.getText();
        if (expression.length() > 1) {
            if (expression.charAt(expression.length() - 1) == '.')
                point.set(true);
            textOfExpression.setText(expression.substring(0, expression.length() - 1));
        }
        else
            textOfExpression.setText("0");
    }
}

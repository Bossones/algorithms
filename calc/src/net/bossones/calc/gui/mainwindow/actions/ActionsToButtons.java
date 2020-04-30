package net.bossones.calc.gui.mainwindow.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ActionsToButtons extends AbstractAction {

    private final JTextField textOfExpression;

    public ActionsToButtons(JTextField textOfExpression) {
        Objects.requireNonNull(textOfExpression);
        this.textOfExpression = textOfExpression;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!textOfExpression.getText().equals("0"))
            textOfExpression.setText(textOfExpression.getText() + e.getActionCommand());
        else textOfExpression.setText(e.getActionCommand());
    }
}

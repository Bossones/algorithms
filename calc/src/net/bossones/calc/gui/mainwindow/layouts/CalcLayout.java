package net.bossones.calc.gui.mainwindow.layouts;

import javax.swing.*;
import java.awt.*;

public class CalcLayout extends GridBagLayout {
    @Override
    public void layoutContainer(Container parent) {
        Component[] components = parent.getComponents();
        int x = parent.getWidth() / 4;
        int y = x;

        for (Component component : components) {
            if (component instanceof JButton) {
                switch (((JButton) component).getActionCommand()) {
                    case "1" -> component.setBounds(0, parent.getHeight() - y, x, y);
                    case "2" -> component.setBounds(x, parent.getHeight() - y, x, y);
                    case "3" -> component.setBounds(x * 2, parent.getHeight() - y, x, y);
                    case "4" -> component.setBounds(0, parent.getHeight() - y * 2, x, y);
                    case "5" -> component.setBounds(x, parent.getHeight() - y * 2, x, y);
                    case "6" -> component.setBounds(x * 2, parent.getHeight() - y * 2, x, y);
                    case "7" -> component.setBounds(0, parent.getHeight() - y * 3, x, y);
                    case "8" -> component.setBounds(x, parent.getHeight() - y * 3, x, y);
                    case "9" -> component.setBounds(x * 2, parent.getHeight() - y * 3, x, y);
                    case "0" -> component.setBounds(x, parent.getHeight() - y * 4, x, y);
                    case "+" -> component.setBounds(x * 3, parent.getHeight() - y * 4, x, y);
                    case "-" -> component.setBounds(x * 3, parent.getHeight() - y * 3, x, y);
                    case "*" -> component.setBounds(x * 3, parent.getHeight() - y * 2, x, y);
                    case "/" -> component.setBounds(x * 3, parent.getHeight() - y, x, y);
                    case "=" -> component.setBounds(x * 2, parent.getHeight() - y * 4, x, y);
                    case "C" -> component.setBounds(0, parent.getHeight()- y * 4, x, y);
                    case "(" -> component.setBounds(0, parent.getHeight() - y * 5, x, y);
                    case ")" -> component.setBounds(x, parent.getHeight() - y * 5, x, y);
                    case "." -> component.setBounds(x * 2, parent.getHeight() - y * 5, x, y);
                    case "<-" -> component.setBounds(x * 3, parent.getHeight() - y * 5, x, y);
                }
            } else
                component.setBounds(0, 0, parent.getWidth(), parent.getHeight() - y * 5);
        }
    }
}

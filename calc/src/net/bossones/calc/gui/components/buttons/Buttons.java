package net.bossones.calc.gui.components.buttons;

import javax.swing.*;

public class Buttons {
    public static JButton plusButton = new JButton("+");
    public static JButton substButton = new JButton("-");
    public static JButton multButton = new JButton("*");
    public static JButton divButton = new JButton("/");
    public static JButton zeroButton = new JButton("0");
    public static JButton oneButton = new JButton("1");
    public static JButton twoButton = new JButton("2");
    public static JButton threeButton = new JButton("3");
    public static JButton fourButton = new JButton("4");
    public static JButton fiveButton = new JButton("5");
    public static JButton sixButton = new JButton("6");
    public static JButton sevenButton = new JButton("7");
    public static JButton eightButton = new JButton("8");
    public static JButton nineButton = new JButton("9");
    public static JButton obButton = new JButton("(");
    public static JButton cbButton = new JButton(")");
    public static JButton pointButton = new JButton(".");
    public static JButton backButton = new JButton("<-");
    public static JButton equals = new JButton("=");
    public static JButton clearAll = new JButton("C");

    public static JButton[] allButtons = new JButton[] {
      plusButton, substButton, obButton,
      multButton, divButton, zeroButton,
      oneButton, twoButton, cbButton,
      threeButton, fourButton, fiveButton,
      sixButton, sevenButton, eightButton,
      nineButton, pointButton, clearAll,
      backButton, equals
    };
}

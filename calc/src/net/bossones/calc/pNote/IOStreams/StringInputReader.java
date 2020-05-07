package net.bossones.calc.pNote.IOStreams;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class StringInputReader extends Reader {

    private final String expression;

    private int position;

    public StringInputReader(String expression) {
        Objects.requireNonNull(expression);
        this.expression = expression;
        position = -1;
    }

    private boolean checkPosition() {
        return position <= expression.length() - 1;
    }

    @Override
    public int read() {
        position++;
        if (!checkPosition())
            return -1;
        return expression.charAt(position);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException { }
}
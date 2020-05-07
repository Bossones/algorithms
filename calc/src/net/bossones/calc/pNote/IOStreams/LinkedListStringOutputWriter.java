package net.bossones.calc.pNote.IOStreams;

import net.bossones.calc.lilist.LinkedList;

import java.io.IOException;
import java.io.Writer;

public class LinkedListStringOutputWriter extends Writer {

    private LinkedList<String> outputExpression;

    public LinkedListStringOutputWriter(LinkedList<String> outputExpression) {
        this.outputExpression = outputExpression;
    }

    @Override
    public void write(int c) throws IOException {
        outputExpression.addLast(Character.toString(c));
    }

    @Override
    public void write(String str) throws IOException {
        outputExpression.addLast(str);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException { }

    @Override
    public void flush() throws IOException { }

    @Override
    public void close() throws IOException { }
}

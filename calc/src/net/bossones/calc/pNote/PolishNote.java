package net.bossones.calc.pNote;

import net.bossones.calc.stack.Stack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class PolishNote {

    public static void makeNote(Reader in, Writer out) throws IOException {
        Objects.requireNonNull(in);
        Objects.requireNonNull(out);
        Stack<Character> operators = new Stack<>();

        int c;
        while ((c = in.read()) != -1) {
            switch ((char)c) {
                case '(':
                case '*':
                case '/':
                    operators.add((char)c);
                    break;
                case '+':
                case '-':
                    clearUntilUpperPriority(out, operators);
                    operators.add((char)c);
                    break;
                case ')':
                    clearUntilOpenBracket(out, operators);
                    break;
                case '\n':
                    while (!operators.isEmpty())
                        out.write(operators.remove());
                    out.write('\n');
                    break;
                case '\r':
                case ' ':
                    break;
                default:
                    if (Character.isDigit(c) || c == '.') {
                        out.write(c);
                    } else throw new IllegalArgumentException();
            }
        }
        while (!operators.isEmpty())
            out.write(operators.remove());
        out.flush();
        out.close();
        in.close();
    }

    private static void clearUntilOpenBracket(Writer out, Stack<Character> operators) throws IOException {
        for (Character nextOperator : operators) {
            if (nextOperator != '(') {
                out.write(nextOperator);
                operators.remove();
            } else {
                operators.remove();
                break;
            }
        }
    }

    private static void clearUntilUpperPriority(Writer out, Stack<Character> operators) throws IOException {
        for (Character nextOperator : operators) {
            if (nextOperator != '-' && nextOperator != '+' && nextOperator != '(') {
                out.write(nextOperator);
                operators.remove();
            } else break;
        }
    }

    public static void main(String[] args) throws IOException {
        makeNote(
                Files.newBufferedReader(Paths.get("log.txt")),
                Files.newBufferedWriter(Paths.get("log2.txt"),
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.CREATE));
    }

}

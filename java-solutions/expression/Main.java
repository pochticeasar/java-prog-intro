package expression;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        new Add(new Subtract(new Multiply(new Variable("x"), new Variable("x")), new Variable("x")), new Const(1)).evaluate(in.nextInt());
    }
}

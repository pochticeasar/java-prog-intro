package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;
    final int m;
    final int n;

    public HumanPlayer(Scanner in, int m, int n) {
        this.in = in;
        this.m = m;
        this.n = n;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position);
        System.out.println("Enter you move for " + position.getTurn());
        while(true) {
            int x, y;
            try {
                x = in.nextInt() - 1;
                try {
                    y = in.nextInt() - 1;
                    if(position.isValid(new Move(x, y, position.getTurn()))) {
                        return new Move(x, y, position.getTurn());
                    } else {
                        System.out.println("Make valid move");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Make a move");
                }
            } catch (InputMismatchException e) {
                System.out.println("Make a move");
            }
        }
    }
}

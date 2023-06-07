package game;

import java.util.Scanner;

public class Main {
    public static int[] inputInt(Scanner in) {
        while (true) {
            int[] a = new int[3];
            boolean isString = false;
            for (int i = 0; i < 3; i++) {
                a[i] = -1;
                if (in.hasNext()) {
                    try {
                        a[i] = Integer.parseInt(in.next());
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
            }
            if(a[0] > 0 && a[1] > 0 && a[2] > 0 && (a[2] <= a[0] || a[2] <= a[1])) {
                return a;
            } else {
                System.out.println("Input is invalid");
            }
        }
    }
    public static String[] inputString(Scanner in){
        while (true) {
            String[] players = new String[2];

            for (int i = 0; i < 2; i++) {
                String s = null;
                if(in.hasNext()) {
                    s = in.next();
                }
                if(s.equals("RandomPlayer") || s.equals("CheatingPlayer") || s.equals("SequentialPlayer") || s.equals("HumanPlayer")) {
                    players[i] = s;
                }
                else {
                    i--;
                    System.out.println("Input is invalid");
                }
            }
            if(!players[0].equals(null) && !players[1].equals(null))
                return players;
        }
    }
    public static Player PlayerChoose (String a, int parametr[], Scanner in) {
        switch (a) {
            case "RandomPlayer":
                return new RandomPlayer(parametr[0], parametr[1]);
            case "HumanPlayer":
                return new HumanPlayer(in, parametr[0], parametr[1]);
            case "SequentialPlayer":
                return new SequentialPlayer(parametr[0], parametr[1]);
            case "CheatingPlayer":
                return new CheatingPlayer(parametr[0], parametr[1]);
            default:
                System.out.println("No such player");
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] parametr = inputInt(in);
        String[] players = inputString(in);
        Player a = PlayerChoose(players[0], parametr, in);
        Player b = PlayerChoose(players[1], parametr, in);
        Matches match = new Matches(parametr[0], parametr[1], parametr[2]);
        match.play(in.nextInt(),a, b);
    }
}

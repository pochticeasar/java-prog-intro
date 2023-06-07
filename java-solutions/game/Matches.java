package game;

public class Matches {
    private static int k;
    private static int m;
    private static int n;

    public Matches(int n, int m, int k) {
        this.k = k;
        this.n = n;
        this.m = m;
    }

    public void play(int cnt, Player a, Player b) {
        int f = 0, s = 0, i = 0;
        while (f < cnt && s < cnt) {
            int result;
            if(i % 2 == 0)
                result = new TwoPlayerGame(new MNKBoard(n, m, k), a, b).playMatches(true, i);
            else
                result = new TwoPlayerGame(new MNKBoard(n, m, k), b, a).playMatches(true, i);
            switch (result) {
                case 1:
                    if (i % 2 == 0) {
                        f++;
                    } else {
                        s++;
                    }
                    break;
                case 2:
                    if (i % 2 == 1) {
                        s++;
                    } else {
                        f++;
                    }
                    break;
                case 0:
                    System.out.println("Draw");
                    break;
                default:
                    throw new AssertionError("Unknown result " + result);

            }
            System.out.println("Player 1: " + f);
            System.out.println("Player 2: " + s);
            i++;
        }
    }
}
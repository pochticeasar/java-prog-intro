public class pair {
    private int first;
    private int second;

    public pair(int x, int y) {
        this.first = x;
        this.second = y;
    }

    public pair(pair v) {
        first = v.first;
        second = v.second;
    }

    public int second() {
        return second;
    }

    public int first() {
        return first;
    }
}
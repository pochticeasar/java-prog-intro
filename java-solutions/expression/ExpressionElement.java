package expression;

public interface ExpressionElement extends Expression, TripEx {
    String toString();
    boolean equals(Object hz);
    int evaluate(int a);

    @Override
    int evaluate(int x, int y, int z);
}

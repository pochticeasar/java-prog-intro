package expression;

abstract class Operation implements ExpressionElement {
    ExpressionElement left, right;
    public Operation(ExpressionElement left, ExpressionElement right) {
        this.left = left;
        this.right = right;
    }

    protected String toString(String oper) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(left.toString());
        sb.append(oper);
        sb.append(right.toString());
        sb.append(")");
        return sb.toString();
    }

    protected int[] evaluateArguments(int variableValue) {
        int[] arg = new int[2];
        if (left instanceof Operation) {
            arg[0] = left.evaluate(variableValue);
        } else if (left instanceof Const) {
            arg[0] = ((Const) left).value;
        } else {
            arg[0] = variableValue;
        }
        if (right instanceof Operation) {
            arg[1] = right.evaluate(variableValue);
        } else if (right instanceof Const) {
            arg[1] = ((Const) right).value;
        } else {
            arg[1] = variableValue;
        }
        return arg;
    }
    public abstract int evaluate(int a);

}

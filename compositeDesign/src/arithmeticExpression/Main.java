package arithmeticExpression;

public class Main {
    public static void main(String[] args) {
        //  (7 + 5) / 2

        Expression addExpression = new Expression(new Number(7), new Number(5), Operation.ADD);
        Expression divideExpression = new Expression(addExpression, new Number(2), Operation.DIVIDE);

        divideExpression.evaluate();
    }
}
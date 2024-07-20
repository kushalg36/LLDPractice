package arithmeticExpression;

public class Expression implements ArithmeticExpression {
    ArithmeticExpression leftValue;
    ArithmeticExpression rightValue;
    Operation operation;

    public Expression(ArithmeticExpression leftValue, ArithmeticExpression rightValue, Operation operation) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        int value = 0;
        if(Operation.ADD.equals(operation)) {
            value = leftValue.evaluate() + rightValue.evaluate();
        } else if(Operation.SUBTRACT.equals(operation)) {
            value = leftValue.evaluate() - rightValue.evaluate();
        } else if(Operation.MULTIPLY.equals(operation)) {
            value = leftValue.evaluate() * rightValue.evaluate();
        } else if(Operation.DIVIDE.equals(operation)) {
            value = leftValue.evaluate() / rightValue.evaluate();
        }
        System.out.println("Value: " + value);
        return value;
    }
}

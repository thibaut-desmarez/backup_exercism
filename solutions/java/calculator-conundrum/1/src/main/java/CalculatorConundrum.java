class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        int result = 0;
        if(operation == null){
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        try {
            result = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            };
            ;
        }
        catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed",e);
        }
        return String.valueOf(operand1)+" "+operation + " " + String.valueOf(operand2) + " = " + String.valueOf(result);
    }
}

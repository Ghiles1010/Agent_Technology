package main.raisoneur;

public class Condition {
    private final int numeroCondition;
    private final String variableName, operatorToCompare, operation;

    public Condition(int numeroCondition, String variableName, String operatorToCompare, String operation) {
        this.numeroCondition = numeroCondition;
        this.variableName = variableName;
        this.operatorToCompare = operatorToCompare;
        this.operation = operation;
    }

    public boolean makeOperation(String inputOperator){

        // we check if the inputOperation is given we return null id it's not

        if(operation.equals("==")){
            return  operatorToCompare.equals(inputOperator);
        } else if (operation.equals("!=")) {
            return  !operatorToCompare.equals(inputOperator);
        } else {
            // this mean that the operation must be an number operation.
            // we convert the "operatorToCompare" and "inputOperator" into floats then we make the comparaion
            float inputFloat = Float.parseFloat(inputOperator);
            float operatorToCompareFloat = Float.parseFloat(operatorToCompare);
            switch (operation) {
                case ">=":
                    return operatorToCompareFloat >= inputFloat;
                case ">":
                    return operatorToCompareFloat > inputFloat;
                case "<=":
                    return operatorToCompareFloat <= inputFloat;
                case "<":
                    return operatorToCompareFloat < inputFloat;
                default:
                    // erreur symbole incorecte
                    System.out.println("erreur symbole incorecte");
                    return false;
            }
        }
    }
}

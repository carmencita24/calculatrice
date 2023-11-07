import java.util.Stack;

public interface CalculatorControllerInterface {
    public void change(String accumulateur); //Modification de l'accumulateur

    public void change(Stack<Double> stackData); //Modification de la pile
} 

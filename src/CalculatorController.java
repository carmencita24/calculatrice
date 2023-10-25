import java.util.Stack;

public class CalculatorController implements CalculatorControllerInterface {
	
	CalculatorModel model = new CalculatorModel();
	
	public void change(String accumulateur) {
		model.setAccu(accumulateur);
	}
	
	public void change(Stack<Double> pile) {
		model.setPile(pile);
	}

	public CalculatorModel getModel() {
		return model;
	}
	
}

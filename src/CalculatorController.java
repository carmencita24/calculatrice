import java.util.Stack;

public class CalculatorController implements CalculatorControlerInterface {
	
	CalculatorModel model = new CalculatorModel();
	
	public void change(String accumulateur) {
		model.setAccu(accumulateur);
	}
	
	public void change(Stack<Double> pile) {
		model.setPile(pile);
	}
	
	public void calculer() {
		Stack<Double> pile = new Stack<Double>();
		for(int i = 0; i < 3; i++) {
			pile.add(2.0);
		}
		change(pile);
		model.add();
		model.multiply();
		System.out.println(model.pop());
	}
	
}

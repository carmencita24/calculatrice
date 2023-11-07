import java.util.Stack;

public class CalculatorController implements CalculatorControllerInterface {

	private CalculatorModelInterface model;

	public CalculatorController(CalculatorModelInterface model) {
		this.model =  model;
	}
	
	public void change(String accumulateur) { //Modification de l'accumulateur
		model.setAccu(accumulateur);
	}
	
	public void change(Stack<Double> pile) { //Modification de la pile
		model.setPile(pile);
	}

	public CalculatorModelInterface getModel() { //Getter du model
		return model;
	}
	
}

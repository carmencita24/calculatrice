import java.util.Stack;

public interface CalculatorModelInterface {
    public void add(); //Addition
	public void substract(); //Soustraction
	public void multiply(); //Multiplication
	public void divide(); //Division
	public void opposite(); //Multiplication par -1
	public void push(); //Envoie dans la pile de l'accu
	public Double pop(); //Méthode stack
	public void drop(); //??
	public void swap(); //Changement de place des 2 derniers éléments
	public void clear(); //Nettoyage de la pile et de l'accu
	public String getAccu();
	public void setAccu(String accumulateur);
	public void setPile(Stack<Double> pile);
	public Stack<Double> getPile();
    
}

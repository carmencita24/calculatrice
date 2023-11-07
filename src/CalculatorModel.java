
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> pile = new Stack<Double>();
    private String accumulateur = "";

    public String getAccu() { //Getter de l'accumulateur
        return accumulateur;
    }

    public Stack<Double> getPile() { //Getter de la pile
        return pile;
    }

    public void setAccu(String accumulateur) { //Setter de l'accumulateur
        this.accumulateur = accumulateur;
    }

    public void setPile(Stack<Double> pile) { //Setteur de la pile
        this.pile = pile;
    }

    public void add() {
        if (pile.size() > 1) { // On vérifie qu'il y est au moins 2 élements
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push(e2 + e1); //Addition
        }
    }

    public void substract() {
        if (pile.size() > 1) { // On vérifie qu'il y est au moins 2 élements
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push(e2 - e1); //Soustraction
        }
    }

    public void multiply() {
        if (pile.size() > 1) { // On vérifie qu'il y est au moins 2 élements
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push((e2 * e1)); //Multiplication
        }
    }

    public void divide() {
        if (pile.size() > 1) { // On vérifie qu'il y est au moins 2 élements
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            if (e1 != 0) { //On vérifie que le dénominateur soit non nul
                this.pile.push(e2 / e1); //Division
            }
        }
    }

    public void opposite() {
        setAccu(String.valueOf(Double.valueOf(getAccu())*(-1))); //On convertir l'accu en double, on le multiplie par -1 et on convertie le résultat en String
    }

    public void push() {
        if(!accumulateur.isEmpty()) { //Vérification que l'accumulateur n'est pas vide
        this.pile.add(Double.valueOf(this.accumulateur)); //On ajoute la conversion de l'accumulateur en double dans la pile
        }
    }

    public Double pop() {
        return this.pile.pop(); //utilisation de la méthode de la classe Stack
    }

    public void drop() {
        this.pile.pop(); //On a pas compris le rôle de drop
    }

    public void swap() {
        if (pile.size() > 1) { //On vérifie qu'il y a au moins 2 éléments
            Double e1 = this.pile.pop();
            Double e2 = this.pile.pop();
            this.pile.add(e1);
            this.pile.add(e2); //On enlève les 2 derniers éléments et on les remets dans l'ordre inverse
        }

    }

    public void clear() {
        this.pile.clear();
        this.accumulateur = "";
    }

}

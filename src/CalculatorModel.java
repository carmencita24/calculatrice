
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> pile = new Stack<Double>();
    private String accumulateur = "";

    public String getAccu() {
        return accumulateur;
    }

    public Stack<Double> getPile() {
        return pile;
    }

    public void setAccu(String accumulateur) {
        this.accumulateur = accumulateur;
    }

    public void setPile(Stack<Double> pile) {
        this.pile = pile;
    }

    public void add() {
        if (pile.size() > 1) {
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push(e2 + e1);
        }
    }

    public void substract() {
        if (pile.size() > 1) {
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push(e2 - e1);
        }
    }

    public void multiply() {
        if (pile.size() > 1) {
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            this.pile.push((e2 * e1));
        }
    }

    public void divide() {
        if (pile.size() > 1) {
            double e1 = this.pile.pop();
            double e2 = this.pile.pop();
            if (e1 != 0) {
                this.pile.push(e2 / e1);
            }
        }
    }

    public void opposite() {
        setAccu(String.valueOf(Double.valueOf(getAccu())*(-1)));
    }

    public void push() {
        this.pile.add(Double.valueOf(this.accumulateur));
    }

    public Double pop() {
        return this.pile.pop();
    }

    public void drop() {
        this.pile.pop();
    }

    public void swap() {
        if (pile.size() > 1) {
            Double e1 = this.pile.pop();
            Double e2 = this.pile.pop();
            this.pile.add(e1);
            this.pile.add(e2);
        }

    }

    public void clear() {
        this.pile.clear();
        this.accumulateur = "";
    }

}

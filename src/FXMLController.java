import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FXMLController {
    CalculatorController calculator = new CalculatorController();
    @FXML
    VBox historique;

    @FXML
    public void keyboardPress(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();

        if (calculator.getModel().getAccu().equals("")) {
            if (id.equals("buttoncomma")) {
                calculator.change("0.");
            } else {
                calculator.change(id.replace("button", ""));
                
            }
            pushHistorique(Double.valueOf(calculator.getModel().getAccu()));
        } else {
            if (id.equals("buttoncomma")) {
                if (!calculator.getModel().getAccu().contains(".")) {
                    calculator.change(calculator.getModel().getAccu() + ".");
                    
                }
            } else {
                calculator.change(calculator.getModel().getAccu() + id.replace("button", ""));
                
            }
            historique.getChildren().set(historique.getChildren().size() - 1,
                        (new Label(calculator.getModel().getAccu())));
        }
    }

    @FXML
    public void push(ActionEvent event) {
        calculator.getModel().push();
        calculator.change("");
        pushHistorique(Double.valueOf(calculator.getModel().getAccu()));
    }

    @FXML
    public void add(ActionEvent event) {
        push(event);
        calculator.getModel().add();
        calculator.change("");
        pushHistorique(calculator.getModel().getPile().lastElement());
    }

    @FXML
    public void divide(ActionEvent event) {
        push(event);
        calculator.getModel().divide();
        calculator.change("");
        pushHistorique(calculator.getModel().getPile().lastElement());
    }

    @FXML
    public void clear(ActionEvent event) {
        calculator.getModel().clear();
        calculator.change("");
        historique.getChildren().clear();
    }

    @FXML
    public void drop(ActionEvent event) {
        if (!calculator.getModel().getAccu().isEmpty()) {
            calculator
                    .change(calculator.getModel().getAccu().substring(0, calculator.getModel().getAccu().length() - 1));

            historique.getChildren().set(historique.getChildren().size() - 1,
                    new Label(calculator.getModel().getAccu()));
        }
    }

    @FXML
    public void swap(ActionEvent event) {
        if (historique.getChildren().size() > 1) {
            calculator.getModel().swap();
            Label e1 = (Label) historique.getChildren().removeLast();
            Label e2 = (Label) historique.getChildren().removeLast();
            historique.getChildren().add(e1);
            historique.getChildren().add(e2);
            calculator.change(e2.getText());
        }

    }

    @FXML
    public void multiply(ActionEvent event) {
        push(event);
        calculator.getModel().multiply();
        calculator.change("");
        pushHistorique(calculator.getModel().getPile().lastElement());
    }

    @FXML
    public void opposite(ActionEvent event) {
        calculator.getModel().opposite();
        historique.getChildren().set(historique.getChildren().size() - 1, new Label(calculator.getModel().getAccu()));
    }

    @FXML
    public void substract(ActionEvent event) {
        push(event);
        calculator.getModel().substract();
        calculator.change("");
        pushHistorique(calculator.getModel().getPile().lastElement());
    }

    public void pushHistorique(Double value) {
        if (historique.getChildren().size() > 0 && ((Label) historique.getChildren().getLast()).getText().equals("")) {
            historique.getChildren().set(historique.getChildren().size() - 1, (new Label(String.format("%.2f", value).replace(".", ","))));
        } else {
            historique.getChildren().add((Node) (new Label(String.format("%.2f", value).replace(".", ","))));
        }
    }

}
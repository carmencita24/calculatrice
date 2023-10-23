import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FXMLController {
    CalculatorModel model = new CalculatorModel();
    @FXML
    VBox historique;

    @FXML
    public void keyboardPress(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();

        if (model.getAccu().equals("")) {
            model.setAccu(id.replace("button", ""));
            pushHistorique(model.getAccu());
        } else {
            model.setAccu(model.getAccu() + id.replace("button", ""));
            historique.getChildren().set(historique.getChildren().size() - 1, (new Label(model.getAccu())));
        }
    }

    @FXML
    public void push(ActionEvent event) {
        model.push();
        model.setAccu("");
        pushHistorique(model.getAccu());
    }

    @FXML
    public void add(ActionEvent event) {
        push(event);
        model.add();
        model.setAccu("");
        pushHistorique(model.getPile().lastElement().toString());
    }

    @FXML
    public void divide(ActionEvent event) {
        push(event);
        model.divide();
        model.setAccu("");
        pushHistorique(model.getPile().lastElement().toString());
    }

    @FXML
    public void clear(ActionEvent event) {
        model.clear();
        historique.getChildren().clear();
    }

    @FXML
    public void drop(ActionEvent event) {
        if(!model.getAccu().isEmpty()) {
        model.setAccu(model.getAccu().substring(0, model.getAccu().length()-1));
        
        historique.getChildren().set(historique.getChildren().size()-1, new Label(model.getAccu()));
        }
    }

    @FXML
    public void swap(ActionEvent event) {
        model.swap();
        if (historique.getChildren().size() > 1) {
            Label e1 = (Label)historique.getChildren().removeLast();
            Label e2 = (Label)historique.getChildren().removeLast();
            historique.getChildren().add(e1);
            historique.getChildren().add(e2);
            model.setAccu(e2.getText());
        }
        
    }

    @FXML
    public void multiply(ActionEvent event) {
        push(event);
        model.multiply();
        model.setAccu("");
        pushHistorique(model.getPile().lastElement().toString());
    }
    @FXML
    public void opposite(ActionEvent event) {
        model.opposite();
        historique.getChildren().set(historique.getChildren().size()-1, new Label(model.getAccu()));
    }

    @FXML
    public void substract(ActionEvent event) {
        push(event);
        model.substract();
        model.setAccu("");
        pushHistorique(model.getPile().lastElement().toString());
    }

    public void pushHistorique(String value) {
        if(historique.getChildren().size() > 0 && ((Label)historique.getChildren().getLast()).getText().equals("")) {
            historique.getChildren().set(historique.getChildren().size() - 1, (new Label(value)));
        } else {
            historique.getChildren().add((Node) (new Label(value)));
        }
    }

}
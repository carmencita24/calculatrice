import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FXMLController {
    CalculatorModelInterface model = new CalculatorModel();
    CalculatorControllerInterface calculator = new CalculatorController(model);


    @FXML //les @FXML permettent de dire à FXML d'aller chercher dans le fichier calculatrice.fxml le container qui a comme id "historique" 
    VBox historique;

    @FXML
    public void keyboardPress(ActionEvent event) {
        String id = ((Node) event.getSource()).getId(); //On récupère l'ID du bouton qui contient le chiffre sur lequel on a cliqué ou le comma

        if (model.getAccu().equals("")) { //Si l'accumulateur est vide
            if (id.equals("buttoncomma")) { //Si on a appuyé sur la virgule
                calculator.change("0."); //Si c'est vide et on appuie sur la virgule alors on commence par 0. ...
            } else {
                calculator.change(id.replace("button", "")); //Si ce n'est pas la virgule on enlève "button" à l'id ce qui laisse seulement le chiffre sur lequel on a appuyé
                
            }
            pushHistorique(model.getAccu()); //On envoie la valeur dans l'historique de calcul
        } else {
            if (id.equals("buttoncomma")) { //Si jamais l'accumulateur n'est pas vide et on appuie sur la virgule :
                if (!model.getAccu().contains(".")) { //On vérifie que l'accumulateur ne contient pas déjà une virgule
                    calculator.change(model.getAccu() + "."); //On ajoute un point à la fin (Un point et non une virgule pour la conversion en double)
                    
                }
            } else {
                calculator.change(model.getAccu() + id.replace("button", "")); //Si il ne s'agit pas de la virgule alors il s'agit d'un chiffre donc on ajoute la valeur du bouton
                
            }
            historique.getChildren().set(historique.getChildren().size() - 1,
                        (new Label(model.getAccu()))); //On modifie le dernier élément de l'historique en modifiant la valeur de l'accumulateur
        }
    }

    @FXML
    public void push(ActionEvent event) {
        if(!model.getAccu().isEmpty()) { //On vérifie que l'accumulateur n'est pas vide
        model.push(); //On envoie dans la pile l'accumulateur
        calculator.change(""); //On reset l'accumulateur
        pushHistorique(model.getAccu()); //On envoie dans l'historique de calcul
        }
    }

    @FXML
    public void add(ActionEvent event) {
        push(event); //On push (petite liberté : pas obligé de push avant de cliquer sur add)
        model.add(); //On additione
        pushHistorique(model.getPile().lastElement().toString()); //On envoie le résultat dans l'historique
    }

    @FXML
    public void divide(ActionEvent event) {
        push(event); //On push (petite liberté : pas obligé de push avant de cliquer sur divide)
        model.divide();//On divise
        pushHistorique(model.getPile().lastElement().toString()); //On envoie le résultat dans l'historique
    }

    @FXML
    public void multiply(ActionEvent event) {
        push(event); //On push (petite liberté : pas obligé de push avant de cliquer sur multiply)
        model.multiply();//On multiplie
        pushHistorique(model.getPile().lastElement().toString()); //On envoie le résultat dans l'historique
    }

    @FXML
    public void substract(ActionEvent event) {
        push(event); //On push (petite liberté : pas obligé de push avant de cliquer sur substract)
        model.substract(); // On soustrait
        pushHistorique(model.getPile().lastElement().toString()); //On envoie le résultat dans l'historique
    }

    @FXML
    public void clear(ActionEvent event) {
        model.clear(); //On demande au model de se nettoyer
        calculator.change(""); //On reset l'accumulateur
        historique.getChildren().clear(); //On nettoie l'historique
    }

    @FXML
    public void drop(ActionEvent event) { // Enlever le dernier caractère de l'accumulateur
        if (!model.getAccu().isEmpty()) { //On vérifie qu'il y est au moins un caractère
            calculator
                    .change(model.getAccu().substring(0, model.getAccu().length() - 1)); //On modifie la valeur de l'accumulateur par sa valeur auquel on enlève (substring) son dernier terme (calculator.getModel().getAccu().length() - 1)
            historique.getChildren().set(historique.getChildren().size() - 1,
                    new Label(model.getAccu())); //On modifie le dernier label de l'historique par la nouvelle valeur de l'accumulateur
        }
    }

    @FXML
    public void swap(ActionEvent event) {
        if (historique.getChildren().size() > 1) { //On vérifie qu'il y est au moins 2 élements dans l'historique
            model.swap(); //On swap la pile
            Label e1 = (Label) historique.getChildren().removeLast(); //On pop un élément
            Label e2 = (Label) historique.getChildren().removeLast(); //Puis un autre
            historique.getChildren().add(e1); //On les ajoute dans le sens inverse
            historique.getChildren().add(e2);
            calculator.change(e2.getText()); //On change la valeur de l'accumulateur par le dernier pop
        }

    }

    

    @FXML
    public void opposite(ActionEvent event) {
        model.opposite(); //On oppose le résultat (*(-1))
        historique.getChildren().set(historique.getChildren().size() - 1, new Label(model.getAccu())); //On modifie la dernière valeur de l'historique
    }


    public void pushHistorique(String value) { //On envoie dans l'historique
        if (historique.getChildren().size() > 0 && ((Label) historique.getChildren().getLast()).getText().equals("")) { //On regarde si le dernier élement de l'historique n'est pas vide pour pouvoir l'écraser
            historique.getChildren().set(historique.getChildren().size() - 1, (new Label(value))); //On récupère le dernier element et on met notre nouvelle valeur
        } else {
            historique.getChildren().add((Node) (new Label(value))); //On créer un nouveau label dans historique avec notre valeur
        }
    }

}
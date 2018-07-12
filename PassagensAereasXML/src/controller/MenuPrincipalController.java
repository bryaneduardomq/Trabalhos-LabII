package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuPrincipalController implements Initializable {
    
    @FXML
    private AnchorPane painelMenuPrincipal;
    
    @FXML
    private void buttonClient(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MenuCliente.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(painelMenuPrincipal.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
        
    }
    
    @FXML
    private void buttonPlane(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void buttonFlight(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void buttonSale(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void buttonReport(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void buttonLeave(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelMenuPrincipal.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}

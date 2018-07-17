package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cliente;
import model.DAO.ClienteDAO;

public class MenuClienteController implements Initializable {

    @FXML
    private AnchorPane painelMenuCliente;
    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteRG;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteContato;

    private ObservableList<Cliente> observableListaClientes;

    private List<Cliente> listaClientes;

    private Cliente c;

    private ClienteDAO cd;

    @FXML
    private TextField txbNome;

    @FXML
    private TextField txbRg;

    @FXML
    private TextField txbTelefone;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnVoltar;

    @FXML
    private AnchorPane painelCadastrarCliente;

    @FXML
    private AnchorPane painelEditarCliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cd = new ClienteDAO();

        //Codigo meio redundante - por isso as vezes é melhor um controller para cada view 
        if (tableViewClientes != null) {
            try {
                loadTableViewClientes();
            } catch (SQLException ex) {
                Logger.getLogger(MenuClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadTableViewClientes() throws SQLException {
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        tableColumnClienteContato.setCellValueFactory(new PropertyValueFactory<>("contato"));

        listaClientes = cd.list();

        observableListaClientes = FXCollections.observableArrayList(listaClientes);
        tableViewClientes.setItems(observableListaClientes);

    }

    @FXML
    private void addClient(ActionEvent event) throws IOException, SQLException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/CadastroCliente.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(painelMenuCliente.getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();
        loadTableViewClientes();

    }

    @FXML
    private void changeClient(ActionEvent event) throws IOException, SQLException {
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();

        if (cliente != null) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/EditarCliente.fxml"));
            Parent root = (Parent) loader.load();

            MenuClienteController controller = (MenuClienteController) loader.getController();
            controller.setCliente(cliente);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(painelMenuCliente.getScene().getWindow());
            stage.setResizable(false);
            stage.showAndWait();
            loadTableViewClientes();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Cliente não selecionado!");

            alert.showAndWait();
        }

    }

    @FXML
    private void removeClient(ActionEvent event) throws IOException, SQLException {
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                cd.delete(cliente);
                this.loadTableViewClientes();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Delete");
                alert.setHeaderText(null);
                alert.setContentText("Cliente excluído com sucesso!");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Cliente não selecionado!");

            alert.showAndWait();
        }
    }

    @FXML
    private void efetuarEdicaoCliente(ActionEvent event) throws IOException, SQLException {
        c.setNome(txbNome.getText());
        c.setContato(txbTelefone.getText());
        cd.update(c);
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("Cliente atualizado com sucesso!");

        alert.showAndWait();
    }

    @FXML
    private void returnCadastroCliente(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelEditarCliente.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void returnClient(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelMenuCliente.getScene().getWindow();
        stage.close();
    }

    public Cliente getCliente() {
        return c;
    }

    public void setCliente(Cliente cliente) {
        this.c = cliente;
        txbRg.setText(Integer.toString(cliente.getRg()));
        txbRg.setEditable(false);
        txbNome.setText(cliente.getNome());
        txbTelefone.setText(cliente.getContato());
    }
}

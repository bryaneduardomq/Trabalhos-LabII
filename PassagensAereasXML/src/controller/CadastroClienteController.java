package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DAO.ClienteDAO;
import model.Cliente;
import model.bd.Conexao;

public class CadastroClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewCliente;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;

    @FXML
    private TableColumn<Cliente, Integer> tableColumnClienteRG;

    @FXML
    private TableColumn<Cliente, String> tableColumnClienteContato;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonRemove;

    private List<Cliente> listClientes;

    private ObservableList<Cliente> observableListClientes;



    //private final Connection con = Conexao.getConnection();
    private final ClienteDAO cd = new ClienteDAO();

 

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadTableViewCliente();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadTableViewCliente() throws SQLException {
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        tableColumnClienteContato.setCellValueFactory(new PropertyValueFactory<>("contato"));

        listClientes = cd.list();

        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewCliente.setItems(observableListClientes);

    }

}

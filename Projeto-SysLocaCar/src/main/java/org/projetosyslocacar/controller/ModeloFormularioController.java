package org.projetosyslocacar.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.util.StringConverter;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import org.projetosyslocacar.model.Modelo;
import org.projetosyslocacar.model.Marca;
import org.projetosyslocacar.model.Categoria;
import org.projetosyslocacar.dao.ModeloDAO;
import org.projetosyslocacar.dao.MarcaDAO;
import org.projetosyslocacar.dao.CategoriaDAO;

public class ModeloFormularioController implements Initializable {

    @FXML private TextField txtId;
    @FXML private TextField txtNome;
    @FXML private TextField txtAno;
    @FXML private ComboBox<String> cmbMarca;
    @FXML private ComboBox<String> cmbCategoria;
    @FXML private TextField txtIdModelo;
    @FXML private TableView<Modelo> tabelaModelos;
    @FXML private TableColumn<Modelo, Long> colId;
    @FXML private TableColumn<Modelo, String> colNome;
    @FXML private TableColumn<Modelo, Date> colAno;
    @FXML private TableColumn<Modelo, String> colMarca;
    @FXML private TableColumn<Modelo, String> colCategoria;
    @FXML private TableColumn<Modelo, Integer> colCodModelo;
    @FXML private TableColumn<Modelo, Void> colAcoes; // Para botões de ação na linha

    private Modelo modelo;
    private final ModeloDAO modeloDAO = new ModeloDAO(Modelo.class);
    private final MarcaDAO marcaDAO = new MarcaDAO(Marca.class);
    private final CategoriaDAO categoriaDAO = new CategoriaDAO(Categoria.class);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Carrega os ComboBoxes com dados do banco ao iniciar o Controller
        cmbMarca.setItems(FXCollections.observableArrayList(marcaDAO.GetNomes(Marca.class)));
        cmbCategoria.setItems(FXCollections.observableArrayList(categoriaDAO.GetNomes()));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colCodModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));

        // Mapeamento de objetos (Marca e Categoria)
        colMarca.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMarca().getNome()));

        colCategoria.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCategoria().getNome()));

        // Carrega os dados
        carregarTabelaModelos();

        // 🚨 Adicione um listener para carregar os dados no formulário ao clicar na tabela
        tabelaModelos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetalhesModelo(newValue));
    }

    private void carregarTabelaModelos() {
        List<Modelo> modelos; // Garanta que este método funciona
        modelos = modeloDAO.buscarTodos();
        ObservableList<Modelo> obsList = FXCollections.observableArrayList(modelos);
        tabelaModelos.setItems(obsList);
    }

    // ... (Seu método handleSalvar) ...

    @FXML
    private void handleLimpar() {
        // Lógica para limpar os campos do formulário para um novo cadastro
        // Ex: txtId.setText(""), txtNome.setText(""), cmbMarca.getSelectionModel().clearSelection()
        tabelaModelos.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleDeletarModelo() {
        Modelo modeloSelecionado = tabelaModelos.getSelectionModel().getSelectedItem();
        if (modeloSelecionado != null) {
            modeloDAO.excluir(modeloSelecionado);
            carregarTabelaModelos(); // Recarrega para refletir a exclusão
        }
    }

    // ... (handleEditarModelo chamaria mostrarDetalhesModelo e handleSalvar faria o merge)

    private void mostrarDetalhesModelo(Modelo modelo) {
        if (modelo != null) {
            // Preenche o formulário com os dados do modelo selecionado
            txtId.setText(String.valueOf(modelo.getId()));
            txtNome.setText(modelo.getNome());
            // ... (Preencher campos Ano, ComboBox Marca e Categoria)
        }
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        if (modelo != null) {
            txtId.setText(String.valueOf(modelo.getId()));
            txtNome.setText(modelo.getNome());

            // Tratamento do campo 'Date ano' (se for apenas o ano, pode simplificar)
            if (modelo.getAno() != null) {
                txtAno.setText(new SimpleDateFormat("yyyy").format(modelo.getAno()));
            }

            txtIdModelo.setText(String.valueOf(modelo.getIdModelo()));

            // Seleciona o item correto no ComboBox
            cmbMarca.getSelectionModel().select(modelo.getNome());
            cmbCategoria.getSelectionModel().select(modelo.getNome());
        }
    }

    @FXML
    void handleSalvar(ActionEvent event) {
        try {
            if (modelo == null) {
                modelo = new Modelo();
            }

            // 1. Coleta e validação de dados
            modelo.setNome(txtNome.getText());
            MarcaDAO aux = new MarcaDAO(Marca.class);
            Marca marca = aux.FindNome(cmbMarca.getSelectionModel().getSelectedItem());
            modelo.setMarca(marca);
            CategoriaDAO aux2 = new CategoriaDAO(Categoria.class);
            Categoria categoria = aux2.FindNome(cmbCategoria.getSelectionModel().getSelectedItem());
            modelo.setCategoria(categoria);

            // Tenta converter o campo 'Ano' para Date (simplificado para o ano como String)
            try {
                // Você pode ajustar isso se usar DatePicker
                String anoStr = txtAno.getText();
                if (!anoStr.isEmpty()) {
                    // Exemplo: converte "2024" para um objeto Date
                    SimpleDateFormat df = new SimpleDateFormat("yyyy");
                    modelo.setAno(df.parse(anoStr));
                }
            } catch (Exception e) {
                new Alert(AlertType.ERROR, "Formato do Ano inválido (use YYYY).", ButtonType.OK).show();
                return;
            }

            // Garante que os objetos relacionados foram selecionados
            if (cmbMarca.getValue() == null || cmbCategoria.getValue() == null) {
                new Alert(AlertType.ERROR, "Marca e Categoria são obrigatórios.", ButtonType.OK).show();
                return;
            }

            // Tenta converter o campo 'idModelo' para int
            try {
                modelo.setIdModelo(Integer.parseInt(txtIdModelo.getText()));
            } catch (NumberFormatException e) {
                new Alert(AlertType.ERROR, "O código ID do Modelo deve ser um número.", ButtonType.OK).show();
                return;
            }


            // 2. Salva (Create/Update)
            modeloDAO.salvar(modelo);

            new Alert(AlertType.INFORMATION, "Modelo salvo com sucesso!", ButtonType.OK).show();
            //fecharJanela();

        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar o modelo: " + e.getMessage(), ButtonType.OK).show();
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditarModelo() {
        Modelo modeloSelecionado = tabelaModelos.getSelectionModel().getSelectedItem();
        if (modeloSelecionado != null) {
            // Se houver seleção, o listener já chamou mostrarDetalhesModelo,
            // mas podemos chamá-lo novamente para garantir ou se o botão for a principal interação.
            mostrarDetalhesModelo(modeloSelecionado);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma Seleção");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um modelo na tabela para editar.");
            alert.showAndWait();
        }
    }

    @FXML
    void handleCancelar(ActionEvent event) {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) txtNome.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleLimparFormulario() {
        // Limpa TextFields
        txtId.setText("Gerado Automaticamente"); // O ID não é editável
        txtNome.setText("");
        txtAno.setText("");
        txtIdModelo.setText("");

        // Limpa ComboBoxes
        cmbMarca.getSelectionModel().clearSelection();
        cmbCategoria.getSelectionModel().clearSelection();

        // Remove a seleção da Tabela
        tabelaModelos.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleAtualizarLista() {
        // O método que busca os dados do banco e popula a tabela
        carregarTabelaModelos();

        // Opcional: Mostra uma mensagem simples
        System.out.println("Lista de modelos atualizada.");
    }
}
package app;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TreeTableColumn<Model, String> colPaciente;

    @FXML
    private TreeTableColumn<Model, String> colMedico;

    @FXML
    private TreeTableColumn<Model, String> colData;

    @FXML
    private TreeTableColumn<Model, String> colEspec;

    @FXML
    private JFXTreeTableView<Model> treeTableView;



    ObservableList<Model> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colData.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().data;
            }
        });

        colPaciente.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().paciente;
            }
        });

        colMedico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().medico;
            }
        });
        colEspec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().especialidade;
            }
        });
        // Cria uma lista para testes.
        list= FXCollections.observableArrayList();
        TreeItem<Model> root=new RecursiveTreeItem<Model>(list, RecursiveTreeObject::getChildren);
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);
        list.addAll(new Model("10/05/2018","Jonas Silva","Dr. Ray","Cirurgião plástico"));
        list.addAll(new Model("20/10/2018","Felipe Smith","Hans Chucrute","Urologista"));
    }
    }

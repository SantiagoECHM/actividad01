package com.pasteleria.gui.Menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//Panel inicial tras desbloqueo
public class ContenedorGeneral extends BorderPane {
    MenuExpandible menuExpandible;
    TabPane tabPane = new TabPane();
    Stage stage;

    public ContenedorGeneral(Stage stage1){
        this.stage=stage1;
         menuExpandible = new MenuExpandible();
        Tab tab = new Tab("Apps");
        StackPane layout = new StackPane();
        LanzadorSecciones aplicaciones = new LanzadorSecciones(tabPane, tab,stage);
        layout.getChildren().add(aplicaciones);
        tab.setContent(layout);
        //tab.setClosable(false);
        tabPane.getTabs().add(tab);

        Tab newTab = new Tab("+");
        tabPane.getTabs().add(newTab);

        newTab.setOnSelectionChanged(e->{
            Tab nuevoTab = new Tab("Apps"+tabPane.getTabs().size());
            StackPane nuevoLayout = new StackPane();
            LanzadorSecciones nuevasAplicaciones = new LanzadorSecciones(tabPane, nuevoTab, stage);
            nuevoTab.setContent(nuevasAplicaciones);
            tabPane.getTabs().add(tabPane.getTabs().size()-1, nuevoTab);
            tabPane.getSelectionModel().select(tabPane.getTabs().size()-2);
        });
        setLeft(menuExpandible);
        setCenter(tabPane);
    }

    private void manejoSalir(){
        Alert alertaSalir = new Alert(Alert.AlertType.CONFIRMATION);
        alertaSalir.setTitle("Advertencia");
        alertaSalir.setContentText("¿Esta seguro que quiere salir?");
        ButtonType respuesta = alertaSalir.showAndWait().orElse(ButtonType.OK);
        if (ButtonType.OK.equals(respuesta))
            System.exit(0);
    }
}

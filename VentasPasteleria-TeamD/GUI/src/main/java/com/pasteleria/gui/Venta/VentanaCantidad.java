package com.pasteleria.gui.Venta;

import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.gui.VentanaWaring;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VentanaCantidad extends BorderPane {
    private ComboBox<Integer> cbCantidad;
    private List<Integer> listanumero;
    private Button bAceptar;
    private Stage stage;
    public VentanaCantidad(PastelEntidad pastelEntidad, Stage stage){
        this.stage=stage;
        cbCantidad = new ComboBox();
        listanumero = new ArrayList<>();


        for(int i=pastelEntidad.getCantidad();i>0;i--){
            listanumero.add(i);
        }
        cbCantidad.getItems().addAll(listanumero);
        bAceptar = new Button("Aceptar");
        bAceptar.setOnAction(evtm->{
            if(comprobar())
                stage.close();
        });
        setCenter(cbCantidad);
        setBottom(bAceptar);

    }

    private boolean comprobar() {
        if (cbCantidad.getSelectionModel().getSelectedItem() == null) {
            VentanaWaring ventanaWaring = new VentanaWaring("No se ha seleccionado la cantidad", "Error");
            return false;
        }
        return true;
    }

    public Integer getResultado(){
        return cbCantidad.getSelectionModel().getSelectedItem();
    }
}

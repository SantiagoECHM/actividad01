package com.pasteleria.gui;

import com.pasteleria.CONT.DireccionesController;
import com.pasteleria.CONT.PastelesController;
import com.pasteleria.CONT.TrabajadoresController;
import com.pasteleria.CONT.VentasController;
import com.pasteleria.MOD.DireccionEntidad;
import com.pasteleria.MOD.PastelEntidad;
import com.pasteleria.MOD.TrabajadorEntidad;
import com.pasteleria.MOD.VentaEntidad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaID = new DireccionesController().CrearListaID();
        System.out.println(listaID.toString());
        int id = listaID.get(listaID.size()-1);
        System.out.println(id);


    }
}


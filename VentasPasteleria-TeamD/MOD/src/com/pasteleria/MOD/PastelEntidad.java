package com.pasteleria.MOD;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pastel", schema = "bdpasteleriav4")
@NamedQueries({
        //Todos los datos
        @NamedQuery(name = "Pastel.MostrarTodos", query = "Select a from PastelEntidad a order by a.idPastel"),
        //Traer solo campos
        @NamedQuery(name = "Pastel.CrearListaID", query = "Select pasteles.idPastel from PastelEntidad as pasteles order by pasteles.idPastel"),
        @NamedQuery(name = "Pastel.CrearListaCantidad", query = "Select pasteles.cantidad from PastelEntidad as pasteles where pasteles.idPastel = :id")
})
public class PastelEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPastel", nullable = false)
    private int idPastel;
    @Basic
    @Column(name = "Color", nullable = false, length = 25)
    private String color;
    @Basic
    @Column(name = "Forma", nullable = false, length = 25)
    private String forma;
    @Basic
    @Column(name = "Size", nullable = false, length = 15)
    private String size;
    @Basic
    @Column(name = "Relleno", nullable = false, length = 25)
    private String relleno;
    @Basic
    @Column(name = "TipoPan", nullable = false, length = 25)
    private String tipoPan;
    @Basic
    @Column(name = "NumPisos", nullable = false)
    private int numPisos;
    @Basic
    @Column(name = "Precio", nullable = false, precision = 0)
    private int precio;
    @Basic
    @Column(name = "Descripcion", nullable = true, length = 100)
    private String descripccion;
    @Basic
    @Column(name = "EstadoPastel", nullable = false, length = 15)
    private String estadoPastel;
    @Basic
    @Column(name = "Estilo", nullable = false, length = 15)
    private String estilo;
    @Basic
    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    public PastelEntidad() {
    }

    public PastelEntidad(String color, String forma, String size, String relleno, String tipoPan, int numPisos, int precio, String descripccion, String estadoPastel, String estilo, int cantidad) {
        this.color = color;
        this.forma = forma;
        this.size = size;
        this.relleno = relleno;
        this.tipoPan = tipoPan;
        this.numPisos = numPisos;
        this.precio = precio;
        this.descripccion = descripccion;
        this.estadoPastel = estadoPastel;
        this.estilo = estilo;
        this.cantidad = cantidad;
    }

    public PastelEntidad(int idPastel, String color, String forma, String size, String relleno, String tipoPan, int numPisos, int precio, String descripccion, String estadoPastel, String estilo, int cantidad) {
        this.idPastel = idPastel;
        this.color = color;
        this.forma = forma;
        this.size = size;
        this.relleno = relleno;
        this.tipoPan = tipoPan;
        this.numPisos = numPisos;
        this.precio = precio;
        this.descripccion = descripccion;
        this.estadoPastel = estadoPastel;
        this.estilo = estilo;
        this.cantidad = cantidad;
    }

    public PastelEntidad(PastelEntidad pastel) {
        this.idPastel = pastel.getIdPastel();
        this.color = pastel.getColor();
        this.forma = pastel.getForma();
        this.size = pastel.getSize();
        this.relleno = pastel.getRelleno();
        this.tipoPan = pastel.getTipoPan();
        this.numPisos = pastel.getNumPisos();
        this.precio = pastel.getPrecio();
        this.descripccion = pastel.getDescripccion();
        this.estadoPastel = pastel.getEstadoPastel();
        this.estilo = pastel.getEstilo();
        this.cantidad = pastel.getCantidad();
    }



    public int getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(int idPastel) {
        this.idPastel = idPastel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public String getEstadoPastel() {
        return estadoPastel;
    }

    public void setEstadoPastel(String estadoPastel) {
        this.estadoPastel = estadoPastel;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public PastelEntidad setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PastelEntidad that = (PastelEntidad) o;
        return idPastel == that.idPastel && numPisos == that.numPisos && precio == that.precio && cantidad == that.cantidad && Objects.equals(color, that.color) && Objects.equals(forma, that.forma) && Objects.equals(size, that.size) && Objects.equals(relleno, that.relleno) && Objects.equals(tipoPan, that.tipoPan) && Objects.equals(descripccion, that.descripccion) && Objects.equals(estadoPastel, that.estadoPastel) && Objects.equals(estilo, that.estilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPastel, color, forma, size, relleno, tipoPan, numPisos, precio, descripccion, estadoPastel, estilo, cantidad);
    }
}

package com.pasteleria.MOD2.MOD;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "direccion", schema = "bdproveedores")
@NamedQueries({
        @NamedQuery(name = "Direccion.MostrarTodas", query = "Select direcciones from EntidadDireccion direcciones order by direcciones.iddIreccion"),
        @NamedQuery(name = "Direccion.ListarID", query = "Select direcciones.iddIreccion from EntidadDireccion as direcciones order by direcciones.iddIreccion"),
        @NamedQuery(name = "Direcciones.CrearListaCiudades", query="select direccion.ciudad from EntidadDireccion as direccion order by direccion.ciudad"),
        @NamedQuery(name = "Direcciones.CrearListaColonias", query="select direccion.colonia from EntidadDireccion as direccion order by direccion.ciudad"),
})
public class EntidadDireccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDDIreccion", nullable = false)
    private int iddIreccion;
    @Basic
    @Column(name = "Ciudad", nullable = false, length = 25)
    private String ciudad;
    @Basic
    @Column(name = "Colonia", nullable = false, length = 25)
    private String colonia;
    @Basic
    @Column(name = "Calle", nullable = false, length = 25)
    private String calle;
    @Basic
    @Column(name = "NumExterior", nullable = false)
    private int numExterior;
    @Basic
    @Column(name = "NumInterior", nullable = true)
    private Integer numInterior;
    @Basic
    @Column(name = "Detalles", nullable = false, length = 100)
    private String detalles;

    public int getIddIreccion() {
        return iddIreccion;
    }

    public void setIddIreccion(int iddIreccion) {
        this.iddIreccion = iddIreccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadDireccion that = (EntidadDireccion) o;
        return iddIreccion == that.iddIreccion && numExterior == that.numExterior && Objects.equals(ciudad, that.ciudad) && Objects.equals(colonia, that.colonia) && Objects.equals(calle, that.calle) && Objects.equals(numInterior, that.numInterior) && Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddIreccion, ciudad, colonia, calle, numExterior, numInterior, detalles);
    }
}

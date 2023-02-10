package com.pasteleria.MOD;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "direccion", schema = "bdpasteleriav4")
@NamedQueries({
        //ListarTodas lista por ID
        //Listado de todos los datos de diversas formas
        @NamedQuery(name = "Direcciones.ListarTodas", query = "Select direcciones from DireccionEntidad direcciones order by direcciones.id"),
        @NamedQuery(name = "Direcciones.ListarPorCiudad", query ="Select direcciones from DireccionEntidad direcciones order by direcciones.ciudad"),
        @NamedQuery(name = "Direcciones.ListarPorColonia", query ="Select direcciones from DireccionEntidad direcciones order by direcciones.colonia"),
        @NamedQuery(name = "Direcciones.ListarPorCalle", query ="Select direcciones from DireccionEntidad direcciones order by direcciones.calle"),
        //Listado de datos especificos
        @NamedQuery(name = "Direcciones.CrearListaID", query="select direccion.idDireccion from DireccionEntidad as direccion order by direccion.idDireccion"),
        @NamedQuery(name = "Direcciones.CrearListaCiudades", query="select direccion.ciudad from DireccionEntidad as direccion order by direccion.ciudad"),
        @NamedQuery(name = "Direcciones.CrearListaColonias", query="select direccion.colonia from DireccionEntidad as direccion order by direccion.colonia"),

})
public class DireccionEntidad {
    public DireccionEntidad() {
    }

    public DireccionEntidad(String ciudad, String colonia, String calle, Integer numInterior, int numExterior, String detalles) {
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numInterior = numInterior;
        this.numExterior = numExterior;
        this.detalles = detalles;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDDireccion", nullable = false)
    private int idDireccion;
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
    @Column(name = "NumInterior", nullable = true)
    private Integer numInterior;
    @Basic
    @Column(name = "NumExterior", nullable = false)
    private int numExterior;
    @Basic
    @Column(name = "Detalles", nullable = false, length = 100)
    private String detalles;
    @OneToMany(mappedBy = "direccionIdDireccion")
    private Collection<ClienteEntidad> clientesByIdDireccion;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
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
        DireccionEntidad that = (DireccionEntidad) o;
        return idDireccion == that.idDireccion && numExterior == that.numExterior && Objects.equals(ciudad, that.ciudad) && Objects.equals(colonia, that.colonia) && Objects.equals(calle, that.calle) && Objects.equals(numInterior, that.numInterior) && Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, ciudad, colonia, calle, numInterior, numExterior, detalles);
    }

    public Collection<ClienteEntidad> getClientesByIdDireccion() {
        return clientesByIdDireccion;
    }

    @Override
    public String toString() {
        return "Ciudad: " + ciudad + '\n' +
                " Colonia: " + colonia + '\n' +
                " Calle: " + calle + '\n' +
                " NumInterior: " + numInterior +
                " Detalles: " + detalles + '\n';
    }

    public void setClientesByIdDireccion(Collection<ClienteEntidad> clientesByIdDireccion) {
        this.clientesByIdDireccion = clientesByIdDireccion;
    }
}

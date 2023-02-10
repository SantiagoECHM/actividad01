package com.pasteleria.MOD2.MOD;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Mercancia.ListarTodas", query = "select mercancias from EntidadMercancia mercancias order by mercancias.idMercancia"),
        @NamedQuery(name = "Mercancia.CrearListaNombres", query = "select mercancia.nombre from EntidadMercancia as mercancia order by mercancia.nombre"),
        @NamedQuery(name = "Mercancia.CrearListaID", query = "select mercancia.idMercancia from EntidadMercancia as mercancia order by mercancia.idMercancia"),
        @NamedQuery(name = "Mercancia.BuscarID", query = "select mercancia from EntidadMercancia mercancia where mercancia.idMercancia= :id"),
})
@Table(name = "mercancia", schema = "bdproveedores")
public class EntidadMercancia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDMercancia", nullable = false)
    private int idMercancia;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 25)
    private String nombre;
    @Basic
    @Column(name = "Caducidad", nullable = true)
    private Date caducidad;
    @Basic
    @Column(name = "CantEntregada", nullable = false, precision = 0)
    private double cantEntregada;
    @Basic
    @Column(name = "PrecioTotal", nullable = false, precision = 0)
    private double precioTotal;
    @OneToMany(mappedBy = "mercanciaByMercanciaIdMercancia")
    private Collection<EntidadEntrega> entregasByIdMercancia;

    public int getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(int idMercancia) {
        this.idMercancia = idMercancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public double getCantEntregada() {
        return cantEntregada;
    }

    public void setCantEntregada(double cantEntregada) {
        this.cantEntregada = cantEntregada;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadMercancia that = (EntidadMercancia) o;
        return idMercancia == that.idMercancia && Double.compare(that.cantEntregada, cantEntregada) == 0 && Double.compare(that.precioTotal, precioTotal) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(caducidad, that.caducidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMercancia, nombre, caducidad, cantEntregada, precioTotal);
    }

    public Collection<EntidadEntrega> getEntregasByIdMercancia() {
        return entregasByIdMercancia;
    }

    public void setEntregasByIdMercancia(Collection<EntidadEntrega> entregasByIdMercancia) {
        this.entregasByIdMercancia = entregasByIdMercancia;
    }
}

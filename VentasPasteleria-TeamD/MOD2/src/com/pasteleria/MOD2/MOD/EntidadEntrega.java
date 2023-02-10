package com.pasteleria.MOD2.MOD;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "entrega", schema = "bdproveedores")
@IdClass(EntidadEntregaPK.class)
@NamedQueries({
        @NamedQuery(name = "Entrega.MostrarTodas", query = "select entrega from EntidadEntrega entrega order by entrega.fecha"),
        @NamedQuery(name = "Entrega.SeleccionarUna", query = "select entrega from EntidadEntrega entrega where entrega.proveedorIdProveedor= :proveedor and entrega.mercanciaIdMercancia= :mercancia"),
        @NamedQuery(name = "Entrega.SeleccionarProveedor", query = "select entrega from EntidadEntrega entrega where entrega.proveedorIdProveedor= :proveedor"),
        @NamedQuery(name = "Entrega.SeleccionarMercancia", query = "select entrega from EntidadEntrega entrega where entrega.mercanciaIdMercancia= :mercancia"),
})
public class EntidadEntrega {
    @Basic
    @Column(name = "Fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "Tipo", nullable = false, length = 20)
    private String tipo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Proveedor_IDProveedor", nullable = false)
    private int proveedorIdProveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Mercancia_IDMercancia", nullable = false)
    private int mercanciaIdMercancia;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getProveedorIdProveedor() {
        return proveedorIdProveedor;
    }

    public void setProveedorIdProveedor(int proveedorIdProveedor) {
        this.proveedorIdProveedor = proveedorIdProveedor;
    }

    public int getMercanciaIdMercancia() {
        return mercanciaIdMercancia;
    }

    public void setMercanciaIdMercancia(int mercanciaIdMercancia) {
        this.mercanciaIdMercancia = mercanciaIdMercancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadEntrega that = (EntidadEntrega) o;
        return proveedorIdProveedor == that.proveedorIdProveedor && mercanciaIdMercancia == that.mercanciaIdMercancia && Objects.equals(fecha, that.fecha) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tipo, proveedorIdProveedor, mercanciaIdMercancia);
    }
}

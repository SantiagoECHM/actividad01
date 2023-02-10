package com.pasteleria.MOD2.MOD;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EntidadEntregaPK implements Serializable {
    @Column(name = "Proveedor_IDProveedor", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proveedorIdProveedor;
    @Column(name = "Mercancia_IDMercancia", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mercanciaIdMercancia;

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
        EntidadEntregaPK that = (EntidadEntregaPK) o;
        return proveedorIdProveedor == that.proveedorIdProveedor && mercanciaIdMercancia == that.mercanciaIdMercancia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(proveedorIdProveedor, mercanciaIdMercancia);
    }
}

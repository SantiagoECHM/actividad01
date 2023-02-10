package com.pasteleria.MOD;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TieneEntidadPK implements Serializable {

    public TieneEntidadPK() {
    }

    public TieneEntidadPK(int pastelIdPastel, int ventaIdVenta) {
        this.pastelIdPastel = pastelIdPastel;
        this.ventaIdVenta = ventaIdVenta;
    }

    @Column(name = "Pastel_IDPastel", nullable = false)
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pastelIdPastel;
    @Column(name = "Venta_IDVenta", nullable = false)
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ventaIdVenta;

    public int getPastelIdPastel() {
        return pastelIdPastel;
    }

    public void setPastelIdPastel(int pastelIdPastel) {
        this.pastelIdPastel = pastelIdPastel;
    }

    public int getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(int ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TieneEntidadPK that = (TieneEntidadPK) o;
        return pastelIdPastel == that.pastelIdPastel && ventaIdVenta == that.ventaIdVenta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pastelIdPastel, ventaIdVenta);
    }
}

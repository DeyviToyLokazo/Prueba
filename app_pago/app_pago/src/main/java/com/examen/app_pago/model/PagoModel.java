package com.examen.app_pago.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "pago")
public class PagoModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    private Integer idPago;

    @Column(name = "idfactura")
    private Integer idFactura;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP) // Asegura el formato de fecha y hora
    private String fecha;

    // Constructor personalizado para inicializar automáticamente 'fecha'
    public PagoModel() {
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        this.setFecha(dateFormat.format(date));
    }
}
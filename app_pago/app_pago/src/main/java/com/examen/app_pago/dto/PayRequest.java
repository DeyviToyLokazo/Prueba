package com.examen.app_pago.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PayRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id_invoice; //factura
    private double amount; //monto
}

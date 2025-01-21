package com.examen.app_movement.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movimiento")
public class MovimientoModel {
    @Id
    private String _id;
   // private Integer id;
    private Integer idFactura;
    private double monto;
    private String fecha;
}

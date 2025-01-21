package com.examen.app_movement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.app_movement.model.MovimientoModel;
import com.examen.app_movement.service.MovimientoService;

@Controller
@RequestMapping("/api/movimiento")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;


  @GetMapping("/findAll")
  public ResponseEntity<List<MovimientoModel>> getAll() {
    return new ResponseEntity<>(
      movimientoService.getAll(),
      HttpStatus.OK
    );
  }

  @PostMapping("/create")
  public ResponseEntity<MovimientoModel> create(@RequestBody MovimientoModel movimiento) {
    return new ResponseEntity<>(
      movimientoService.create(movimiento),
      HttpStatus.CREATED
    );
  }


@PutMapping("/update/{id}")
public ResponseEntity<MovimientoModel> update(@PathVariable(value = "id") String id,@RequestBody MovimientoModel movi) {
    // Verificar si el objeto tiene el ID
    if (movi.get_id() == null || movi.get_id().isEmpty()) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // En caso de que no venga el ID en el body
    }
    
    // Buscar el documento en la base de datos usando el ID del cuerpo
    //Optional<MovimientoModel> existingMovimiento = movimientoService.getById(movi.get_id());
    Optional<MovimientoModel> existingMovimiento = Optional.ofNullable(movimientoService.getById(movi.get_id()));
    
    if (existingMovimiento.isPresent()) {
        // Obtener el movimiento existente
        MovimientoModel movimiento = existingMovimiento.get();
        
        // Actualizar los valores del movimiento
        movimiento.setIdFactura(movi.getIdFactura());
        movimiento.setMonto(movi.getMonto());
        movimiento.setFecha(movi.getFecha());
        
        // Guardar el movimiento actualizado
        MovimientoModel updatedMovimiento = movimientoService.update(movimiento);
        
        return new ResponseEntity<>(updatedMovimiento, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si no se encuentra el movimiento
    }
}



  @GetMapping("/getById/{id}")
  public ResponseEntity<MovimientoModel> getById(@PathVariable(value = "id") String id) {
    return new ResponseEntity<>(
      movimientoService.getById(id),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
    if (movimientoService.delete(id)) {
      return new ResponseEntity<>(
        HttpStatus.OK
      );
    }
    return new ResponseEntity<>(
      HttpStatus.NOT_FOUND
    );
  }

}

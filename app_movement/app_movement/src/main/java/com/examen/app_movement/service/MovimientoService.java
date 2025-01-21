package com.examen.app_movement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.app_movement.model.MovimientoModel;
import com.examen.app_movement.respository.MovimientoRepository;

@Service
public class MovimientoService implements IMovimientoService{
    @Autowired
    private MovimientoRepository repository;
    @Override
    public List<MovimientoModel> getAll() {
        return repository.findAll();
    }
    @Override
    public MovimientoModel getById(String id) {
        MovimientoModel movimiento = repository.findById(id).get();
        return movimiento;
    }
    @Override
    public MovimientoModel create(MovimientoModel movimiento) {
        return repository.save(movimiento);
    }
    @Override
    public MovimientoModel update(MovimientoModel movimiento) {
        if(!repository.existsById(movimiento.get_id())) {
            return null;
        }
        return repository.save(movimiento);
    }
    @Override
    public boolean delete(String id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
          }
          return false;
    }
    
    

    
}

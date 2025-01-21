package com.examen.app_movement.service;

import java.util.List;

import com.examen.app_movement.model.MovimientoModel;

public interface IMovimientoService {
    public List<MovimientoModel> getAll();

    public MovimientoModel getById(String _id);

    public MovimientoModel create(MovimientoModel movimiento);

    public MovimientoModel update( MovimientoModel movimiento);

    public boolean delete(String _id);
}

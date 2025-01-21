package com.examen.app_pago.services;

import java.util.List;

import com.examen.app_pago.model.PagoModel;

public interface IPagoService {
    public List<PagoModel> findAll();
    public PagoModel findById(Integer id);
    public PagoModel add(PagoModel model);
    public PagoModel update(PagoModel model);
    public Boolean delete(Integer id);
}

package com.examen.app_factura.services;

import java.util.List;

import com.examen.app_factura.model.FacturaModel;

public interface IFacturaModel {
    public List<FacturaModel> findAll();
    public FacturaModel findById(Integer id);
    public FacturaModel add(FacturaModel model);
    public FacturaModel update(FacturaModel model);
    public Boolean delete(Integer id);
}

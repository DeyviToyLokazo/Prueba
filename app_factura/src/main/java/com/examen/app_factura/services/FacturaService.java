package com.examen.app_factura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.app_factura.model.FacturaModel;
import com.examen.app_factura.repository.IFacturaRepository;
@Service
public class FacturaService implements IFacturaModel{
    @Autowired
    IFacturaRepository repository;

    @Override
    public List<FacturaModel> findAll() {
        return (List<FacturaModel>)repository.findAll();
    }

    @Override
    public FacturaModel findById(Integer id) {
        return (FacturaModel)repository.findById(id).get();
    }

    @Override
    public FacturaModel add(FacturaModel model) {
        return repository.save(model);
    }

    @Override
    public FacturaModel update(FacturaModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
}

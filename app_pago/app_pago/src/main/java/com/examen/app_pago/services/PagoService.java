package com.examen.app_pago.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.app_pago.model.PagoModel;
import com.examen.app_pago.repository.PagoRepository;

import jakarta.transaction.Transactional;

@Service
public class PagoService implements IPagoService{
    @Autowired
    private PagoRepository repository;
    @Override
    public List<PagoModel> findAll() {
        return (List<PagoModel>)repository.findAll();
    }

    @Override
    public PagoModel findById(Integer id) {
        return (PagoModel)repository.findById(id).get();
    }

    @Override
    public PagoModel add(PagoModel model) {
        return repository.save(model);
    }

    @Override
    @Transactional
    public PagoModel update(PagoModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
    
}

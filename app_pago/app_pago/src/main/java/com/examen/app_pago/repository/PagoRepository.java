package com.examen.app_pago.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.app_pago.model.PagoModel;

@Repository
public interface PagoRepository extends CrudRepository<PagoModel,Integer>{
    
}

package com.examen.app_factura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.app_factura.model.FacturaModel;
@Repository
public interface IFacturaRepository extends CrudRepository<FacturaModel, Integer>{
    
}

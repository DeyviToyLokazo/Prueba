package com.examen.app_movement.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.app_movement.model.MovimientoModel;
@Repository
public interface MovimientoRepository extends MongoRepository<MovimientoModel,String>{
    
}

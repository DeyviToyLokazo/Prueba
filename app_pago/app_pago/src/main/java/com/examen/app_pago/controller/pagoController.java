package com.examen.app_pago.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.app_pago.constanst.NoHardCodeo;
import com.examen.app_pago.dto.PayRequest;
import com.examen.app_pago.model.PagoModel;
import com.examen.app_pago.services.PagoService;

@RestController
@RequestMapping(NoHardCodeo.PAGO_BASE)
public class pagoController {
     @Autowired
     PagoService payService;

     Logger logger = LoggerFactory.getLogger(pagoController.class);
    @GetMapping(NoHardCodeo.GET_ALL)
    public List<PagoModel> findAll() {
        try {
            List<PagoModel> lista = payService.findAll();
            System.out.println("\n             Entrando al listado                \n");
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de pagos: {}", e.getMessage(), e);
            System.out.println("\n             retorna lista vacia                \n");
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo findAll ejecutado");
        }
    }

      @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody PayRequest request) throws Exception {

                logger.info("Post: InvoiceId {} - Ammount {}", request.getId_invoice(), request.getAmount());
                PagoModel payModel = new PagoModel();
                payModel.setIdFactura(request.getId_invoice());
                payModel.setMonto(request.getAmount());

                //payModel.setId(request.getId_invoice());
                //payModel.setAmount(request.getAmount());
                payModel = payService.add(payModel);
                logger.info("transactionModel {}", payModel);
                // messageEvent.sendDepositEvent(payModel);                
                return ResponseEntity.status(HttpStatus.CREATED).body(payModel);
        }

        @PostMapping(NoHardCodeo.CREATE)
    public PagoModel create(@RequestBody PagoModel model) {
        try {
            return payService.add(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al crear el pagos: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

        @GetMapping(NoHardCodeo.GET_BY_ID)
    public PagoModel findById(@PathVariable Integer id) {
        try {
            return payService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el pagos con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public PagoModel update(@RequestBody PagoModel model) {
        try {
            return payService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el pagos: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = payService.delete(id);
            return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el usuario con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el usuario.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }

}

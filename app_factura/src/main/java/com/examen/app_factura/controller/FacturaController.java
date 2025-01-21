package com.examen.app_factura.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.app_factura.constanst.NoHardCodeo;
import com.examen.app_factura.model.FacturaModel;
import com.examen.app_factura.services.FacturaService;
@RestController
@RequestMapping(NoHardCodeo.FACTURA_BASE)
public class FacturaController {
    private static final Logger logger = LoggerFactory.getLogger(FacturaController.class);

    @Autowired
    FacturaService facturaService;

    @GetMapping(NoHardCodeo.GET_ALL)
    public List<FacturaModel> findAll() {
        try {
            List<FacturaModel> lista = facturaService.findAll();
            System.out.println("\n             Entrando al listado                \n");
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de factura: {}", e.getMessage(), e);
            System.out.println("\n             retorna lista vacia                \n");
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo findAll ejecutado");
        }
    }

    @PostMapping(NoHardCodeo.CREATE)
    public FacturaModel create(@RequestBody FacturaModel model) {
        try {
            return facturaService.add(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al crear el factura: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

    @GetMapping(NoHardCodeo.GET_BY_ID)
    public FacturaModel findById(@PathVariable Integer id) {
        try {
            return facturaService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el factura con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public FacturaModel update(@RequestBody FacturaModel model) {
        try {
            return facturaService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el factura: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = facturaService.delete(id);
            return isDeleted ? "Factura eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el factura con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el factura.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }

}

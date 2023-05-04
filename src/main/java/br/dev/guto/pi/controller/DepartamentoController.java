package br.dev.guto.pi.controller;

import br.dev.guto.pi.model.Departamento;
import br.dev.guto.pi.services.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DepartamentoController {

    @Autowired
    private IDepartamentoService iDepartamentoService;

    @GetMapping("/departments")
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return ResponseEntity.ok().body((List<Departamento>)iDepartamentoService.recuperarDepartamentos());
    }

    @PostMapping("/department")
    public ResponseEntity<Departamento> cadastrarNovoDepartamento(@RequestBody Departamento novoDepartamento) {
        return ResponseEntity.status(201).body(iDepartamentoService.cadastrarNovoDepartamento(novoDepartamento));
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        try {
            departamento.setId(id);
            Departamento d = iDepartamentoService.atualizarDepartamento(departamento);
            if (d != null) {
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.badRequest().build();
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

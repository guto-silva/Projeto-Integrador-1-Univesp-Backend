package br.dev.guto.pi.controller;

import br.dev.guto.pi.model.Processo;
import br.dev.guto.pi.services.IProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProcessoController {
    @Autowired
    private IProcessoService iProcessoService;

    @GetMapping("/documents")
    public ResponseEntity<List<Processo>> recuperarProcessos() {
        return ResponseEntity.status(200).body((List<Processo>)iProcessoService.recuperarProcessos());
    }
}

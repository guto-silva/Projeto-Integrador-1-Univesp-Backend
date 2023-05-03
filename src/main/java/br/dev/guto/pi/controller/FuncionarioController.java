package br.dev.guto.pi.controller;

import br.dev.guto.pi.dto.FuncionarioDTO;
import br.dev.guto.pi.model.Funcionario;
import br.dev.guto.pi.security.FuncionarioToken;
import br.dev.guto.pi.services.IFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")

public class FuncionarioController {

    @Autowired
    private IFuncionarioService iFuncionarioService;

    @GetMapping("/employees")
    public ResponseEntity<List<FuncionarioDTO>> recuperarFuncionarios() {
        return ResponseEntity.ok(iFuncionarioService.recuperarFuncionarios());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<FuncionarioDTO> recuperarFuncionarioPorId(@PathVariable Long id) {
        if(iFuncionarioService.recuperarFuncionarioPorId(id) != null)
            return ResponseEntity.status(200).body(iFuncionarioService.recuperarFuncionarioPorId(id));

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/employee")
    public ResponseEntity<Funcionario> cadastrarNovoFuncionario(@RequestBody Funcionario novoFuncionario) {
        if(novoFuncionario != null) {
            return ResponseEntity.status(201).body(iFuncionarioService.cadastrarNovoFuncionario(novoFuncionario));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<FuncionarioToken> efetuarLogin(@RequestBody Funcionario dadosLogin) {
        System.out.println(dadosLogin);
        FuncionarioToken token = iFuncionarioService.realizarLogin(dadosLogin);
        if(token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }

    @PutMapping("/employee/edit/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        try {
            System.out.println(funcionario);
            funcionario.setId(id);
            Funcionario f = iFuncionarioService.atualizarFuncionario(funcionario);
            if(f != null)
                return ResponseEntity.status(200).build();

            return ResponseEntity.badRequest().build();
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
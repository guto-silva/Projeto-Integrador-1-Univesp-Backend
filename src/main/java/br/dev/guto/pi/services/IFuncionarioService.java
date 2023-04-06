package br.dev.guto.pi.services;

import br.dev.guto.pi.dto.FuncionarioDTO;
import br.dev.guto.pi.model.Funcionario;

import java.util.List;


public interface IFuncionarioService {

    public List<Funcionario> recuperarFuncionarios();
    public FuncionarioDTO recuperarFuncionarioPorId(Long id);

}

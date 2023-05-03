package br.dev.guto.pi.services;

import br.dev.guto.pi.dto.FuncionarioDTO;
import br.dev.guto.pi.model.Funcionario;
import br.dev.guto.pi.security.FuncionarioToken;

import java.util.List;


public interface IFuncionarioService {

    public List<FuncionarioDTO> recuperarFuncionarios();
    public FuncionarioDTO recuperarFuncionarioPorId(Long id);
    public Funcionario cadastrarNovoFuncionario(Funcionario novoFuncionario);

    public Funcionario atualizarFuncionario(Funcionario funcionario);
    public FuncionarioToken realizarLogin(Funcionario funcionario);

}

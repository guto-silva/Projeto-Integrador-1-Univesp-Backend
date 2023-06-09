package br.dev.guto.pi.dto;

import br.dev.guto.pi.model.Funcionario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String funcao;

    public FuncionarioDTO(){}

    public FuncionarioDTO(Optional<Funcionario> funcionario) {
        this.id = funcionario.get().getId();
        this.matricula = funcionario.get().getMatricula();
        this.nome = funcionario.get().getNome();
        this.funcao = funcionario.get().getFuncao();
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.matricula = funcionario.getMatricula();
        this.nome = funcionario.getNome();
        this.funcao = funcionario.getFuncao();
    }

    public static List<FuncionarioDTO> converter(List<Funcionario> funcionarios) {

        List<FuncionarioDTO> dtos = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
            dtos.add(funcionarioDTO);
        }
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}

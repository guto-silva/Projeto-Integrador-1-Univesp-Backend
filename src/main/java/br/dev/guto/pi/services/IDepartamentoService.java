package br.dev.guto.pi.services;

import br.dev.guto.pi.model.Departamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDepartamentoService{
    public List<Departamento> recuperarDepartamentos();
    public Departamento cadastrarNovoDepartamento(Departamento novoDepartamento);
    public Departamento atualizarDepartamento(Departamento departamento);
}

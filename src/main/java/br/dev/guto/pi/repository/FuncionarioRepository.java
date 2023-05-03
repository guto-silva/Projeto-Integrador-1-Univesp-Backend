package br.dev.guto.pi.repository;

import br.dev.guto.pi.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    public Funcionario findByNomeUsuario(String nomeUsuario);
}

package br.dev.guto.pi.repository;

import br.dev.guto.pi.model.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
}

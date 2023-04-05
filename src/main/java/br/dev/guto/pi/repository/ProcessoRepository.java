package br.dev.guto.pi.repository;

import br.dev.guto.pi.model.Processo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends CrudRepository<Processo, Long> {
}

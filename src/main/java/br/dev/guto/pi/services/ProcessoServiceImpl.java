package br.dev.guto.pi.services;

import br.dev.guto.pi.model.Processo;
import br.dev.guto.pi.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoServiceImpl implements IProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    @Override
    public List<Processo> recuperarProcessos() {
        return (List<Processo>)processoRepository.findAll();
    }
}

package br.dev.guto.pi.services;

import br.dev.guto.pi.model.Departamento;
import br.dev.guto.pi.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> recuperarDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    @Override
    public Departamento cadastrarNovoDepartamento(Departamento novoDepartamento) {
        return departamentoRepository.save(novoDepartamento);
    }

    @Override
    public Departamento atualizarDepartamento(Departamento departamento) {
        Departamento d = departamentoRepository.findById(departamento.getId()).orElse(null);

        if(d != null) {
            d.setNome(departamento.getNome());
            d.setNumeroTramite(departamento.getNumeroTramite());
        }
        return departamentoRepository.save(d);
    }


}

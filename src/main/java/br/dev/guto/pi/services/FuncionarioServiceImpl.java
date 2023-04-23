package br.dev.guto.pi.services;

import br.dev.guto.pi.dto.FuncionarioDTO;
import br.dev.guto.pi.model.Funcionario;
import br.dev.guto.pi.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements IFuncionarioService{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioDTO> recuperarFuncionarios() {
        return FuncionarioDTO.converter((List<Funcionario>)funcionarioRepository.findAll());
    }

    @Override
    public FuncionarioDTO recuperarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            return new FuncionarioDTO(funcionario);
        }
       return null;
    }

    @Override
    public Funcionario cadastrarNovoFuncionario(Funcionario novoFuncionario) {
        return funcionarioRepository.save(novoFuncionario);
    }
}

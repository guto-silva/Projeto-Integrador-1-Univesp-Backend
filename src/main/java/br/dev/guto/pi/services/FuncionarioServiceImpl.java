package br.dev.guto.pi.services;

import br.dev.guto.pi.dto.FuncionarioDTO;
import br.dev.guto.pi.model.Funcionario;
import br.dev.guto.pi.repository.FuncionarioRepository;
import br.dev.guto.pi.security.FuncionarioToken;
import br.dev.guto.pi.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        novoFuncionario.setSenha(passwordEncoder.encode(novoFuncionario.getSenha()));
        return funcionarioRepository.save(novoFuncionario);
    }

    @Override
    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        Funcionario f = funcionarioRepository.findById(funcionario.getId()).orElse(null);

        if(f != null) {
            f.setMatricula(funcionario.getMatricula());
            f.setNome(funcionario.getNome());
            f.setFuncao(funcionario.getFuncao());
        }

        return funcionarioRepository.save(f);
    }

    @Override
    public FuncionarioToken realizarLogin(Funcionario funcionario) {

        Funcionario resultado = funcionarioRepository.findByNomeUsuario(funcionario.getNomeUsuario());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        if(resultado != null) {
            if(passwordEncoder.matches(funcionario.getSenha(), resultado.getSenha())) {
                return TokenUtil.encode(resultado) ;
            }
        }
        return null;
    }
}

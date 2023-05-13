package br.dev.guto.pi.services;

import br.dev.guto.pi.model.Processo;

import java.util.List;

public interface IProcessoService {
    public List<Processo> recuperarProcessos();
}

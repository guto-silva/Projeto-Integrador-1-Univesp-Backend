package br.dev.guto.pi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamento_id")
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "numero_tramite")
    private Integer numeroTramite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }
}

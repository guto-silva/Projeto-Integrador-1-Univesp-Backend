package br.dev.guto.pi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_processo")
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "numero_protocolo", length = 15, unique = true)
    private String numeroProtocolo;
    @Column(name = "numero_requisicao", length = 10)
    private String numeroRequisicao;

    @OneToMany(mappedBy = "principal")
    private List<Processo> apensados;

    @ManyToOne
    @JoinColumn(name = "processo_apensado")
    private Processo principal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getNumeroRequisicao() {
        return numeroRequisicao;
    }

    public void setNumeroRequisicao(String numeroRequisicao) {
        this.numeroRequisicao = numeroRequisicao;
    }

    public List<Processo> getApensados() {
        return apensados;
    }

    public void setApensados(List<Processo> apensados) {
        this.apensados = apensados;
    }

    public Processo getPrincipal() {
        return principal;
    }

    public void setPrincipal(Processo principal) {
        this.principal = principal;
    }
}

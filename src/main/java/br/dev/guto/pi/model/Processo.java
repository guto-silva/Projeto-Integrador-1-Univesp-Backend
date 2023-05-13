package br.dev.guto.pi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_processo")
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "processo_id")
    private Long id;
    @Column(name = "numero_protocolo", length = 15, unique = true)
    private String numeroProtocolo;
    @Column(name = "numero_requisicao", length = 10)
    private String numeroRequisicao;

    @Column(name = "modalidade")
    private Integer modalidade;

    @Column(name = "descricao", length = 255)
    private String descricao;



    @OneToMany(mappedBy = "principal")
    @JsonIgnoreProperties("principal")
    private List<Processo> apensados;

    @ManyToOne
    @JoinColumn(name = "processo_apensado")
    @JsonIgnoreProperties("apensados")
    private Processo principal;

    @ManyToOne
    @JoinColumn(name = "departamento_origem")
    private Departamento departamentoOrigem;

    @ManyToOne()
    @JoinColumn(name = "comprador")
    private Funcionario comprador;

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

    public Integer getModalidade() {
        return modalidade;
    }

    public void setModalidade(Integer modalidade) {
        this.modalidade = modalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Departamento getDepartamentoOrigem() {
        return departamentoOrigem;
    }

    public void setDepartamentoOrigem(Departamento departamentoOrigem) {
        this.departamentoOrigem = departamentoOrigem;
    }

    public Funcionario getComprador() {
        return comprador;
    }

    public void setComprador(Funcionario comprador) {
        this.comprador = comprador;
    }
}

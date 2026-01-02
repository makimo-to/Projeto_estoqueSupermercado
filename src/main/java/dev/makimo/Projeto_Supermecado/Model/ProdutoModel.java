package dev.makimo.Projeto_Supermecado.Model;

import dev.makimo.Projeto_Supermecado.Model.TipoProdutoEnum.ProdutoEnum;
import jakarta.persistence.*;
@Table(name = "tb_produtos")
@Entity
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Column(name = "marcaProduto")
    private String marcaProduto;
    @Column(name = "tipoProduto")
    private ProdutoEnum tipoProduto;
    @Column(name = "quantidade")
    private Long quantidade;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nomeProduto, String marcaProduto, ProdutoEnum tipoProduto, Long quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.tipoProduto = tipoProduto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public ProdutoEnum getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(ProdutoEnum tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
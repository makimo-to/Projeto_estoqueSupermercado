package dev.makimo.Projeto_Supermecado.DTO;

import dev.makimo.Projeto_Supermecado.Model.TipoProdutoEnum.ProdutoEnum;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

public class ProdutoDTO {

    private Long id;

   @NotNull(message = "nomeProduto é um campo obrigatorio")
   private String nomeProduto;

   @NotNull(message = "marcaProduto é um campo obrigatorio")
   private String marcaProduto;

   @NotNull(message = "tipoProduto é um campo obrigatorio")
   private ProdutoEnum tipoProduto;

   @NotNull(message = "quantidade é um campo obrigatorio")
   @Min(value=0,message = "a quantidade não pode ser negativa")
   private Long quantidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nomeProduto, String marcaProduto, ProdutoEnum tipoProduto, Long quantidade) {
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

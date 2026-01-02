package dev.makimo.Projeto_Supermecado.Mapper;


import dev.makimo.Projeto_Supermecado.DTO.ProdutoDTO;
import dev.makimo.Projeto_Supermecado.Model.ProdutoModel;
import jdk.jfr.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoModel map(ProdutoDTO produtoDTO){
            ProdutoModel model = new ProdutoModel();
            model.setId(produtoDTO.getId()); // Agora o nome bate!
            model.setNomeProduto(produtoDTO.getNomeProduto());
            model.setMarcaProduto(produtoDTO.getMarcaProduto());
            model.setTipoProduto(produtoDTO.getTipoProduto());
            model.setQuantidade(produtoDTO.getQuantidade());
            return model;
    }

    public ProdutoDTO map(ProdutoModel produtoModel){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produtoModel.getId());
        produtoDTO.setNomeProduto(produtoModel.getNomeProduto());
        produtoDTO.setMarcaProduto(produtoModel.getMarcaProduto());
        produtoDTO.setTipoProduto(produtoModel.getTipoProduto());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        return produtoDTO;
    }
}

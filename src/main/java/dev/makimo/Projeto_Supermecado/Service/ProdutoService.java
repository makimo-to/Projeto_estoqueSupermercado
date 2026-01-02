package dev.makimo.Projeto_Supermecado.Service;

import dev.makimo.Projeto_Supermecado.DTO.ProdutoDTO;
import dev.makimo.Projeto_Supermecado.Mapper.ProdutoMapper;
import dev.makimo.Projeto_Supermecado.Model.ProdutoModel;
import dev.makimo.Projeto_Supermecado.Repository.ProdutoRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
   final ProdutoRespository produtoRespository;
   final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRespository produtoRespository, ProdutoMapper produtoMapper) {
        this.produtoRespository = produtoRespository;
        this.produtoMapper = produtoMapper;
    }


//    GET
    public List<ProdutoDTO> procurarProduto(){
        List<ProdutoModel> listaProdutoModel = produtoRespository.findAll();
        return listaProdutoModel.stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());
    }

//    GET POR ID
    public ProdutoDTO procurarProdutoPorID(Long id){
        Optional<ProdutoModel> optionalProdutoModelID = produtoRespository.findById(id);
        return optionalProdutoModelID.map(produtoMapper::map).orElseThrow(() -> new RuntimeException("O ID: "+ id +  "do produto não encontrado"));
    }

//    Post
    public ProdutoDTO adicionarProduto(ProdutoDTO produtoDTO){
        ProdutoModel produtoAdicionado = produtoMapper.map(produtoDTO);
        produtoAdicionado = produtoRespository.save(produtoAdicionado);
        return produtoMapper.map(produtoAdicionado);
    }

//    Delete
    public void deletarProduto(Long id){
        produtoRespository.deleteById(id);
    }

//    PUT
public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) { // Recebe DTO e ID
    return produtoRespository.findById(id).map(produtoExistente -> {
        // Converte o DTO recebido para Model para poder salvar
        ProdutoModel novosDados = produtoMapper.map(produtoDTO);

        // Atualiza os dados do produto que já existe no banco
        produtoExistente.setNomeProduto(novosDados.getNomeProduto());
        produtoExistente.setMarcaProduto(novosDados.getMarcaProduto());
        produtoExistente.setTipoProduto(novosDados.getTipoProduto());
        produtoExistente.setQuantidade(novosDados.getQuantidade());

        ProdutoModel salvo = produtoRespository.save(produtoExistente);
        return produtoMapper.map(salvo);
    }).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o produto"));
}
}

package dev.makimo.Projeto_Supermecado.Controller;

import dev.makimo.Projeto_Supermecado.DTO.ProdutoDTO;
import dev.makimo.Projeto_Supermecado.Model.ProdutoModel;
import dev.makimo.Projeto_Supermecado.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //    GET
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProduto(){
        List<ProdutoDTO> lista = produtoService.procurarProduto();
        return ResponseEntity.ok(lista);
    }
//      GETByID
    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoDTO> listarProdutoPorID(@PathVariable long id){
        ProdutoDTO listarPorID = produtoService.procurarProdutoPorID(id);
        if (listarPorID != null){
            return ResponseEntity.ok(listarPorID);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
//      POST
    @PostMapping("/criar")
    public ResponseEntity<String> adicionarProduto(@Valid @RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO produtoAdicionado = produtoService.adicionarProduto(produtoDTO);
       return ResponseEntity.ok("seu produto: " +produtoAdicionado.getNomeProduto()  + ", que possui o ID: " + produtoAdicionado.getId() + " foi criado com sucesso");

    }

//    DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletandoProduto(@PathVariable Long id){
        if (produtoService.procurarProdutoPorID(id) != null){
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("o produto do ID: " + id + " foi deletado com sucesso");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

//    PUT
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id,@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO Produto = produtoService.atualizarProduto(id,produtoDTO);
        if (produtoService.procurarProdutoPorID(id) != null){
            return ResponseEntity.ok("Produto atualizado com sucesso");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @RestControllerAdvice
    public class ErroHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex) {
            var erros = ex.getFieldErrors().stream()
                    .map(DadosErroValidacao::new)
                    .toList();
            return ResponseEntity.badRequest().body(erros);
        }

        private record DadosErroValidacao(String campo, String mensagem) {
            public DadosErroValidacao(FieldError erro) {
                this(erro.getField(), erro.getDefaultMessage());
            }
        }
    }

}

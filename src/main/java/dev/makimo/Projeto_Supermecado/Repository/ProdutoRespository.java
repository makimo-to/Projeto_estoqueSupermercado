package dev.makimo.Projeto_Supermecado.Repository;

import dev.makimo.Projeto_Supermecado.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRespository extends JpaRepository<ProdutoModel,Long> {
}

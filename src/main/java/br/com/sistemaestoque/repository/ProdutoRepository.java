package br.com.sistemaestoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sistemaestoque.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT a FROM Produto a WHERE a.categoria = 'INFORMATICA' ")
    public List<Produto> findByCategoriaInformatica();

    @Query("SELECT i FROM Produto i WHERE i.categoria = 'ELETRODOMESTICOS' ")
    public List<Produto> findByCategoriaEletrodomestico();
    
    @Query("SELECT i FROM Produto i WHERE i.categoria = 'BRINQUEDOS' ")
    public List<Produto> findByCategoriaBrinquedo();

    public List<Produto> findByNomeContainingIgnoreCase(String nome);
    
    public List<Produto> findByCategoria(String categoria);

}

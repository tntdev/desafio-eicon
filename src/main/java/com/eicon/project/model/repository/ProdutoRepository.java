package com.eicon.project.model.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eicon.project.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{


	@Transactional
	public Produto findByNumeroControle( @Param("numeroControle") Long numeroControle);
	
	@Transactional
	public boolean  existsByNumeroControle( @Param("numeroControle") Long numeroControle);
	
	@Query("SELECT p FROM Produto p"
			+ " WHERE 1=1"
			+ " AND (p.numeroControle = :numeroControle or :numeroControle is null )"
			+ " AND (p.dataCadastro   = :dataCadastro 	or cast(:dataCadastro as timestamp) is null )"
			+ " AND (p.codigoCliente  = :codigoCliente 	or :codigoCliente is null )")
	public List<Produto> recuperaProdutoPorParametros(@Param("numeroControle") Long numeroControle, 
													@Param("dataCadastro") LocalDate dataCadastro, 
													@Param("codigoCliente") Integer codigoCliente);
	
}

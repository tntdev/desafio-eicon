package com.eicon.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eicon.project.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	

	@Transactional
	public Produto findByNomeProduto( @Param("nomeProduto") String nomeProduto);

}

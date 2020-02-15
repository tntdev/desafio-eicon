package com.eicon.project.model.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eicon.project.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{


	@Transactional
	public Produto findByNumeroControle( @Param("numeroControle") Long numeroControle);
}

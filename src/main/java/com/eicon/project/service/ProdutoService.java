package com.eicon.project.service;

import com.eicon.project.model.entity.Produto;

public interface ProdutoService {
	
	public Produto salvarProduto(Produto produto);

	public Produto recuperaProduto(Long numeroControle);
	

}

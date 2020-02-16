package com.eicon.project.service;

import java.time.LocalDate;
import java.util.List;

import com.eicon.project.model.entity.Produto;

public interface ProdutoService {
	
	public Produto salvarProduto(Produto produto);

	public Produto recuperaProduto(Long numeroControle);
	
	public List<Produto> recuperaProduto(Long numeroControle, LocalDate dataCadastro, Integer codigoCliente, Boolean todos);
	
	public boolean isProdutoExistente(Long numeroControle);

}

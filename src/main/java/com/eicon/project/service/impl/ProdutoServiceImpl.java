package com.eicon.project.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eicon.project.model.entity.Produto;
import com.eicon.project.model.repository.ProdutoRepository;
import com.eicon.project.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
		
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto recuperaProduto(Long numeroControle) {
		
		Produto retorno = produtoRepository.findByNumeroControle(numeroControle);
		
		return retorno;
	}
	
	@Override
	public Produto salvarProduto(Produto produto){

		try {
			
			if(produto.getQuantidadeProduto() == null)
				produto.setQuantidadeProduto(Produto.QTD_DEFAULT);
			else
				produto.setQuantidadeProduto(produto.getQuantidadeProduto());
					
			if(produto.getValorProduto() == null)
				produto.setValorProduto(0.0);
			else
				produto.setValorProduto(produto.getValorProduto());
			
			double valorTotal = calculaValorTotal(produto);
			
			produto.setValorTotal(valorTotal);
			
			produto.setNumeroControle(produto.getNumeroControle());
			produto.setDataCadastro(produto.getDataCadastro() == null ? LocalDate.now() : produto.getDataCadastro()); 
			produto.setNomeProduto(produto.getNomeProduto());
			produto.setCodigoCliente(produto.getCodigoCliente());
			
			produto = produtoRepository.saveAndFlush(produto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return produto;
		
	}
	
	public double calculaValorTotal(Produto produto) {
		
		//Calcula valor total baseado na quantidade
		double valorTotal = produto.getQuantidadeProduto() * produto.getValorProduto() ;
		if(produto.getQuantidadeProduto() > 5 && produto.getQuantidadeProduto() < 10 ) {
			valorTotal = produto.getQuantidadeProduto() * produto.getValorProduto();
			double desconto = valorTotal*(5D/100);
			valorTotal = valorTotal - desconto;
			
		}else if(produto.getQuantidadeProduto() >= 10) {
			valorTotal = produto.getQuantidadeProduto() * produto.getValorProduto();
			double desconto = valorTotal*(10D/100);
			valorTotal = valorTotal - desconto;
		}
		return valorTotal;
	}
	
	@Override
	public List<Produto> recuperaProduto(Long numeroControle, LocalDate dataCadastro, Integer codigoCliente, Boolean todos) {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		if(todos)
			produtos = produtoRepository.findAll();
		else
			if(numeroControle != null || dataCadastro != null || codigoCliente != null)
				produtos = produtoRepository.recuperaProdutoPorParametros(numeroControle, dataCadastro, codigoCliente);
		
		return produtos;
	
	}
	
	
	@Override
	public boolean isProdutoExistente(Long numeroControle) {
		return produtoRepository.existsByNumeroControle(numeroControle);				
	}

}

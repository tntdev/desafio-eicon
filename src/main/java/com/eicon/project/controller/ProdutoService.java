package com.eicon.project.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eicon.project.model.Produto;
import com.eicon.project.repository.ProdutoRepository;
import com.eicon.validation.MaxSizeConstraint;

@RestController
@RequestMapping(path ="/service/produto",
				produces = {MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE }   )
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final String QTD_DEFAULT = "1";
	
	@GetMapping("/{numeroControle}")
	public Produto obterProduto(@PathVariable Long numeroControle) {
		System.out.println(String.format("Id recebido : %d", numeroControle) );
		
		
		
		
		Produto produto = new Produto();
		produto.setNumeroControle(numeroControle);
		produto.setNomeProduto("Produto01");
		produto.setDataCadastro(new Date());
		
		return produto;
	}

	/*@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE } )
	@ResponseStatus(HttpStatus.CREATED)
	public Produto cadastraProduto(@RequestParam("numeroControle") Long numeroControle, 
									@RequestParam(value="dataCadastro", required = false) Date dataCadastro, 
									@RequestParam("nomeProduto") String nomeProduto,
									@RequestParam("valorProduto") Float valorProduto,
									@RequestParam(value="quantidadeProduto", defaultValue = QTD_DEFAULT) Integer quantidadeProduto,
									@RequestParam("codigoCliente") Integer codigoCliente ) {
		
		Produto produto = new Produto();
		produto.setNumeroControle(numeroControle);
		produto.setDataCadastro(dataCadastro == null ? new Date() : dataCadastro);
		produto.setNomeProduto(nomeProduto);
		produto.setValorProduto(valorProduto);
		produto.setQuantidadeProduto(quantidadeProduto);
		produto.setCodigoCliente(codigoCliente);
		
		produtoRepository.saveAndFlush(produto);
		
		return produto;
	}*/

	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, 
							 MediaType.APPLICATION_JSON_VALUE } )
	@ResponseStatus(HttpStatus.CREATED)
	public Produto cadastraProdutos(@RequestBody
									@NotEmpty(message = "A lista de produtos não pode ser vazia.")
									@MaxSizeConstraint List<@Valid Produto> produtos ) {
		
		if(produtos.isEmpty() )
			return null;
		
		
		Produto produto = new Produto();

		return produto;
	}
	 

}

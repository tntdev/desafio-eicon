package com.eicon.project.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eicon.project.model.entity.Produto;
import com.eicon.project.service.ProdutoService;
import com.eicon.validation.MaxSizeConstraint;

@RestController
@RequestMapping(path ="/service/produtos",
				produces = {MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE }   )
public class ProdutoController {
	
	
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping("{numeroControle}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> obterProduto(@PathVariable Long numeroControle) {
		System.out.println(String.format("Id recebido : %d", numeroControle) );
		try {
			
			Produto produto = service.recuperaProduto(numeroControle);
			if(produto != null )
				return ResponseEntity.status(HttpStatus.OK).body(produto);
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
						
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, 
							 MediaType.APPLICATION_JSON_VALUE } )
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> cadastraProdutos(@RequestBody
									@NotEmpty(message = "A lista de produtos não pode ser vazia.")
									@MaxSizeConstraint List<@Valid Produto> produtos ) {
		
		produtos.forEach( x -> x = service.salvarProduto(x) );
			
		return produtos;
	}
	
	
	
	

}

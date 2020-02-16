package com.eicon.project.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eicon.project.model.entity.Produto;
import com.eicon.project.service.ProdutoService;
import com.eicon.validation.constraint.MaxSizeConstraint;
import com.eicon.validation.constraint.MinSizeConstraint;
import com.eicon.validation.exception.DuplicateNumeroControleException;


@Validated 
@RestController
@RequestMapping(path ="/service/produtos",
				produces = {MediaType.APPLICATION_XML_VALUE, 
							MediaType.APPLICATION_JSON_VALUE }   )
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Produto> > obterProduto(
		   @RequestParam(name="numeroControle" 	, required = false) Long numeroControle,
		   @RequestParam(name="dataCadastro"	, required = false) @DateTimeFormat(pattern="dd/MM/yyyy") LocalDate dataCadastro,
		   @RequestParam(name="codigoCliente"	, required = false) Integer codigoCliente,
		   @RequestParam(name="todos"			, defaultValue = "false") Boolean todos ) {
 
		try {
			List<Produto> produtos = service.recuperaProduto(numeroControle, dataCadastro, codigoCliente, todos);
			if(produtos != null && !produtos.isEmpty() )
				return ResponseEntity.status(HttpStatus.OK).body(produtos);
			else
				throw new NoSuchElementException();
						
		} catch (Exception e) {
			if(e instanceof NoSuchElementException ) 
				throw new NoSuchElementException();
			
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, 
							 MediaType.APPLICATION_JSON_VALUE } )
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Produto> > cadastraProdutos(@RequestBody
														   @NotEmpty(message = "A lista de produtos não pode ser vazia.")
														   @MaxSizeConstraint 
														   @MinSizeConstraint
														   List<@Valid Produto> produtos ) {
		try {
			verificaProdutosCadastrados(produtos);
			
			produtos.forEach( x -> x = service.salvarProduto(x) );
			
		} catch (Exception e) {
			if(e instanceof DuplicateNumeroControleException)
				throw new DuplicateNumeroControleException();
				
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	public void verificaProdutosCadastrados(List<Produto> produtos){
		List<Long> listNumeroControle = produtos.stream().map(x -> x.getNumeroControle()).collect(Collectors.toList() );
		
		if(listNumeroControle != null && !listNumeroControle.isEmpty()) 
			for (Long numControle : listNumeroControle) 
				if(service.isProdutoExistente( numControle)  )
					throw new DuplicateNumeroControleException();
		
	}
	
}

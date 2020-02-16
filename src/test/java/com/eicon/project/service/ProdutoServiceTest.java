package com.eicon.project.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.eicon.project.model.entity.Produto;
import com.eicon.project.model.repository.ProdutoRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ProdutoServiceTest {

	public static final String PRODUTO_API = "/service/produtos";
	
	ProdutoService service;
	
	@MockBean
	ProdutoRepository produtoRepository;
	
	@Test
	@DisplayName("Deve salvar um produto.")
	public void salvaProdutoTest() throws Exception {
		
		Produto produto = newProduto();
		
		Mockito.when(produtoRepository.save(produto) ).thenReturn(produto); 
		
		Produto produtoSalvo = service.salvarProduto(produto);
		
		assertThat(produtoSalvo).isNotNull();
		assertThat(produtoSalvo.getIdProduto()).isNotNull();
		assertThat(produtoSalvo.getNumeroControle()).isNotNull();
		assertThat(produtoSalvo.getDataCadastro()).isNotNull();
		assertThat(produtoSalvo.getNomeProduto()).isNotNull().isNotEmpty();
		assertThat(produtoSalvo.getValorProduto()).isNotNull();
		assertThat(produtoSalvo.getValorTotal()).isNotNull();
		assertThat(produtoSalvo.getQuantidadeProduto()).isNotNull();
		assertThat(produtoSalvo.getCodigoCliente()).isNotNull();
			
		
	}
	
	
	public Produto newProduto() {
		Produto produto = new Produto();
		
		produto.setCodigoCliente(132);
		produto.setNomeProduto("ProdutoTeste");
		produto.setNumeroControle(6575252L);
		produto.setQuantidadeProduto(3);
		//produto.setValorProduto(12.5);
		
		
		return produto;
		
	}
	

}

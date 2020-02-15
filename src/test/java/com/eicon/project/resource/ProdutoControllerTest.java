package com.eicon.project.resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eicon.project.model.entity.Produto;
import com.eicon.project.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {
	
	public static final String PRODUTO_API = "/service/produtos";
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	ProdutoService service;
	
	
	@Test
	@DisplayName("Deve cadastrar um produto com sucesso.")
	public void cadastraProdutosTest() throws Exception {
		
		Produto produto = new Produto();
		
		BDDMockito.given(service.salvarProduto(Mockito.any(Produto.class) ) ).willReturn(null);
		
		
		String jsonObject = new ObjectMapper().writeValueAsString("");
		
		
		
		
		
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(PRODUTO_API)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_XML_VALUE)
				.content(jsonObject);
		
		mvc.perform(request)
			.andExpect(status().isCreated())
			.andExpect(jsonPath("idProduto").isNotEmpty() )
			.andExpect(jsonPath("numeroControle").value(produto.getNumeroControle()) ) 
			.andExpect(jsonPath("idProduto").isNotEmpty() );
		
		
		
	}
	
	@Test
	@DisplayName("Deve gerar erro ao criar produto invalido.")
	public void cadastraProdutosInvalidoTest() throws Exception {
		
		
	}
	
	

}

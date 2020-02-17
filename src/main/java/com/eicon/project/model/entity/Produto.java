package com.eicon.project.model.entity;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

@Table( name = Produto.TABLE_NAME, schema = "public" )
@Entity
public class Produto {
	
	public static final String TABLE_NAME = "tb_produto";	
	public static final int QTD_DEFAULT = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_id_produto")
	@SequenceGenerator(name = "gen_id_produto", sequenceName = "sq_tb_produto", initialValue = 1, allocationSize = 1)
	private Long idProduto;
	
	@NotNull(message = "Favor informar o número de controle do produto.")
	private Long numeroControle;
	
	@Convert(converter = LocalDateConverter.class)
	private LocalDate dataCadastro;
	
	@NotEmpty(message = "Favor informar o nome do produto.")
	private String nomeProduto;
	
	@NotNull(message = "Favor informar o valor do produto.")
	private Double valorProduto;
	
	private Double valorTotal;
	
	private Integer quantidadeProduto;
	
	@NotNull(message = "Favor informar o código do cliente.")
	private Integer codigoCliente;


	//Getters and setters methods
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	public Long getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Long numeroControle) {
		this.numeroControle = numeroControle;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
}

package com.algaworks.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.brewer.validation.SKU;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	//([a-zA-Z]{2}\\d{4})?
	//[a-zA-Z]{2} representa qualquer letra maiúscula ou minúscula de a ate z, limitado a duas letras
	//\\d{4} representa 4(quatro) números após as 2(duas) letras.
	//? esse caractere permite somente validar se for preenchido o campo
	//@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?", message = "SKU deve seguir o padrão XX9999")
	//@SKU - Aula 10.2
	@SKU
	@NotBlank(message = "O SKU é obrigatório")
	private String sku;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo descrição não pode estar em branco")
	@Size(min = 3, max = 50, message = "O tamanho da descrição deve estar entre 3 e 50")
	private String descricao;
	
	@NotNull(message = "O valor é obrigatório")
	//@DecimalMin(value = "0.50", message = "O valor mínimo deve ser de R$0,50")
	@DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser menor que R$9.999.999,99")
	private BigDecimal valor;
	
	@NotNull(message = "O teor alcoolico é obrigatório")
	@DecimalMax(value = "100.0", message = "O teor alcóolico de ver ser menor ou igual 100%")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;
	
	@NotNull(message = "O valor de comissão é obrigatório")
	@DecimalMax(value = "100.0", message = "O valor comissão deve ser igual ou menor que 100%")
	private BigDecimal comissao;
	
	@NotNull(message = "O valor da quantidade em estoque é obrigatória")
	@Max(value = 9999, message = "A quantidade em estoque deve ser menor que 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	
	@NotNull(message = "A origem é obrigatória")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message = "O sabor é obrigatório")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull(message = "O estilo é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}
	
	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
	
	public BigDecimal getComissao() {
		return comissao;
	}
	
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public Origem getOrigem() {
		return origem;
	}
	
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	
	public Sabor getSabor() {
		return sabor;
	}
	
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	
	public Estilo getEstilo() {
		return estilo;
	}
	
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
}

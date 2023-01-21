package br.com.sistemaestoque.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sistemaestoque.enums.Categoria;
import br.com.sistemaestoque.enums.Status;
import br.com.sistemaestoque.validation.SKU;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @SKU
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

    @Column(name = "nome")
    @Size(min = 5, max = 35, message = "O nome deve conter entre 5 a 15 caracteres")
    @NotBlank(message = "O nome não pode ser vazio")
    @NotNull
    private String nome;
    
    @Column(name = "descricao")
    @Size(min = 5, max = 100, message = "A descrição deve conter entre 5 a 50 caracteres")
    @NotBlank(message = "A descrição não pode ser vazia")
    @NotNull
    private String descricao;
    
    @NotNull
	@DecimalMax(value = "9999999.99", message="O valor não deve ser maior que R$ 9.999.999, 99" )
	@DecimalMin(value = "0.01", message="O valor não deve ser menor que R$ 0,01")
	private BigDecimal valor;
    
    @NotNull(message="Quantidade em estoque é obrigatória")
	@Max(value = 9999, message="O valor em estoque não pode ser maior que 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
    
    @NotNull(message = "A categoria é obrigatória")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;  

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		sku = sku.toUpperCase();
	}

   
}

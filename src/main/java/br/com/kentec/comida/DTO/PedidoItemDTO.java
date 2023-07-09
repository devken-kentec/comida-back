package br.com.kentec.comida.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import br.com.kentec.comida.domain.PedidoItem;

public class PedidoItemDTO {
	private Long id;
    private String statusPedidoItem;
    private Integer quantidade;
    private String descricao;
    private String itens;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;
    //pedido
    private Long idPedido;
    private String statusPedido;
    private String tipoPagamento;
    private String statusPagamento;
    private String retiradaProduto;
    private BigDecimal valorPedido;
    private BigDecimal valorBebida;
    private BigDecimal taxaEntraga;
    private BigDecimal descontos;
    private LocalDate dataPedido;
    private LocalDateTime dataEntrega;
    private String foto;    
    //usuario    
    private Long idUsuario;
    private String statusUsuario;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String complemento;
    private String email;        
    private String cep;
    private String telefone;
    private String role;
   
   public PedidoItemDTO() {
    	
   }
     
   public PedidoItemDTO(PedidoItem pi) {
	   //Dados Pedido
	   this.idPedido = pi.getPedido().getId();
	   this.statusPedido = pi.getPedido().getStatus();
	   this.tipoPagamento = pi.getPedido().getTipoPagamento();
	   this.statusPagamento = pi.getPedido().getStatusPagamento();
	   this.retiradaProduto = pi.getPedido().getRetiradaProduto();
	   this.valorPedido = pi.getPedido().getValorPedido();
	   this.valorBebida = pi.getPedido().getValorBebida();
	   this.taxaEntraga = pi.getPedido().getTaxaEntraga();
	   this.descontos = pi.getPedido().getDescontos();
	   this.dataPedido = pi.getPedido().getDataPedido();
	   this.dataEntrega = pi.getPedido().getDataEntrega();
	   //DetalhamentoPedido
	   this.id = pi.getId();
	   this.statusPedidoItem = pi.getStatus();
	   this.quantidade = pi.getQuantidade();
	   this.descricao = pi.getDescricao();
	   this.itens = pi.getItens();
	   this.precoUnitario = pi.getPrecoUnitario();
	   this.precoTotal = pi.getPrecoTotal();
	   this.observacao = pi.getObservacao();
	   //Dados Usuarios
	   this.idUsuario = pi.getPedido().getUsuario().getId();
	   this.statusUsuario = pi.getPedido().getUsuario().getStatus();
	   this.nome = pi.getPedido().getUsuario().getNome();
	   this.sobrenome = pi.getPedido().getUsuario().getSobrenome();
	   this.endereco = pi.getPedido().getUsuario().getEndereco();
	   this.complemento = pi.getPedido().getUsuario().getComplemento();
	   this.email = pi.getPedido().getUsuario().getEmail();        
	   this.cep = pi.getPedido().getUsuario().getCep();
	   this.telefone = pi.getPedido().getUsuario().getTelefone();
	   this.role = pi.getPedido().getUsuario().getRole();
   }
   
 

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatusPedidoItem() {
		return statusPedidoItem;
	}
	
	public void setStatusPedidoItem(String statusPedidoItem) {
		this.statusPedidoItem = statusPedidoItem;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getItens() {
		return itens;
	}
	
	public void setItens(String itens) {
		this.itens = itens;
	}
	
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}
	
	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getStatusPedido() {
		return statusPedido;
	}
	
	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public String getStatusPagamento() {
		return statusPagamento;
	}
	
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	public String getRetiradaProduto() {
		return retiradaProduto;
	}
	
	public void setRetiradaProduto(String retiradaProduto) {
		this.retiradaProduto = retiradaProduto;
	}
	
	public BigDecimal getValorPedido() {
		return valorPedido;
	}
	
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	public BigDecimal getValorBebida() {
		return valorBebida;
	}

	public void setValorBebida(BigDecimal valorBebida) {
		this.valorBebida = valorBebida;
	}

	public BigDecimal getTaxaEntraga() {
		return taxaEntraga;
	}
	
	public void setTaxaEntraga(BigDecimal taxaEntraga) {
		this.taxaEntraga = taxaEntraga;
	}
	
	public BigDecimal getDescontos() {
		return descontos;
	}
	
	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getStatusUsuario() {
		return statusUsuario;
	}
	
	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "PedidoItemDTO [id=" + id + ", statusPedidoItem=" + statusPedidoItem + ", quantidade=" + quantidade
				+ ", descricao=" + descricao + ", itens=" + itens + ", precoUnitario=" + precoUnitario + ", precoTotal="
				+ precoTotal + ", observacao=" + observacao + ", idPedido=" + idPedido + ", statusPedido="
				+ statusPedido + ", tipoPagamento=" + tipoPagamento + ", statusPagamento=" + statusPagamento
				+ ", retiradaProduto=" + retiradaProduto + ", valorPedido=" + valorPedido + ", valorBebida="
				+ valorBebida + ", taxaEntraga=" + taxaEntraga + ", descontos=" + descontos + ", dataPedido="
				+ dataPedido + ", dataEntrega=" + dataEntrega + ", foto=" + foto + ", idUsuario=" + idUsuario
				+ ", statusUsuario=" + statusUsuario + ", nome=" + nome + ", sobrenome=" + sobrenome + ", endereco="
				+ endereco + ", complemento=" + complemento + ", email=" + email + ", cep=" + cep + ", telefone="
				+ telefone + ", role=" + role + "]";
	}
}

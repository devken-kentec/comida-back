package br.com.kentec.comida.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@SuppressWarnings("serial")
public class Usuario extends Identificador {
	
	@Column(name="nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name="sobrenome", nullable = true, length = 50)
	private String sobrenome;
	
	@Column(name="endereco", nullable = true, length = 200) 
	private String endereco;
	
	@Column(name="complemento", nullable = true, length = 100) 
	private String complemento;
	
	@Column(name="email", nullable = true, length = 250) 
	private String email;
	
	@Column(name="cep", nullable = true, length = 9)
	private String cep;
	
	@Column(name="telefone", nullable = true, length = 12)
	private String telefone;
	
	@Column(name="role", nullable = false, length = 20)
	private String role;
	
	@Column(name="senha", unique=true, nullable = true, length = 10)
	private String senha;
	
	public Usuario() {
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", endereco=" + endereco + ", complemento="
				+ complemento + ", email=" + email + ", cep=" + cep + ", telefone=" + telefone + ", role=" + role
				+ ", senha=" + senha + "]";
	}
} 

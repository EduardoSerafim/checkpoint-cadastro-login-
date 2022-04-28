package br.com.atividadecheckpoint.CadastroeLogin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class UsuarioDto {
	
	private long id;
	
	private String nomeCompleto;
	
	@NotBlank
	@NotNull
	private String nomeUsuario;
	
	@NotBlank
	@NotNull
	private String senha;
	
	UsuarioDto(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getnomeUsuario() {
		return nomeUsuario;
	}

	public void setnomeUsuario(String nomeusuario) {
		nomeUsuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
}

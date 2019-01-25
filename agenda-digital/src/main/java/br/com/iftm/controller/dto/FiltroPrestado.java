package br.com.iftm.controller.dto;

// filtra nome, cidade, estado
import java.util.Set;

import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.TipoServico;
import br.com.iftm.entily.enums.Estado;

public class FiltroPrestado {

	private String nome;

	private Estado estado;

	private Cidade cidade;

	private Set<TipoServico> tipoServicos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<TipoServico> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(Set<TipoServico> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

}

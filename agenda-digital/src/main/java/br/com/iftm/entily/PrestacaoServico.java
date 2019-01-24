package br.com.iftm.entily;

import java.sql.Date;

public class PrestacaoServico {

	private Integer codigo;
	private Date data;
	private PrestadorServico prestador;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	// private List<PrestadorServico> prestadores;

}

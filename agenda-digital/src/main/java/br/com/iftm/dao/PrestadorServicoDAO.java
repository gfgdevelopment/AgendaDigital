package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico prestadorServ);

	List<PrestadorServico> read();

	List<PrestadorServico> readByName(String nome);

	List<PrestadorServico> readByCidade(Cidade cidade);

	PrestadorServico update(PrestadorServico prestadorServ);

	void delete(Integer id);

}

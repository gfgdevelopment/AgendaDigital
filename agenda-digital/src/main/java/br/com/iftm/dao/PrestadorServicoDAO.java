package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestado;
import br.com.iftm.entily.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico prestadorServ);

	List<PrestadorServico> read();

	List<PrestadorServico> readByName(String nome);

	PrestadorServico update(PrestadorServico prestadorServ);

	void delete(Integer id);

	List<PrestadorServico> readByFiltros(FiltroPrestado filtroPrestado);

}

package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestado;
import br.com.iftm.entily.PrestadorServico;

public interface PrestadorServicoBusiness {

	/**
	 * Método responsavel por garantr os parametros obrigatórios, bem como solicitar
	 * a camada de acesso a dados que persista o objeto
	 * 
	 * @param prestadorServ
	 * @return
	 */
	PrestadorServico create(PrestadorServico prestadorServ) throws BusinessExecption;

	List<PrestadorServico> read() throws BusinessExecption;

	List<PrestadorServico> readByName(String nome) throws BusinessExecption;

	PrestadorServico update(PrestadorServico prestadorServ) throws BusinessExecption;

	void delete(Integer id) throws BusinessExecption;

	List<PrestadorServico> readByFiltros(FiltroPrestado filtroPrestado) throws BusinessExecption;;

}

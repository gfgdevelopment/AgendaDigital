package br.com.iftm.dao;

import java.util.List;
import br.com.iftm.entily.TipoServico;

public interface TipoServicoDAO {
	
	/**
	 * Método responsável por persistir o objeto {@link TipoServico} 
	 * na base de dados.
	 *  
	 * @param tipoServico (Objeto a ser persistido)
	 * @return Objeto persistido
	 */
	 TipoServico create(TipoServico tipoServico);
	 
	 /**
	  * Método responsavel por recuperar da base de dados todos os objetos
	  * {@link tipoServico}.
	  * 
	  * @return lista de {@link TipoServico}
	  */
	 List<TipoServico> read();
	 
	 /**
	  * Método para recuperar base de dados todos os objetos {@link TipoServico}, 
	  * cujo seu nome possua parte do parametro Nome.
	  * 
	  * @param nome
	  * @return Lista de {@link TipoServico}
	  */
	 List<TipoServico> readByName(String nome);
	 
	 /**
	  * Método responsavel por persisitir (atualizar) na base de dados o objeto
	  * 
	  * @param tipoServico
	  * @return Objeto a ser persistido.
	  */
	 TipoServico update(TipoServico tipoServico);
	 
	 /**
	  * Método responsavel por excluir da base de dados o objeto referente ao id informado.
	  * 
	  * @param id
	  */
	 void delete(Integer id);
	 
}

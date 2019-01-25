package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entily.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	@Autowired // chama o metodo construtor sem ter que declarar
	private SessionFactory sessionFactory; // chama função atraves da classe DAOConfig

	/*
	 * private List<TipoServico> lista = new ArrayList<>(); // salva na lista
	 * private int indice = 0; Id manual
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#create(br.com.iftm.entily.TipoServico)
	 */

	@Override
	public TipoServico create(TipoServico tipoServico) {

		/*
		 * numero do codigo em sequencia tipoServico.setCodigo(indice++);
		 * 
		 * // envia para a lista lista.add(tipoServico);
		 */

		// salva no banco
		sessionFactory.getCurrentSession().save(tipoServico);
		sessionFactory.getCurrentSession().flush();

		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {

		// lista no banco
		return sessionFactory.getCurrentSession().createCriteria(TipoServico.class).list();
	}

	@Override
	public List<TipoServico> readByName(String nome) {

		/*
		 * List<TipoServico> listaRetorno = new ArrayList<>(); // verifica na lista for
		 * (TipoServico tipoServico : lista) { if
		 * (tipoServico.getNome().toUpperCase().contains(nome.toUpperCase())) {
		 * listaRetorno.add(tipoServico); } }
		 */

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase()); // adiciona restrição

		return criteria.list();
	}

	@Override
	public TipoServico update(TipoServico tipoServico) {

		/*
		 * for (TipoServico tipoServico2 : lista) { if
		 * (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
		 * tipoServico2.setNome(tipoServico.getNome()); } }
		 */

		// atualiza no banco
		sessionFactory.getCurrentSession().update(tipoServico);
		sessionFactory.getCurrentSession().flush();

		return tipoServico;
	}

	@Override
	public void delete(Integer id) {

		/*
		 * for (TipoServico tipoServico2 : lista) {
		 * 
		 * if (tipoServico2.getCodigo().equals(id)) { // remove da lista
		 * lista.remove(tipoServico2); break; } }
		 */

		// delete no banco
		TipoServico tipoServico = new TipoServico(); // Classe onde está o atributo
		tipoServico.setCodigo(id); // instancia para pegar o id e assim excluir

		sessionFactory.getCurrentSession().delete(tipoServico);
	}

}

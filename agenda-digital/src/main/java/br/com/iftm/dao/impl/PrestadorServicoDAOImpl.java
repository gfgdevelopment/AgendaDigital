package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.PrestadorServico;

//CAMADA DE DADOS

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	@Autowired // chama o metodo construtor sem ter que declarar
	private SessionFactory sessionFactory; // chama função atraves da classe DAOConfig

	/*
	 * private List<PrestadorServico> listaPrestador = new ArrayList<>(); // salva
	 * na lista private int indice = 0; //ID manual
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.PrestadorServicoDAO#create(br.com.iftm.entily.
	 * PrestadorServico)
	 */

	@Override
	public PrestadorServico create(PrestadorServico prestadorServ) {

		/*
		 * // numero do codigo em sequencia prestadorServ.setCodigo(indice++);
		 * 
		 * // envia para a lista listaPrestador.add(prestadorServ);
		 */

		// salva no banco
		sessionFactory.getCurrentSession().save(prestadorServ);
		sessionFactory.getCurrentSession().flush();
		return prestadorServ;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<PrestadorServico> read() {

		// lista no banco
		return sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class).list();
	}

	@Override
	public List<PrestadorServico> readByName(String nome) {

		/*
		 * List<PrestadorServico> listaRetorno = new ArrayList<>(); // verifica na lista
		 * for (PrestadorServico prestadorServ : listaPrestador) { if
		 * (prestadorServ.getNome().toUpperCase().contains(nome.toUpperCase())) {
		 * listaRetorno.add(prestadorServ); } }
		 */

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase()); // adiciona restrição
		return criteria.list();
	}

	@Override
	public List<PrestadorServico> readByCidade(Cidade cidade) {

		/*
		 * List<PrestadorServico> listaRetorno = new ArrayList<>(); // verifica na lista
		 * for (PrestadorServico prestadorServ : listaPrestador) { if
		 * (prestadorServ.getCidade().equals(cidade)) { listaRetorno.add(prestadorServ);
		 * } }
		 */

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		criteria.add(Restrictions.eq("cidade", cidade)); // busca por igualdade
		return criteria.list();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public PrestadorServico update(PrestadorServico prestadorServ) {

		/*
		 * for (PrestadorServico prestadorServico2 : listaPrestador) { if
		 * (prestadorServico2.getCodigo().equals(prestadorServ.getCodigo())) {
		 * prestadorServico2.setNome(prestadorServ.getNome());
		 * prestadorServico2.setBairro(prestadorServ.getBairro());
		 * prestadorServico2.setCep(prestadorServ.getCep());
		 * prestadorServico2.setCidade(prestadorServ.getCidade());
		 * prestadorServico2.setTipoLogradouro(prestadorServ.getTipoLogradouro());
		 * prestadorServico2.setLogradouro(prestadorServ.getLogradouro());
		 * prestadorServico2.setComplemento(prestadorServ.getComplemento());
		 * prestadorServico2.setNumero(prestadorServ.getNumero());
		 * prestadorServico2.setEmail(prestadorServ.getEmail());
		 * prestadorServico2.setTelefones(prestadorServ.getTelefones());
		 * prestadorServico2.setTipoServicos(prestadorServ.getTipoServicos()); } }
		 */

		// atualiza no banco
		sessionFactory.getCurrentSession().update(prestadorServ);
		sessionFactory.getCurrentSession().flush();
		return prestadorServ;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void delete(Integer id) {

		/*
		 * for (PrestadorServico prestadorServico2 : listaPrestador) {
		 * 
		 * if (prestadorServico2.getCodigo().equals(id)) { // remove da lista
		 * listaPrestador.remove(prestadorServico2); break; } }
		 */

		// deleta no banco
		PrestadorServico excluiPrestador = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);
		sessionFactory.getCurrentSession().delete(excluiPrestador);
	}

}

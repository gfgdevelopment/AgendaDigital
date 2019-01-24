package br.com.iftm.business.impl;

//CAMADA DE NEGÓCIO (com cada função)

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessExecption;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entily.TipoServico;

@Service
@Transactional // serve para que ocorra a transação do programa com o banco
public class TipoServicoBusinessImpl implements TipoServicoBusiness {

	@Autowired // procura pela classe, evita de instanciar
	private TipoServicoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public TipoServico create(TipoServico tipoServico) throws BusinessExecption {
		// validação se está preenchido ou não
		if (StringUtils.isEmpty(tipoServico.getNome())) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return dao.create(tipoServico); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(readOnly = true) // exige que faça somente leitura
	public List<TipoServico> read() {
		// chama a camada DAO (dados)
		return dao.read(); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(readOnly = true) // exige que faça somente leitura
	public List<TipoServico> readByName(String nome) throws BusinessExecption {
		// validação
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return dao.readByName(nome); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public TipoServico update(TipoServico tipoServico) throws BusinessExecption {

		if (tipoServico.getCodigo() == null) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		// validação se está preenchido ou não
		if (StringUtils.isEmpty(tipoServico.getNome())) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return dao.update(tipoServico); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public void delete(Integer id) throws BusinessExecption {

		if (id == null) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		dao.delete(id); // trata a parte de persistência (via interface)
	}

}

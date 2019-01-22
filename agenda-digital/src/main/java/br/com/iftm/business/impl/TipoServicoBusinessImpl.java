package br.com.iftm.business.impl;

//CAMADA DE NEGÓCIO (com cada função)

import java.util.List;

import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessExecption;
import br.com.iftm.business.TipoServicoBusiness;
import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.dao.impl.TipoServicoDAOImpl;
import br.com.iftm.entily.TipoServico;

public class TipoServicoBusinessImpl implements TipoServicoBusiness {

	private TipoServicoDAO dao = new TipoServicoDAOImpl();

	@Override
	public TipoServico create(TipoServico tipoServico) throws BusinessExecption {
		// validação se está preenchido ou não
		if (StringUtils.isEmpty(tipoServico.getNome())) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return dao.create(tipoServico); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<TipoServico> read() {
		// chama a camada DAO (dados)
		return dao.read(); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<TipoServico> readByName(String nome) throws BusinessExecption {
		// validação
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return dao.readByName(nome); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
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
	public void delete(Integer id) throws BusinessExecption {

		if (id == null) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		dao.delete(id); // trata a parte de persistência (via interface)
	}

}

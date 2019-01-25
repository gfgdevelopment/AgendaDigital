package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessExecption;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.controller.dto.FiltroPrestado;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entily.PrestadorServico;
import br.com.iftm.entily.Telefone;
import br.com.iftm.entily.TipoServico;

@Service
@Transactional // serve para que ocorra a transação do programa com o banco
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired // procura pela classe, evita de instanciar
	private PrestadorServicoDAO prestadorDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public PrestadorServico create(PrestadorServico prestadorServ) throws BusinessExecption {

		// validação se está preenchido ou não, dado obrigatório (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getNome())) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getCidade().getCodigo() == null) {
			throw new BusinessExecption("Cidade Requerido!"); // possui chave estrangeira
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getBairro())) {
			throw new BusinessExecption("Bairro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getLogradouro())) {
			throw new BusinessExecption("Logradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTipoLogradouro() == null) {
			throw new BusinessExecption("TipoLogradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é Int)
		if (prestadorServ.getNumero() == null) {
			throw new BusinessExecption("Numero_Endereco Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTelefones() == null || prestadorServ.getTelefones().isEmpty()) {
			throw new BusinessExecption("Pelo menos um telefone Requerido!"); // possui chave estrangeira
		}

		for (Telefone telefone : prestadorServ.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessExecption("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessExecption("Número Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServ);

		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTipoServicos() == null || prestadorServ.getTipoServicos().isEmpty()) {
			throw new BusinessExecption("Pelo menos um tipo de serviço é Requerido"); // possui chave estrangeira
		}

		for (TipoServico tipoServico : prestadorServ.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessExecption("Código Tipo Serviço Requerido!");
			}
		}

		return prestadorDao.create(prestadorServ); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(readOnly = true) // exige que faça somente leitura
	public List<PrestadorServico> read() throws BusinessExecption {
		// chama a camada DAO (dados)
		return prestadorDao.read();
	}

	@Override
	@Transactional(readOnly = true) // exige que faça somente leitura
	public List<PrestadorServico> readByName(String nome) throws BusinessExecption {

		// validação
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		return prestadorDao.readByName(nome); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public PrestadorServico update(PrestadorServico prestadorServ) throws BusinessExecption {

		if (prestadorServ.getCodigo() == null) {
			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getCidade().getCodigo() == null) {
			throw new BusinessExecption("Cidade Requerido!"); // possui chave estrangeira
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getBairro())) {
			throw new BusinessExecption("Bairro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é string)
		if (StringUtils.isEmpty(prestadorServ.getLogradouro())) {
			throw new BusinessExecption("Logradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTipoLogradouro() == null) {
			throw new BusinessExecption("TipoLogradouro Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto é Int)
		if (prestadorServ.getNumero() == null) {
			throw new BusinessExecption("Numero Requerido!"); // excessão disparada pela camada Business
		}

		// dado obrigatório, (objeto se compara com NULL)
		if (prestadorServ.getTelefones() == null || prestadorServ.getTelefones().isEmpty()) {
			throw new BusinessExecption("Pelo menos um telefone Requerido!"); // possui chave estrangeira
		}

		for (Telefone telefone : prestadorServ.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessExecption("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessExecption("Número Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServ);

		}

		if (prestadorServ.getTipoServicos() == null || prestadorServ.getTipoServicos().isEmpty()) {
			throw new BusinessExecption("Pelo menos um tipo de serviço é Requerido");
		}

		for (TipoServico tipoServico : prestadorServ.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessExecption("Código Tipo Serviço Requerido!");
			}
		}

		return prestadorDao.update(prestadorServ); // trata a parte de persistência (via interface)
	}

	////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Transactional(propagation = Propagation.REQUIRED) // exige que abre a transação e propaga para outros métodos
	public void delete(Integer id) throws BusinessExecption {

		if (id == null) {

			throw new BusinessExecption("Nome Requerido!"); // excessão disparada pela camada Business
		}
		prestadorDao.delete(id); // trata a parte de persistência (via interface)
	}

	@Override
	@Transactional(readOnly = true) // exige que faça somente leitura
	public List<PrestadorServico> readByFiltros(FiltroPrestado filtroPrestado) throws BusinessExecption {

		return prestadorDao.readByFiltros(filtroPrestado);
	}

}

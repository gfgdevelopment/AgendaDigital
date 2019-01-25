package br.com.iftm.entily;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.iftm.entily.enums.TipoLogradouro;

@Entity // persistencia
@Table(name = "TB_PRESTADOR_SERVICO")
//UniqueConstraint evita que crie mais de um dado com o mesmo valor

public class PrestadorServico {

	@Id // utilizado como chave primária
	@GeneratedValue(generator = "SQ_PREST_SERVICO", strategy = GenerationType.SEQUENCE) // geração da chave primária
	@Column(name = "CODIGO_PREST_SERVICO") // precisa dar nome pra coluna (no caso do ID)
	private Integer codigo;

	// mapeamento de atributos das classes com colunas no banco
	@Column(name = "NOME_PREST_SERVICO", nullable = false, length = 100)
	private String nome;

	// (um prestador relacionado com apenas uma cidade)
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "CODIGO_CIDADE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PRESTADOR_CIDADE"))
	private Cidade cidade;

	@Column(name = "BAIRRO_PREST_SERVICO", nullable = false, length = 80)
	private String bairro;

	@Column(name = "CEP_PREST_SERVICO", nullable = true, length = 8)
	private String cep;

	@Column(name = "TIPO_LOGRADOURO", nullable = false, length = 25)
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;

	@Column(name = "LOGRADOURO", nullable = false, length = 80)
	private String logradouro;

	@Column(name = "COMPLEMENTO", nullable = true, length = 80)
	private String complemento;

	@Column(name = "NUMERO", nullable = false)
	private Integer numero;

	@Column(name = "EMAIL_PREST_SERVICO", nullable = true, length = 150)
	private String email;

	// relação Um pra Muitos
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

	// relação Muitos pra Muitos
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	@JoinTable(name = "RL_SERVICOS_PRESTADOS", joinColumns = {
			@JoinColumn(name = "CODIGO_PREST_SERVICO") }, inverseJoinColumns = {
					@JoinColumn(name = "CODIGO_TIPOSERVICO") })
	// JoinTable UTILIZADA PARA MAPEAR UMA TABELA INTERMEDIÁRIA ENTRE OUTRAS TABELAS
	private List<TipoServico> tipoServicos;

	// ONDE FICA MANYTOONE

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<TipoServico> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(List<TipoServico> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

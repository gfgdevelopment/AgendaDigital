package br.com.iftm.entily;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity // persistencia
//define informações sobre a tabela
@Table(name = "TB_TIPOSERVICO", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_TIPO_SERVICO", columnNames = { "NOME_TIPOSERVICO" }) })
//UniqueConstraint evita que crie mais de um dado com o mesmo valor

//configuração de sequence
@SequenceGenerator(name = "SQ_TIPOSERVICO", sequenceName = "SQ_TIPOSERVICO", initialValue = 1, allocationSize = 1)
public class TipoServico {

	@Id // utilizado como chave primária
	@GeneratedValue(generator = "SQ_TIPOSERVICO", strategy = GenerationType.SEQUENCE) // geração da chave primária
	@Column(name = "CODIGO_TIPOSERVICO") // precisa dar nome pra coluna (no caso do ID)
	private Integer codigo;

	// mapeamento de atributos das classes com colunas no banco
	@Column(name = "NOME_TIPOSERVICO", nullable = false, length = 100)
	private String nome;

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

}

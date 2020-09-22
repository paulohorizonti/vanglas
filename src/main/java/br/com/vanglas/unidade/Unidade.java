/*classe que representa a tabela no banco de dados*/
package br.com.vanglas.unidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*Anotations: entity e table
 * Informa que a classe é uma entidade do banco
 * e deixa claro a qual tabela pertence
 **/
@Entity                                     
@Table (name="tbl_unidade")                 
public class Unidade implements Serializable{
	private static final long serialVersionUID = 1L;

	/*Atribuitos que representam campos na tabela de banco de dados
	 * Cada campo tera seu atributo column atribuido, deixando explicito
	 * a qual campo aquele atribuito pertence
	 * 
	 * */
	
	@Id
	@GeneratedValue
	@Column(name="uni_id")
	private Long id;
	
	@NotEmpty
	//@org.hibernate.annotations.NaturalId
	@Column(name="uni_nome", length = 80, nullable = false)
	private String nome;
	
	@NotEmpty
	@Column(name="uni_cidade", length = 50, nullable = false)
	private String cidade;
	
	@NotEmpty
	@Column(name="uni_endereco", length = 70, nullable = false)
	private String endereco;
	
	@NotEmpty
	@Column(name="uni_telefone", length = 14, nullable = false)
	private String fone;
	
	@NotEmpty
	@Column(name="uni_cordenador", length = 80, nullable = false)
	private String cordenador;
	
	
	@Column(name="uni_ativo", nullable = false)
	private boolean ativo;
	
	
	@Column(name="uni_dataCadastro", nullable = false)
	private Date dataCadastro;
	
	
	@Column(name="uni_dataAlteracao", nullable = false)
	private Date dataAlteracao;
	
	
	/*Gets e sets*/
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getFone() {
		return fone;
	}
	public String getCordenador() {
		return cordenador;
	}
	
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome == null ? null : nome.toUpperCase();
		
	}
	public void setCidade(String cidade) {
		this.cidade = cidade == null ? null : cidade.toUpperCase();;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco == null ? null : endereco.toUpperCase();;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public void setCordenador(String cordenador) {
		this.cordenador = cordenador == null ? null : cordenador.toUpperCase();;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((cordenador == null) ? 0 : cordenador.hashCode());
		result = prime * result + ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (cordenador == null) {
			if (other.cordenador != null)
				return false;
		} else if (!cordenador.equals(other.cordenador))
			return false;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}

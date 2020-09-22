package br.com.vanglas.servidor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.vanglas.unidade.Unidade;

@Entity
@Table (name="tbl_servidor")     
public class Servidor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8089118860006982617L;
	
	@Id
	@GeneratedValue
	@Column(name="ser_codigo")
	private Integer codigo;
	
	@Column(name="ser_matricula", length = 45, nullable = false)
	private String matricula;
	
	@Column(name="ser_nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name="ser_telefone", length = 14, nullable = false)
	private String telefone;
	
	@Column(name="ser_dataCad", nullable = false)
	private Date dataCad;
	
	@Column(name="ser_dataAlt", nullable = false)
	private Date dataAlt;
	
	@Column(name="ser_ativo", nullable = false)
	private boolean ativo;
	
	@Column(name="ser_cidade", length = 50, nullable = false)
	private String cidade;
	
	@Column(name="ser_uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name="ser_endereco", length = 60, nullable = false)
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id", nullable = false)
	private Unidade unidade;
	
	@Column(name="ser_senha", length = 10, nullable = false)
	private String senha;
	
	@Column(name="ser_funcao", length = 45, nullable = false)
	private String funcao;
	
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	public Date getDataAlt() {
		return dataAlt;
	}
	public void setDataAlt(Date dataAlt) {
		this.dataAlt = dataAlt;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Servidor other = (Servidor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}

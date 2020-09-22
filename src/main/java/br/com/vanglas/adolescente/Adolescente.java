package br.com.vanglas.adolescente;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name="tbl_adolescente")  
public class Adolescente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*Atributos que representam os campos dentro da tabela no banco*/
	@Id
	@GeneratedValue
	@Column(name="ado_codigo")
	private Integer codigo;
	
	@Column(name="ado_nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name="ado_apelido", length = 50, nullable = true)
	private String apelido;
	
	@Lob
	@Column(name="ado_foto", nullable = true)
	private byte[] foto;
	
	@Column(name="ado_endeRes", length = 100, nullable = true)
	private String enderecoResidencia; /*residencia*/
	
	@Column(name="ado_cidadeRes", length = 50, nullable = true)
	private String cidadeResidencia; /*Residencia*/
	
	@Column(name="ado_cepResidencia", length = 10, nullable = true)
	private String cepResidencia; /*residencia*/
	
	@Column(name="ado_ufRes", length = 2, nullable = true)
	private String ufResidencia; /*Residencia*/
	
	@Column(name="ado_cidadeNasc", length = 50, nullable = false)
	private String cidadeNascimento;
	
	@Column(name="ado_ufNasc", length = 2, nullable = false)
	private String ufNascimento;
	
	@Column(name="ado_dataNasc", nullable = false)
	private Date dataNascimento;
	
	@Column(name="ado_telefoneOutro", length = 13, nullable = true)
	private String telefoneOutro;
	
	@Column(name="ado_telefoneMae", length = 13, nullable = true)
	private String telefoneMae;
	
	@Column(name="ado_mae", length = 100, nullable = false)
	private String mae;
	
	@Column(name="ado_pai", length = 100, nullable = false)
	private String pai;
	
	@Column(name="ado_observacoes", length = 200, nullable = true)
	private String obersevacoes;
	
	@Column(name="ado_dataCad", nullable = false)
	private Date dataCad;
	
	@Column(name="ado_dataAlt", nullable = false)
	private Date dataAlt;
	
	
	
	/*Gets e sets*/
	public Integer getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getApelido() {
		return apelido;
	}
	public byte[] getFoto() {
		return foto;
	}
	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}
	public String getCidadeResidencia() {
		return cidadeResidencia;
	}
	public String getUfResidencia() {
		return ufResidencia;
	}
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}
	public String getUfNascimento() {
		return ufNascimento;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public String getMae() {
		return mae;
	}
	public String getPai() {
		return pai;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public Date getDataAlt() {
		return dataAlt;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	public void setDataAlt(Date dataAlt) {
		this.dataAlt = dataAlt;
	}
	public String getCepResidencia() {
		return cepResidencia;
	}
	public String getTelefoneOutro() {
		return telefoneOutro;
	}
	public String getTelefoneMae() {
		return telefoneMae;
	}
	public String getObersevacoes() {
		return obersevacoes;
	}
	public void setCepResidencia(String cepResidencia) {
		this.cepResidencia = cepResidencia;
	}
	public void setTelefoneOutro(String telefoneOutro) {
		this.telefoneOutro = telefoneOutro;
	}
	public void setTelefoneMae(String telefoneMae) {
		this.telefoneMae = telefoneMae;
	}
	public void setObersevacoes(String obersevacoes) {
		this.obersevacoes = obersevacoes;
	}
	public void setCidadeResidencia(String cidadeResidencia) {
		this.cidadeResidencia = cidadeResidencia;
	}
	public void setUfResidencia(String ufResidencia) {
		this.ufResidencia = ufResidencia;
	}
	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}
	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((cepResidencia == null) ? 0 : cepResidencia.hashCode());
		result = prime * result + ((cidadeNascimento == null) ? 0 : cidadeNascimento.hashCode());
		result = prime * result + ((cidadeResidencia == null) ? 0 : cidadeResidencia.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataAlt == null) ? 0 : dataAlt.hashCode());
		result = prime * result + ((dataCad == null) ? 0 : dataCad.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((enderecoResidencia == null) ? 0 : enderecoResidencia.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((obersevacoes == null) ? 0 : obersevacoes.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((telefoneMae == null) ? 0 : telefoneMae.hashCode());
		result = prime * result + ((telefoneOutro == null) ? 0 : telefoneOutro.hashCode());
		result = prime * result + ((ufNascimento == null) ? 0 : ufNascimento.hashCode());
		result = prime * result + ((ufResidencia == null) ? 0 : ufResidencia.hashCode());
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
		Adolescente other = (Adolescente) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (cepResidencia == null) {
			if (other.cepResidencia != null)
				return false;
		} else if (!cepResidencia.equals(other.cepResidencia))
			return false;
		if (cidadeNascimento == null) {
			if (other.cidadeNascimento != null)
				return false;
		} else if (!cidadeNascimento.equals(other.cidadeNascimento))
			return false;
		if (cidadeResidencia == null) {
			if (other.cidadeResidencia != null)
				return false;
		} else if (!cidadeResidencia.equals(other.cidadeResidencia))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataAlt == null) {
			if (other.dataAlt != null)
				return false;
		} else if (!dataAlt.equals(other.dataAlt))
			return false;
		if (dataCad == null) {
			if (other.dataCad != null)
				return false;
		} else if (!dataCad.equals(other.dataCad))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (enderecoResidencia == null) {
			if (other.enderecoResidencia != null)
				return false;
		} else if (!enderecoResidencia.equals(other.enderecoResidencia))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (obersevacoes == null) {
			if (other.obersevacoes != null)
				return false;
		} else if (!obersevacoes.equals(other.obersevacoes))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (telefoneMae == null) {
			if (other.telefoneMae != null)
				return false;
		} else if (!telefoneMae.equals(other.telefoneMae))
			return false;
		if (telefoneOutro == null) {
			if (other.telefoneOutro != null)
				return false;
		} else if (!telefoneOutro.equals(other.telefoneOutro))
			return false;
		if (ufNascimento == null) {
			if (other.ufNascimento != null)
				return false;
		} else if (!ufNascimento.equals(other.ufNascimento))
			return false;
		if (ufResidencia == null) {
			if (other.ufResidencia != null)
				return false;
		} else if (!ufResidencia.equals(other.ufResidencia))
			return false;
		return true;
	}

	

}

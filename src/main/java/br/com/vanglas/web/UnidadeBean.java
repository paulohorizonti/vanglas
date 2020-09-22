/*Classe que atende a camada de visualização
 * guarda os dados digitados e repassa para camada de visualização, as paginas xhtml*/
package br.com.vanglas.web;



import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.com.vanglas.unidade.Unidade;
import br.com.vanglas.unidade.UnidadeRN;
import br.com.vanglas.util.jsf.FacesUtil;



@ManagedBean(name="unidadeBean")
@RequestScoped
public class UnidadeBean {

	private Unidade unidade = new Unidade(); //instancia um objeto do tipo unidade
	private List<Unidade> lista;
	private Unidade unidadeBuscada;
	UnidadeRN unidadeRN = new UnidadeRN();
	private String destinoSalvar;

	
	
	/*Operações*/
	
	public String novo() {
		this.destinoSalvar = "unidadesucesso";
		this.unidade = new Unidade();
		this.unidade.setAtivo(true); //ativa na criação de uma nova unidade
		/*Seta a data*/
		Calendar c = Calendar.getInstance();
		this.unidade.setDataAlteracao(c.getTime());
		this.unidade.setDataCadastro(c.getTime());
		
		return "/admin/unidade";
	}
	
	public String salvar() {
		//FacesContext context = FacesContext.getCurrentInstance();
		
		
			unidadeRN.salvar(this.unidade);
			
			return this.destinoSalvar;
			
		} //fim do metodo
	
	public void salvarVoid() {
		unidadeRN.salvar(this.unidade);
		novoVoid();
		FacesUtil.addInfoMessage("Unidade salva com sucesso!");
	}	
	
	public void novoVoid() {
		this.unidade = new Unidade();
		this.unidade.setAtivo(true); //ativa na criação de uma nova unidade
		/*Seta a data*/
		Calendar c = Calendar.getInstance();
		this.unidade.setDataAlteracao(c.getTime());
		this.unidade.setDataCadastro(c.getTime());
	}
	
	
	public String ativar() {
		
			if(this.unidade.isAtivo()) 
				this.unidade.setAtivo(false);
			else 
				this.unidade.setAtivo(true);

			UnidadeRN unidadeRN = new UnidadeRN();
			unidadeRN.salvar(this.unidade);
			
			return null;
		
	}
	
	
	public String editar() {
			return "/admin/unidade";
		
	}
	
	public String excluir() {
		UnidadeRN unidadeRN = new UnidadeRN();
		unidadeRN.excluir(this.unidade);
		this.lista = null;
		return null;
	}
	
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Unidade> getLista() {
		if(this.lista == null) {
			UnidadeRN unidadeRN = new UnidadeRN();
			this.lista = unidadeRN.listar();
		}
		return this.lista;
	}

	public Unidade getUnidadeBuscada() {
		
		return unidadeBuscada;
	}
	
	public String buscarUnidade() {
		if(this.unidadeBuscada == null) {
			UnidadeRN unidadeRN = new UnidadeRN();
			this.unidadeBuscada = unidadeRN.buscarPorNome(unidade.getNome().toString());
		}
		String unidadeB = this.unidadeBuscada.getNome().toString();
		System.out.println("Buscou : "+unidadeB);
		return unidadeB;
	}

	
	public String comparar() {
				
		String nome = this.unidade.getNome().toString();
		String buscada = buscarUnidade();
		
		if(nome.equals(buscada)) {
			System.out.println("Nome: "+nome);
			System.out.println("Buscadsa : "+buscada);
		}
	 return null;
		
		
		
		
		} //fim do metodo
	
	
	
	

}

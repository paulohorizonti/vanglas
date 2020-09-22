package br.com.vanglas.web;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.vanglas.servidor.Servidor;
import br.com.vanglas.servidor.ServidorRN;
import br.com.vanglas.unidade.Unidade;
import br.com.vanglas.unidade.UnidadeRN;

@ManagedBean(name="servidorBean")
@RequestScoped
public class ServidorBean {
	private Servidor servidor = new Servidor(); //instancia um objeto do tipo servidor
	private Unidade unidade = new Unidade(); //serivirar para carregar as unidades
	private List<Unidade> lista_unidades;
	private List<Servidor> lista_servidor;
	private String destinoSalvar;
	private String confirmaSenha;
	
	/*Operações*/
	public String novo() {
		this.destinoSalvar = "servidorsucesso";
	
		this.servidor = new Servidor();
		this.servidor.setAtivo(true); //ativa na criação de uma nova unidade
	
		/*Seta a data*/
		Calendar c = Calendar.getInstance();
		this.servidor.setDataAlt(c.getTime());
		this.servidor.setDataCad(c.getTime());
		
		
		return "/admin/servidor";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.servidor.setUnidade(this.unidade);
		String senha = this.servidor.getSenha(); // pega a senha e coloca numa variavel
		if (!senha.equals(this.confirmaSenha)) { // compara a senha com a senha digitada
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);// coloca a mensagem no contexto
		}

		/*
		 * Aqui ele instancia um objeto de usuarioRN e passa o objeto dessa classe para
		 * que ele seja salvo
		 */
		ServidorRN servidorRN = new ServidorRN();
		
		servidorRN.salvar(servidor);

		return this.destinoSalvar; // agora retorna o destino salvar
	}
	
	/*Ativando o servidor*/
	public String ativar() {
		
		if(this.servidor.isAtivo()) 
			this.servidor.setAtivo(false);
		else 
			this.servidor.setAtivo(true);

		ServidorRN servidorRN = new ServidorRN();
		servidorRN.salvar(this.servidor);
		
		return null;
	
}
	
	/*Editar*/
	public String editar() {
		return "/admin/servidor";
	
}
	
	/*Excluir*/
	public String excluir() {
		ServidorRN servidorRN = new ServidorRN();
		servidorRN.excluir(this.servidor);
		this.lista_servidor = null;
		return null;
	}
	
	

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Unidade> getLista_unidades() {
		if(this.lista_unidades == null) {
			UnidadeRN unidadeRN = new UnidadeRN();
			this.lista_unidades = unidadeRN.listar();
		}
		return this.lista_unidades;
	}
	
		
	public List<Servidor> getLista_servidor() {
		if(this.lista_servidor == null) { //verifica se a lista esta vazia
			ServidorRN servidorRN = new ServidorRN(); //instancia uma nova classe de regra de negocio
			this.lista_servidor = servidorRN.listar(); //chama o metodo do objeto e atribui à propriedade local
		}
	
		
		return this.lista_servidor; //retorna a lista
	}

	public void setLista_servidor(List<Servidor> lista_servidor) {
		this.lista_servidor = lista_servidor;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}


}

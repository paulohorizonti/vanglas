package  br.com.vanglas.web;




import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

import br.com.vanglas.adolescente.Adolescente;
import br.com.vanglas.adolescente.AdolescenteRN;


@ManagedBean(name="adolescenteBean")
@RequestScoped
public class AdolescenteBean {
	
	private Adolescente adolescente = new Adolescente(); //instancia um objeto do tipo adolescente
	private List<Adolescente> lista;
	private String destinoSalvar;
	private UploadedFile foto;
	
	
	private String imagemSelecionada;
	
	public String getImagemSelecionada() {
		return imagemSelecionada;
	}


	public void setImagemSelecionada(String imagemSelecionada) {
		this.imagemSelecionada = imagemSelecionada;
	}


	
		
	/*Operações CRUD*/
			
	public String novo() {
		this.destinoSalvar = "adolescentesucesso";
	
		this.adolescente = new Adolescente();
			
		/*Seta a data*/
		Calendar c = Calendar.getInstance();
		this.adolescente.setDataCad(c.getTime());
		this.adolescente.setDataAlt(c.getTime());
		
		
		return "/admin/adolescente";
	}
	
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		/*
		 * Aqui ele instancia um objeto de usuarioRN e passa o objeto dessa classe para
		 * que ele seja salvo
		 */
	try {
			 AdolescenteRN adolescenteRN = new AdolescenteRN();
						 
			 if(foto !=null) {
				 adolescente.setFoto(foto.getContents());
			 }
			 
			 adolescenteRN.salvar(adolescente);
			 this.foto = null;
			 return this.destinoSalvar; // agora retorna o destino salvar
			
			 
			 
			 }catch(Exception e) {
				 e.printStackTrace();
				 
				 FacesMessage facesMessage = new FacesMessage("Não deu certo a foto: "+e.getMessage());
					context.addMessage(null, facesMessage);// coloca a mensagem no contexto
				   
			
		}
				
	return null;
		
	}
	
	
	/*Editar*/
	public String editar() {
		return "/admin/adolescente";
	
}
	/*Excluir*/
	public String excluir() {
		AdolescenteRN adolescenteRN = new AdolescenteRN();
		adolescenteRN.excluir(this.adolescente);
		this.lista = null;
		return null;
	}
	
	
	
	
	public Adolescente getAdolescente() {
		return adolescente;
	}
	public List<Adolescente> getLista() {
		
	
			
			if(this.lista == null) { //verifica se a lista esta vazia
				AdolescenteRN adolescenteRN = new AdolescenteRN(); //instancia uma nova classe de regra de negocio
				this.lista = adolescenteRN.listar(); //chama o metodo do objeto e atribui à propriedade local
			}
		
			
			return this.lista; //retorna a lista
		
		
	}
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setAdolescente(Adolescente adolescente) {
		this.adolescente = adolescente;
	}
	public void setLista(List<Adolescente> lista) {
		this.lista = lista;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}


	public UploadedFile getFoto() {
	
		return foto;
	}


	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}


	

}

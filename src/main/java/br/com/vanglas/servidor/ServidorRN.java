package br.com.vanglas.servidor;

import java.util.List;

import br.com.vanglas.util.DAOFactory;

public class ServidorRN {
	/*Objeto do tipo UsuarioDAO que vai receber uma instancia
	 * de DAOFactory
	 * 
	 * */
	private ServidorDAO servidorDAO;
	
	/*Construtor da classe, o objeto criado acima ira receber uma instancia de
	 * DAOFactory executando o metodo criarUsuarioDAO, que por sua vez
	 * retorna uma instancia de getSessionFactory do hibernateUtil*/
	public ServidorRN() {
		this.servidorDAO = DAOFactory.criarServidorDAO(); //aqui tem um objeto do tipo ServidorDAOHibernate com uma session hibernate criada
	}
	
/*Implementar os metodos que servidorDAO carrega consigo*/
	
	/*Carrega um Servidor baseado no codigo*/
	public Servidor carregar(Integer codigo) {
		
		return this.servidorDAO.carregar(codigo);
	}
	
	/*Metodo busca por nome*/
	public Servidor buscarPorNome(String nome) {
		
		return this.servidorDAO.buscarPorNome(nome);
	}
	
	public Servidor buscarPorMatricula (String matricula) {
		return this.servidorDAO.buscarPorMatricula(matricula);		
	}
	
	/*Metodo Salvar: Aqui ele implementa o metodo salvar do dao, mas ja com o objeto DaoFActory*/
	public void salvar(Servidor servidor) {
		Integer codigo = servidor.getCodigo(); //pega o codigo do usuario e atribui à variavel local
		
		/*Verifica o conteudo da variavel*/
		if(codigo == null || codigo == 0) {
			this.servidorDAO.salvar(servidor);
		}else {
			this.servidorDAO.atualizar(servidor);//se o codigo vier preenchido quer dizer que é pra alterar (atualizar)
		}
		
	}
	
	//Metodo para excluir unidade
	public void excluir(Servidor servidor) {
		this.servidorDAO.excluir(servidor); //chama o metodo excluir passando o usuario como parametro

	}

	public List<Servidor> listar() {
		return this.servidorDAO.listar(); //retorna uma lista de todos as unidades
	}
	
	
	
	

}

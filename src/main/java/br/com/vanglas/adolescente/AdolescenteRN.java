
/*Clase que conterá as regras de negocio, é a unica que vai comunicar com a camada 
 * de dados
 * 
 * -> Os metodos dessa classe so fazem o repassa para a clase DAO, alguns antes
 * implementam regras de negocio especificas, como o caso do metodo salvar
 * onde ele verifica se o servidor passado no parametro tem um codigo, caso tenha
 * ele vai atualizar e nao salvar.
 * 
 * */
package br.com.vanglas.adolescente;

import java.util.List;


import br.com.vanglas.util.DAOFactory;

public class AdolescenteRN {
	/*Objeto do tipo UsuarioDAO que vai receber uma instancia
	 * de DAOFactory
	 * 
	 * */
	private AdolescenteDAO adolescenteDAO;
	
	/*Construtor da classe, o objeto criado acima ira receber uma instancia de
	 * DAOFactory executando o metodo criarUsuarioDAO, que por sua vez
	 * retorna uma instancia de getSessionFactory do hibernateUtil*/
	public AdolescenteRN() {
		this.adolescenteDAO = DAOFactory.criarAdolescenteDAO(); //aqui tem um objeto do tipo ServidorDAOHibernate com uma session hibernate criada
	}
	
     /*Implementar os metodos que adolescenteDAO carrega consigo*/
	
	/*Carrega um Adolescente baseado no codigo*/
	public Adolescente carregar(Integer codigo) {
		return this.adolescenteDAO.carregar(codigo);
	}
	
	/*Metodo busca por nome*/
	public Adolescente buscarPorNome(String nome) {
		return this.adolescenteDAO.buscarPorNome(nome);
	}
	
	/*Metodo Salvar: Aqui ele implementa o metodo salvar do dao, mas ja com o objeto DaoFActory*/
	public void salvar(Adolescente adolescente) {
		Integer codigo = adolescente.getCodigo(); //pega o codigo do usuario e atribui à variavel local
		/*Verifica o conteudo da variavel*/
		if(codigo == null || codigo == 0) {
			this.adolescenteDAO.salvar(adolescente);
		}else {
			this.adolescenteDAO.atualizar(adolescente);//se o codigo vier preenchido quer dizer que é pra alterar (atualizar)
		}
	}
	//Metodo para excluir adolescente
	public void excluir(Adolescente adolescente) {
		this.adolescenteDAO.excluir(adolescente); //chama o metodo excluir passando o usuario como parametro

	}

	//Listar todos os adolescentes
	public List<Adolescente> listar() {
		return this.adolescenteDAO.listar(); //retorna uma lista de todos as unidades
	}
	
	
	

}

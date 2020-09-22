
/*Clase que conterá as regras de negocio, é a unica que vai comunicar com a camada 
 * de dados
 * 
 * -> Os metodos dessa classe so fazem o repassa para a clase DAO, alguns antes
 * implementam regras de negocio especificas, como o caso do metodo salvar
 * onde ele verifica se o usuario passado no parametro tem um codigo, caso tenha
 * ele vai atualizar e nao salvar.
 * 
 * */
package br.com.vanglas.unidade;


import java.util.List;




import br.com.vanglas.util.DAOFactory;
import br.com.vanglas.util.NegocioException;





public class UnidadeRN {
	/*Objeto do tipo UsuarioDAO que vai receber uma instancia
	 * de DAOFactory
	 * 
	 * */
	
	private UnidadeDAO unidadeDAO;
	
	/*Construtor da classe, o objeto criado acima ira receber uma instancia de
	 * DAOFactory executando o metodo criarUsuarioDAO, que por sua vez
	 * retorna uma instancia de getSessionFactory do hibernateUtil*/
	public UnidadeRN() {
		this.unidadeDAO = DAOFactory.criarUnidadeDAO();
	}
	
	/*Carrega uma unidade baseado no codigo*/
	public Unidade carregar(Long id) {
		
		return this.unidadeDAO.carregar(id);
	}
	
	/*Metodo busca por nome*/
	public Unidade buscarPorNome(String nome) {
		
		return this.unidadeDAO.buscarPorNome(nome);
	}
	
	/*Metodo Salvar: Aqui ele implementa o metodo salvar do dao, mas ja com o objeto DaoFActory*/
	public void salvar(Unidade unidade) {
		//Produto produtoExistente = produtos.porSku(produto.getSku());
		Unidade unidadeExistente = this.buscarPorNome(unidade.getNome());
		Long id = unidade.getId(); //pega o codigo do uniade e atribui à variavel local
		
		if(unidadeExistente != null) {
			throw new NegocioException("Já existe uma UNIDADE com o NOME informado: "+unidade.getNome().toString());
			
		}else {
			
			if(id == null || id == 0) {
				
				this.unidadeDAO.salvar(unidade);
			}else {
				this.unidadeDAO.atualizar(unidade);//se o codigo vier preenchido quer dizer que é pra alterar (atualizar)
			}
			
			
		}
			
			
			
	
			
		}
		
			
		
		
	
	
	//Metodo para excluir unidade
		public void excluir(Unidade unidade) {
			this.unidadeDAO.excluir(unidade); //chama o metodo excluir passando o usuario como parametro

		}
	
		public List<Unidade> listar() {
			return this.unidadeDAO.listar(); //retorna uma lista de todos as unidades
		}
		
}


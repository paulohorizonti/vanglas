package br.com.vanglas.unidade;
/*Implementa a clase  UnidadeDAO, que tem os metodos para manipulacao do banco*/
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UnidadeDAOHibernate implements UnidadeDAO {
    /*Obrigatorio para toda DAOHibernate, é pelo setSession que injetamos a sessao do hibernate
	 * na classe que vai implementar os metodos CRUD
	 * */
	private Session session; 
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	/*Metodo que ira salvar uma unidade no banco passando o objeto Unidade como parametros*/
	@Override
	public void salvar(Unidade unidade) {
		this.session.save(unidade);

	}

	/*Metodo que ira atualizar uma Unidade no banco passando o objeto unidade como parametros*/
	@Override
	public void atualizar(Unidade unidade) {
		this.session.update(unidade);

	}
	/*Metodo que ira excluir uma Unidade no banco passando o objeto unidade como parametros*/
	@Override
	public void excluir(Unidade unidade) {
		this.session.delete(unidade);

	}
	/*Retorna uma unidade baseada em seu codigo*/
	@Override
	public Unidade carregar(Long id) {
		return (Unidade) this.session.get(Unidade.class, id);//retorna um objeto unidade pelo seu codigo
	}

	/*Retorna uma unidade baseada em seu nome*/
	@Override
	public Unidade buscarPorNome(String nome) {
		String hql = "select u from Unidade u where u.nome = :nome";
		Query consulta = this.session.createQuery(hql); //cria uma query com o comando sql
		consulta.setString("nome", nome);             //passa o parametro
		return (Unidade) consulta.uniqueResult();       //retorna um unico unidade, pois o nome  é unico
	}
	
	/*Retorna uma lista de unidades, todas*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade> listar() {
		return this.session.createCriteria(Unidade.class).list();
	}

}

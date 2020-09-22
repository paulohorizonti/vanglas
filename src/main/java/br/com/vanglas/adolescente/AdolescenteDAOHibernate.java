/*Implementa a clase  AdolescenteDAO, que tem os metodos para manipulacao do banco*/
package br.com.vanglas.adolescente;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class AdolescenteDAOHibernate implements AdolescenteDAO{
	 /*Obrigatorio para toda DAOHibernate; é pelo setSession que injetamos a sessao do hibernate
	 * na classe que vai implementar os metodos CRUD
	 **/
	private Session session; 
	
	/*Get e set da session*/
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	
	/*Metodos sobrescritos: Metodos da interface*/
	
	
	/*Metodo que ira salvar um Adolescente no banco passando o objeto Adolesente como parametros*/
	@Override
	public void salvar(Adolescente adolescente) {
		this.session.save(adolescente);
		
	}

	/*Metodo que ira atualizar um  Adolescente no banco passando o objeto adolescente como parametros*/
	@Override
	public void atualizar(Adolescente adolescente) {
		this.session.update(adolescente);
		
	}

	/*Metodo que ira excluir um Servidor no banco passando o objeto Servidor como parametros*/
	@Override
	public void excluir(Adolescente adolescente) {
		this.session.delete(adolescente);
		
	}

	/*Retorna um Adolescente baseada em seu codigo*/
	@Override
	public Adolescente carregar(Integer codigo) {
		return (Adolescente) this.session.get(Adolescente.class, codigo); //retorna um objeto Adolescente pelo seu codigo
	}

	/*Retorna um Adolescente baseado em seu nome*/
	@Override
	public Adolescente buscarPorNome(String nome) {
		String hql = "select u from tbl_adolescente u where u.ado_nome = :ado_nome";
		Query consulta = this.session.createQuery(hql);       //cria uma query com o comando sql
		consulta.setString("ado_nome", nome);                 //passa o parametro
		return (Adolescente) consulta.uniqueResult();         //retorna um unico Adolescente, pois o nome  é unico
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Adolescente> listar() {
		return this.session.createCriteria(Adolescente.class).list();
	}

}

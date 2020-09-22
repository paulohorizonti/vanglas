package br.com.vanglas.servidor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ServidorDAOHibernate implements ServidorDAO {
	
	 /*Obrigatorio para toda DAOHibernate, é pelo setSession que injetamos a sessao do hibernate
	 * na classe que vai implementar os metodos CRUD
	 * */
	private Session session;
	
	/*Get e set da session*/
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Servidor servidor) {
		this.session.save(servidor);

	}

	@Override
	public void atualizar(Servidor servidor) {
		this.session.update(servidor);

	}

	@Override
	public void excluir(Servidor servidor) {
		this.session.delete(servidor);


	}

	@Override
	public Servidor carregar(Integer codigo) {
		return (Servidor) this.session.get(Servidor.class, codigo);//retorna um objeto Servidor pelo seu codigo
	}

	@Override
	public Servidor buscarPorNome(String nome) {
		String hql = "select u from tbl_servidor u where u.ser_nome = :ser_nome";
		Query consulta = this.session.createQuery(hql);   //cria uma query com o comando sql
		consulta.setString("ser_nome", nome);             //passa o parametro
		return (Servidor) consulta.uniqueResult();         //retorna um unico unidade, pois o nome  é unico
	}

	@Override
	public Servidor buscarPorMatricula(String matricula) {
		String hql = "select u from tbl_servidor u where u.ser_matricula = :ser_matricula";
		Query consulta = this.session.createQuery(hql);   //cria uma query com o comando sql
		consulta.setString("ser_matricula", matricula);             //passa o parametro
		return (Servidor) consulta.uniqueResult();         //retorna um unico Servidor, pois a matricula  é unica
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servidor> listar() {
		return this.session.createCriteria(Servidor.class).list();
	}

}

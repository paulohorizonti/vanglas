package br.com.vanglas.util;

import br.com.vanglas.adolescente.AdolescenteDAO;
import br.com.vanglas.adolescente.AdolescenteDAOHibernate;
import br.com.vanglas.servidor.ServidorDAO;
import br.com.vanglas.servidor.ServidorDAOHibernate;
import br.com.vanglas.unidade.UnidadeDAO;
import br.com.vanglas.unidade.UnidadeDAOHibernate;

public class DAOFactory {
	
	public static UnidadeDAO criarUnidadeDAO() {
		/*Objeto do tipo unidadeDAOhibernate - instancia de UnidadeDAOHibernate*/
		UnidadeDAOHibernate unidadeDAO = new UnidadeDAOHibernate();
		/*Setando a sessao passando sessionFactory e pegando a sessao corrente*/
		unidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		//retorna o usuarioDAO
		return unidadeDAO;
	}
	/*Criar um adolescente*/
	public static AdolescenteDAO criarAdolescenteDAO() {
		/*Objeto do tipo AdolescenteDAOhibernate - instancia de AdolescenteDAOHibernate*/
		AdolescenteDAOHibernate adolescenteDAO = new AdolescenteDAOHibernate();
		/*Setando a sessao passando sessionFactory e pegando a sessao corrente*/
		adolescenteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		//retorna o adolescenteDAO
		return adolescenteDAO;
	}
	
	/*Criar um novo servidor*/
	public static ServidorDAO criarServidorDAO() {
		/*Objeto do tipo servidorDAOhibernate - instancia de ServidorDAOHibernate*/
		ServidorDAOHibernate servidorDAO = new ServidorDAOHibernate();
		/*Setando a sessao passando sessionFactory e pegando a sessao corrente*/
		servidorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		//retorna o usuarioDAO
		return servidorDAO;
	}

}

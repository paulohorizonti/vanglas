package br.com.vanglas.servidor;

import java.util.List;

public interface ServidorDAO {
	
	
		public void salvar           (Servidor servidor); //Salva usando um objeto do tipo Servidor
		public void atualizar        (Servidor servidor); //Atualiza/edita usando um objeto do tipo Servidor
		public void excluir          (Servidor servidor); //Deleta usando um objeto do tipo Servidor
		public Servidor carregar      (Integer codigo);  //Carrega um Servidor pelo seu codigo
		public Servidor buscarPorNome (String nome);     //Busca uma  Servidor pelo seu nome
		public Servidor buscarPorMatricula (String matricula);     //Busca uma  Servidor pela sua
		public List<Servidor> listar();                  //Metodo para listar todos os Servidores

	
}

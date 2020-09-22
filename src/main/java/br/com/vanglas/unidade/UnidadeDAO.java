/*Interface com apenas as assinaturas dos metodos de cada operação
 * Regra das separação das responsabilidades
 * */
package br.com.vanglas.unidade;

import java.util.List;


public interface UnidadeDAO {
	public void salvar           (Unidade unidade); //Salva usando um objeto do tipo Unidade
	public void atualizar        (Unidade unidade); //Atualiza/edita usando um objeto do tipo Unidade
	public void excluir          (Unidade unidade); //Deleta usando um objeto do tipo Unidade
	public Unidade carregar      (Long id);  //Carrega um Unidade pelo seu codigo
	public Unidade buscarPorNome (String nome);     //Busca uma  Unidade pelo seu nome
	public List<Unidade> listar();                  //Metodo para listar todos as Unidades

}

/*Interface com apenas as assinaturas dos metodos de cada operação
 * Regra das separação das responsabilidades
 * */
package br.com.vanglas.adolescente;

import java.util.List;



public interface AdolescenteDAO {
	public void salvar               (Adolescente adolescente); //Salva usando um objeto do tipo Adolescente
	public void atualizar            (Adolescente adolescente); //Atualiza/edita usando um objeto do tipo Adolescente
	public void excluir              (Adolescente adolescente); //Deleta usando um objeto do tipo Adolescente
	public Adolescente carregar      (Integer codigo);  //Carrega um Adolescente pelo seu codigo
	public Adolescente buscarPorNome   (String nome);     //Busca um  Adolescente pelo seu nome
	public List<Adolescente> listar();                  //Metodo para listar todos os Adolescente

}

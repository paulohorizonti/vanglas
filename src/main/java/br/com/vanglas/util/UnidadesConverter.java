package br.com.vanglas.util;


import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vanglas.unidade.Unidade;
import br.com.vanglas.unidade.UnidadeRN;



@FacesConverter(forClass=Unidade.class)
public class UnidadesConverter  implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigoString) {
		Unidade retorno = null;
		if(codigoString != null && !codigoString.isEmpty()) {
			Long codigo = new Long(codigoString);
			
			//Long codigo = Long.valueOf(codigoString);
			UnidadeRN unidadeRN = new UnidadeRN();
			retorno =  unidadeRN.carregar(codigo);
			
		}
		if (retorno != null) {
			return retorno;
		}else {
			
			return retorno;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object unidadeObjeto) {
		if(unidadeObjeto != null) {
			Unidade unidade = ((Unidade) unidadeObjeto);
			return unidade.getId().toString();
			
		}
		return null;
	}

	

}

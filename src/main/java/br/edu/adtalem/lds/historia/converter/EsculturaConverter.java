package br.edu.adtalem.lds.historia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.repository.EsculturaRepository;
import br.edu.adtalem.lds.historia.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Escultura.class)
public class EsculturaConverter implements Converter {

	private EsculturaRepository repository;
	
	public EsculturaConverter() {
		repository = CDIServiceLocator.getBean(EsculturaRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String value) {
		Escultura e = null;
		if(StringUtils.isNotBlank(value)){
			Long id = new Long(value);
			e = repository.porId(id);
		}
		return e;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Escultura e = (Escultura)value;
			return e.getId() == null ? null : e.getId().toString();
		}
		return "";
	}

}

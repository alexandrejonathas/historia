package br.edu.adtalem.lds.historia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.edu.adtalem.lds.historia.model.Escultura;

@Named
@ViewScoped
public class MapaBean implements Serializable {

	private static final long serialVersionUID = 6474789998750743299L;

	private MapModel simpleModel;
	private Escultura escultura;		
	
	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();				
	}
	
	public void montarMaker() {
		if(escultura != null) {
		
			//LAT: -22.9520904
			//LON: -43.2105701
			
        	LatLng coordenadas = new LatLng(escultura.getLatitude(), escultura.getLongitude());
        
        	simpleModel.addOverlay(new Marker(coordenadas, escultura.getNome()));        	        	
        	
        	System.out.println("Montou o marker");
		}else {
			System.out.println("Não montou o marker");
		}		
	}
	
	public MapModel getSimpleModel() {
		return simpleModel;
	}


	public Escultura getEscultura() {
		return escultura;
	}


	public void setEscultura(Escultura escultura) {
		this.escultura = escultura;
	}	
	
}

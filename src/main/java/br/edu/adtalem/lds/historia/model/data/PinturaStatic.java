package br.edu.adtalem.lds.historia.model.data;

import java.util.ArrayList;
import java.util.List;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Pintura;

public class PinturaStatic {
	
	private static volatile PinturaStatic instance;
	
	private List<Arte> pinturas = new ArrayList<>();
	private static Long id = 0L;
	
	private PinturaStatic() {
		for(int i = 0; i < 10; i++) {			
			Arte arte = new Pintura();
			id++;
			arte.setId(id);
			arte.setNome("Rio Ipojuca "+i);
			arte.setAutor("Jonathas");
			arte.setAno(2018);
		
			pinturas.add(arte);		
		}
	}
	
	public static PinturaStatic getInstance() {
		if(instance == null) {
			synchronized (PinturaStatic.class) {
				if(instance == null)
					instance = new PinturaStatic();
			}
		}
		return instance;
	}
	
	public void add(Arte p) {
		id++;
		p.setId(id);
		pinturas.add(p);
	}
	
	public void remove(Arte p) {
		pinturas.remove(p);
	}
	
	public List<Arte> getArteVisuals() {
		return pinturas;
	}
	
	public Arte getArteVisual(Long id) {
		Arte pintura = null;
		for(Arte p : pinturas) {
			if(p.getId() == id) {
				pintura = p;
				break;
			}
		}
		return pintura;
	}
	
}

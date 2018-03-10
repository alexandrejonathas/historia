package br.edu.adtalem.lds.historia.model.data;

import java.util.ArrayList;
import java.util.List;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.Pintura;

public class StaticDB {
	
	private static volatile StaticDB instance;
	
	private static Long id = 0L;
	private List<Arte> pinturas = new ArrayList<>();
	
	private static Long codigo = 0L;
	private List<Arte> esculturas = new ArrayList<>();
	
	private StaticDB() {
		for(int i = 0; i < 10; i++) {			
			Arte arte = new Pintura();
			id++;
			arte.setId(id);
			arte.setNome("Pintura "+i);
			arte.setAutor("Jonathas");
			arte.setAno(2018);
		
			pinturas.add(arte);		
		}
		
		for(int i = 0; i < 10; i++) {			
			Arte arte = new Escultura();
			codigo++;
			arte.setId(codigo);
			arte.setNome("Escultura "+i);
			arte.setAutor("Jonathas");
			arte.setAno(2018);
		
			esculturas.add(arte);		
		}		
		
	}
	
	public static StaticDB getInstance() {
		if(instance == null) {
			synchronized (StaticDB.class) {
				if(instance == null)
					instance = new StaticDB();
			}
		}
		return instance;
	}
	
	public void addPintura(Arte arte) {
		id++;
		arte.setId(id);
		pinturas.add(arte);
	}
	
	public void addEscultura(Arte arte) {
		codigo++;
		arte.setId(codigo);
		esculturas.add(arte);
	}	
	
	public void removePintura(Arte arte) {
		pinturas.remove(arte);
	}

	public void removeEscultura(Arte arte) {
		esculturas.remove(arte);
	}	
	
	public List<Arte> getPinturas() {
		return pinturas;
	}
	
	public Arte getPintura(Long id) {
		Arte pintura = null;
		for(Arte p : pinturas) {
			if(p.getId() == id) {
				pintura = p;
				break;
			}
		}
		return pintura;
	}
	
	public List<Arte> getEsculturas() {
		return esculturas;
	}
	
	public Arte getEscultura(Long id) {
		Arte arte = null;
		for(Arte a : esculturas) {
			if(a.getId() == id) {
				arte = a;
				break;
			}
		}
		return arte;
	}	
	
}

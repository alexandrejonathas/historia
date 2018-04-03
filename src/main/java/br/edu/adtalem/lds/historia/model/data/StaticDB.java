package br.edu.adtalem.lds.historia.model.data;

import java.util.ArrayList;
import java.util.List;

import br.edu.adtalem.lds.historia.model.Arte;
import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.model.Pessoa;
import br.edu.adtalem.lds.historia.model.Pintura;

public class StaticDB {
	
	private static volatile StaticDB instance;
	
	private static Long id = 0L;
	private List<Arte> pinturas = new ArrayList<>();
	
	private static Long codigo = 0L;
	private List<Arte> esculturas = new ArrayList<>();
	
	private Long idH = 0L;
	private List<Pessoa> herois = new ArrayList<>();
	
	private Long idF = 0L;	
	private List<Pessoa> filosofos = new ArrayList<>();
	
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
		
		for(int i = 0; i < 10; i++) {			
			Heroi pessoa = new Heroi();
			idH++;
			pessoa.setId(idH);
			pessoa.setNome("Herói "+i);
			pessoa.setConhecidoPor("Zenicleyton");
			pessoa.setHabilidade("Rapido com espada");
			pessoa.setCaracteristica("Senhor do reino dos mortos");
		
			herois.add(pessoa);		
		}		
		
		for(int i = 0; i < 10; i++) {			
			Filosofo pessoa = new Filosofo();
			idF++;
			pessoa.setId(idF);
			pessoa.setNome("Filósofo "+i);
			pessoa.setConhecidoPor("Zenicleyton");
			pessoa.setMorte(2018);
			pessoa.setNascimento(2000);
			pessoa.setCaracteristica("Fundador da filosofia ocidental");
		
			filosofos.add(pessoa);		
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
	
	public void addHeroi(Pessoa pessoa) {
		idH++;
		pessoa.setId(idH);
		herois.add(pessoa);
	}
	
	public void addFilosofo(Pessoa pessoa) {
		idF++;
		pessoa.setId(idF);
		filosofos.add(pessoa);
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
	
	public List<Pessoa> getHerois() {
		return herois;
	}
	
	public Pessoa getHeroi(Long id) {
		Pessoa heroi = null;
		for(Pessoa p : herois) {
			if(p.getId() == id) {
				heroi = p;
				break;
			}
		}
		return heroi;
	}
	
	public List<Pessoa> getFilosofos() {
		return filosofos;
	}
	
	public Pessoa getFilosofo(Long id) {
		Pessoa filosofo = null;
		for(Pessoa p : filosofos) {
			if(p.getId() == id) {
				filosofo = p;
				break;
			}
		}
		return filosofo;
	}

	public void removerHeroi(Pessoa pessoa) {
		herois.remove(pessoa);
		
	}
	
	public void removerFilosofo(Pessoa pessoa) {
		filosofos.remove(pessoa);
		
	}
}

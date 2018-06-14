package br.edu.adtalem.lds.historia.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.adtalem.lds.historia.model.Pintura;
import br.edu.adtalem.lds.historia.repository.filter.ArteFilter;
import br.edu.adtalem.lds.historia.util.jpa.Transactional;
import br.edu.adtalem.lds.historia.util.negocio.NegocioException;

public class PinturaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public Pintura salvar(Pintura pintura){
		return manager.merge(pintura);
	}
	
	public Pintura porId(Long id){
		return manager.find(Pintura.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pintura> lista(ArteFilter filter){
		Session session = manager.unwrap(Session.class);
		Criteria c = session.createCriteria(Pintura.class);
		if(StringUtils.isNotBlank(filter.getNome())){
			c.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filter.getAutor())){
			c.add(Restrictions.ilike("autor", filter.getAutor(), MatchMode.ANYWHERE));
		}
		if(filter.getAno() != null){
			c.add(Restrictions.eq("ano", filter.getAno()));
		}		
		return c.addOrder(Order.asc("nome")).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pintura> listaOrdenadaPorMaiorValor(){
		Session session = manager.unwrap(Session.class);
		Criteria c = session.createCriteria(Pintura.class);		
		return c.addOrder(Order.desc("valor")).list();
	}	

	@Transactional
	public void remover(Pintura pintura) {
        try {
            pintura = porId(pintura.getId()); //Busca produto
            manager.remove(pintura);
            manager.flush(); //Faz todas as transações
        } catch (PersistenceException ex) {
            throw new NegocioException("A pintura não pode ser excluída.");
        }
	}	
	
}

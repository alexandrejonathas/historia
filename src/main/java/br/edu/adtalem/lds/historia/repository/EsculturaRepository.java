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

import br.edu.adtalem.lds.historia.model.Escultura;
import br.edu.adtalem.lds.historia.repository.filter.ArteFilter;
import br.edu.adtalem.lds.historia.util.jpa.Transactional;
import br.edu.adtalem.lds.historia.util.negocio.NegocioException;

public class EsculturaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public Escultura salvar(Escultura escultura){
		return manager.merge(escultura);
	}
	
	public Escultura porId(Long id){
		return manager.find(Escultura.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Escultura> lista(ArteFilter filter){
		Session session = manager.unwrap(Session.class);
		Criteria c = session.createCriteria(Escultura.class);
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

	@Transactional
	public void remover(Escultura escultura) {
        try {
            escultura = porId(escultura.getId()); //Busca produto
            manager.remove(escultura);
            manager.flush(); //Faz todas as transações
        } catch (PersistenceException ex) {
            throw new NegocioException("A escultura não pode ser excluída.");
        }
	}	
	
}

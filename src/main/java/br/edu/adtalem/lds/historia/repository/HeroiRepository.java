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

import br.edu.adtalem.lds.historia.model.Heroi;
import br.edu.adtalem.lds.historia.repository.filter.PessoaFilter;
import br.edu.adtalem.lds.historia.util.jpa.Transactional;
import br.edu.adtalem.lds.historia.util.negocio.NegocioException;

public class HeroiRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public Heroi salvar(Heroi heroi){
		return manager.merge(heroi);
	}
	
	public Heroi porId(Long id){
		return manager.find(Heroi.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Heroi> lista(PessoaFilter filter){
		Session session = manager.unwrap(Session.class);
		Criteria c = session.createCriteria(Heroi.class);
		if(StringUtils.isNotBlank(filter.getNome())){
			c.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filter.getConhecidoPor())){
			c.add(Restrictions.ilike("conhecidoPor", filter.getConhecidoPor(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filter.getCaracteristica())){
			c.add(Restrictions.ilike("caracteristica", filter.getCaracteristica(), MatchMode.ANYWHERE));
		}		
		return c.addOrder(Order.asc("nome")).list();
	}

	@Transactional
	public void remover(Heroi heroi) {
        try {
            heroi = porId(heroi.getId());
            manager.remove(heroi);
            manager.flush(); 
        } catch (PersistenceException ex) {
            throw new NegocioException("O heroi não pode ser excluído.");
        }
	}	
	
}

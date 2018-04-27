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

import br.edu.adtalem.lds.historia.model.Filosofo;
import br.edu.adtalem.lds.historia.repository.filter.PessoaFilter;
import br.edu.adtalem.lds.historia.util.jpa.Transactional;
import br.edu.adtalem.lds.historia.util.negocio.NegocioException;

public class FilosofoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Transactional
	public Filosofo salvar(Filosofo filosofo){
		return manager.merge(filosofo);
	}
	
	public Filosofo porId(Long id){
		return manager.find(Filosofo.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Filosofo> lista(PessoaFilter filter){
		Session session = manager.unwrap(Session.class);
		Criteria c = session.createCriteria(Filosofo.class);
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
	public void remover(Filosofo filosofo) {
        try {
            filosofo = porId(filosofo.getId()); //Busca produto
            manager.remove(filosofo);
            manager.flush(); //Faz todas as transações
        } catch (PersistenceException ex) {
            throw new NegocioException("O filosofo não pode ser excluído.");
        }
	}	
	
}

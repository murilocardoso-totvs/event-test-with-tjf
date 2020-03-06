package com.mcc.eventtestwithtjf.produto.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcc.eventtestwithtjf.produto.domain.Produto;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoDomainRepository;
import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
@Transactional
public class ProdutoRepository extends CrudAggregateRepository<Produto, ProdutoId> 
	implements ProdutoDomainRepository {
	
	public ProdutoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}
	
	@Override
	public String getTableName() {
		return "tbl_produto";
	}	
}
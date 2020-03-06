package com.mcc.eventtestwithtjf.processorecebimento.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimento;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoDomainRepository;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoId;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
@Transactional
public class ProcessoRecebimentoRepository extends CrudAggregateRepository<ProcessoRecebimento, ProcessoRecebimentoId>
        implements ProcessoRecebimentoDomainRepository {

	public ProcessoRecebimentoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	public String getTableName() {
		return "tbl_processo_recebimento";
	}
}

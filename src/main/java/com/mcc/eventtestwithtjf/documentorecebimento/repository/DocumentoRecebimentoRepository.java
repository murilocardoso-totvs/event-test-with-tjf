package com.mcc.eventtestwithtjf.documentorecebimento.repository;

import java.sql.Types;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimento;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoDomainRepository;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
@Transactional
public class DocumentoRecebimentoRepository
        extends CrudAggregateRepository<DocumentoRecebimento, DocumentoRecebimentoId>
        implements DocumentoRecebimentoDomainRepository {

	public DocumentoRecebimentoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	public String getTableName() {
		return "tbl_documento_recebimento";
	}

	@Override
	public Optional<DocumentoRecebimento> findById(DocumentoRecebimentoId id) {
		return this.findOne("id = ?", new SqlParameterValue(Types.VARCHAR, id.toString()));
	}
}
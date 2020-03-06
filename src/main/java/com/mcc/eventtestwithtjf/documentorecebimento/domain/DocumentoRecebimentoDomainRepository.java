package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import java.util.Optional;

import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface DocumentoRecebimentoDomainRepository
        extends AggregateRepository<DocumentoRecebimento, DocumentoRecebimentoId> {
	public Optional<DocumentoRecebimento> findById(DocumentoRecebimentoId id);
}
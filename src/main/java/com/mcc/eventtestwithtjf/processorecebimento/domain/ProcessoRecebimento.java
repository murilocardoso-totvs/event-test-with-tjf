package com.mcc.eventtestwithtjf.processorecebimento.domain;

import java.util.ArrayList;
import java.util.List;

import com.mcc.eventtestwithtjf.commom.domain.AggregateRoot;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Aggregate
public class ProcessoRecebimento extends AggregateRoot {
	
	@Include
	@AggregateIdentifier
	private ProcessoRecebimentoId id;
	private String descricao;
	private List<DocumentoRecebimentoId> documentos = new ArrayList<>();
	
	@Builder
	private ProcessoRecebimento(ProcessoRecebimentoId id,
	                            String descricao,
	                            List<DocumentoRecebimentoId> documentos) {
		this.id = id;
		this.descricao = descricao;
		this.documentos.addAll(documentos);
		
		this.registerEvent(ProcessoRecebimentoCriadoEvent.from(this));
	}
}

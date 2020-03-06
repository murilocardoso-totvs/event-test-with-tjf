package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import java.util.ArrayList;
import java.util.List;

import com.mcc.eventtestwithtjf.commom.domain.AggregateRoot;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Aggregate
public class DocumentoRecebimento extends AggregateRoot {

	@Include
	@AggregateIdentifier
	private DocumentoRecebimentoId id;
	private String identificador;
	private List<DocumentoRecebimentoItem> itens = new ArrayList<>();
	private Situacao situacaoAtual;

	@Builder
	private DocumentoRecebimento(DocumentoRecebimentoId id,
	                             String identificador,
	                             List<DocumentoRecebimentoItem> itens) {
		this.id = id;
		this.identificador = identificador;
		this.itens.addAll(itens);
		this.situacaoAtual = Situacao.DISPONIVEL;

		this.registerEvent(DocumentoRecebimentoCadastradoEvent.from(this));
	}

	public void associado() {
		this.situacaoAtual = Situacao.ASSOCIADO;

		this.registerEvent(DocumentoRecebimentoAssociadoProcessoRecebimentoEvent.from(this));
	}
}

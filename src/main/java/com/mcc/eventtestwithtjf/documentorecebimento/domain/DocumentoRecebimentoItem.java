package com.mcc.eventtestwithtjf.documentorecebimento.domain;

import java.math.BigDecimal;

import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentoRecebimentoItem {
	@Include
	private DocumentoRecebimentoItemId id;
	private ProdutoId produtoId;
	private BigDecimal quantidade;

	@Builder
	private DocumentoRecebimentoItem(DocumentoRecebimentoItemId id, ProdutoId produtoId, BigDecimal quantidade) {
		this.id = id;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

}

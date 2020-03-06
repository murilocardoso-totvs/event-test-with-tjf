package com.mcc.eventtestwithtjf.documentorecebimento.application.command;

import java.math.BigDecimal;
import java.util.List;

import com.mcc.eventtestwithtjf.produto.domain.ProdutoId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class CadastrarDocumentoRecebimentoCommand {
	private final String identificador;
	private final List<CadastrarDocumentoRecebimentoItemCommand> itens;

	@Getter
	@EqualsAndHashCode
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder
	public static class CadastrarDocumentoRecebimentoItemCommand {
		private final ProdutoId produtoId;
		private final BigDecimal quantidade;
	}
}

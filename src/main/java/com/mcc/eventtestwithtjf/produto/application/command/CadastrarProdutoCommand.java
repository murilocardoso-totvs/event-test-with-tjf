package com.mcc.eventtestwithtjf.produto.application.command;

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
public final class CadastrarProdutoCommand {
	private final ProdutoId id;
	private final String nome;
}

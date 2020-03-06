package com.mcc.eventtestwithtjf.produto.domain;

import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProdutoCadastradoEvent implements DomainEvent {
	private final String id;
	private final String nome;

	public static ProdutoCadastradoEvent from(Produto produto) {
		return new ProdutoCadastradoEvent(produto.getId().toString(), produto.getNome());
	}
}

package com.mcc.eventtestwithtjf.produto.domain;

import com.mcc.eventtestwithtjf.commom.domain.AggregateRoot;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode(callSuper = false)
@Aggregate
public class Produto extends AggregateRoot {
	
	@Include
	@AggregateIdentifier
	private final ProdutoId id;
	private String nome;
	
	@Builder
	private Produto(ProdutoId id, String nome) {
		this.id = id;
		this.nome = nome;
		
		this.registerEvent(ProdutoCadastradoEvent.from(this));
	}
}

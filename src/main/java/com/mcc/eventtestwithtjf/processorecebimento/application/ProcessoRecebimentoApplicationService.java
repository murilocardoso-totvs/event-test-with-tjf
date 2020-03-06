package com.mcc.eventtestwithtjf.processorecebimento.application;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.mcc.eventtestwithtjf.processorecebimento.application.command.CriarProcessoRecebimentoCommand;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimento;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoDomainRepository;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class ProcessoRecebimentoApplicationService {
	private final ProcessoRecebimentoDomainRepository processoRecebimentoRepository;
	private final ApplicationEventPublisher publisher;

	public ProcessoRecebimentoId handle(CriarProcessoRecebimentoCommand cmd) {

		var processoRecebimento = ProcessoRecebimento.builder()
		                                             .id(ProcessoRecebimentoId.generate())
		                                             .descricao(cmd.getDescricao())
		                                             .documentos(cmd.getDocumentos()
		                                                            .stream()
		                                                            .map(documento -> DocumentoRecebimentoId.from(documento.getId()
		                                                                                                                   .toString()))
		                                                            .collect(Collectors.toList()))
		                                             .build();
		
		processoRecebimentoRepository.insert(processoRecebimento);

		processoRecebimento.getEvents().forEach(publisher::publishEvent);

		return processoRecebimento.getId();
	}
}

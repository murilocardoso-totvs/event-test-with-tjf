package com.mcc.eventtestwithtjf.documentorecebimento.application;

import static java.util.stream.Collectors.toList;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.mcc.eventtestwithtjf.documentorecebimento.application.command.CadastrarDocumentoRecebimentoCommand;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimento;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoDomainRepository;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoId;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItem;
import com.mcc.eventtestwithtjf.documentorecebimento.domain.DocumentoRecebimentoItemId;
import com.mcc.eventtestwithtjf.processorecebimento.domain.ProcessoRecebimentoCriadoEvent;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Service
@Transactional
public class DocumentoRecebimentoApplicationService {
	private final DocumentoRecebimentoDomainRepository repository;
	private final ApplicationEventPublisher publisher;
	
	public DocumentoRecebimentoId handle(CadastrarDocumentoRecebimentoCommand cmd) {
		var documentoRecebimento = DocumentoRecebimento.builder()
													   .id(DocumentoRecebimentoId.generate())
													   .identificador(cmd.getIdentificador())
													   .itens(cmd.getItens().stream() 
															   				.map(itemCmd -> 
															   					DocumentoRecebimentoItem.builder()
															   					                        .id(DocumentoRecebimentoItemId.generate())
															   					                        .produtoId(itemCmd.getProdutoId())
															   					                        .quantidade(itemCmd.getQuantidade())
															   					                        .build())
															   				.collect(toList()))
													   .build();
		
		repository.insert(documentoRecebimento);
		
		documentoRecebimento.getEvents().forEach(publisher::publishEvent);
		
		return documentoRecebimento.getId();
	}

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void on(ProcessoRecebimentoCriadoEvent event) {
		
		log.info("-- Begin DocumentoRecebimentoApplicationService --");
		
		event.getDocumentos().forEach(documentoRecebimentoEvent -> {
			var documentoRecebimento = repository.findById(DocumentoRecebimentoId.from(documentoRecebimentoEvent.getId()))
												 .orElseThrow();
			
			documentoRecebimento.associado(); 
			
			repository.update(documentoRecebimento);
			
			documentoRecebimento.getEvents().forEach(publisher::publishEvent);
		});
		
		log.info("-- End DocumentoRecebimentoApplicationService --");
		
	}
}

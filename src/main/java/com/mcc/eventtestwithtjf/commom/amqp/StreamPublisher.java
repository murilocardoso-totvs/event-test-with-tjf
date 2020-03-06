package com.mcc.eventtestwithtjf.commom.amqp;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.mcc.eventtestwithtjf.commom.amqp.MyWMSChannel.WMSExchange;
import com.mcc.eventtestwithtjf.commom.domain.DomainEvent;
import com.totvs.tjf.core.message.TOTVSMessage;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@EnableBinding(value = MyWMSChannel.WMSExchange.class)
@AllArgsConstructor
public class StreamPublisher {

	private WMSExchange wmsExchange;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onEvent(DomainEvent event) {

		log.info("-- Begin StreamPublisher --");

		var eventName = event.getClass().getSimpleName();

		log.info(eventName);

		try {
			var message = new TOTVSMessage<DomainEvent>(eventName, event);
			message.sendTo(wmsExchange.output());

		} catch (Exception e) {
			log.info("Exchange: {}\nTopic: {}\n", wmsExchange, eventName);
		}

		log.info("-- End StreamPublisher --");

	}
}

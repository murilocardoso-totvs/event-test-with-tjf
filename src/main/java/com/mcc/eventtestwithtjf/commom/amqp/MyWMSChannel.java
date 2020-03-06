package com.mcc.eventtestwithtjf.commom.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MyWMSChannel {
	
	public static final String WMS = "my-wms-exchange";	
	
	public interface WMSExchange {
		@Output(MyWMSChannel.WMS)
		MessageChannel output();
	}	
}
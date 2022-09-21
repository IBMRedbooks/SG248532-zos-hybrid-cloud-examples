package com.ibm.kafka.demo;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class AppKafkaConsumer {

	@Autowired
	private  ConfigProperties cp;
	
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
    
 
		 props.put("bootstrap.servers",cp.getKafkaBrokers());
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("linger.ms", 1);
		 props.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,  cp.getKeyDeserializer());
		 props.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
		          cp.getValueDeserializer());
		 props.put("security.protocol", "SASL_SSL");
		 props.put("sasl.mechanism", "PLAIN");
		 props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\""+cp.getKafkaUser()+"\" password="+"\""+cp.getKafkaPassword()+"\""+";");
	
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> 
      kafkaListenerContainerFactory() {
   
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
          new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    

	
	
	@KafkaListener(topics = "sample-topic", groupId ="consumer-group")
	public void listenEvent(@Payload String  message) {
	    System.out.println("Received Message  " + message);
	    System.out.println("Business logic should be placed here");
	}
}
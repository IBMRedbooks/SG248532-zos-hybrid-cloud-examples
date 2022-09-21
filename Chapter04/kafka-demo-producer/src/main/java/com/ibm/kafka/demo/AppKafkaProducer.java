/**
 * 
 */
package com.ibm.kafka.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author apatilus.ibm.com
 *
 */
@Component
public class AppKafkaProducer {

	@Autowired
	private  ConfigProperties cp;
	
	public void sendMessage(String topic, String message) throws Exception
{
		Properties props = new Properties();
		 props.put("bootstrap.servers",cp.getKafkaBrokers());
		 props.put("acks", "all");
		 props.put("partition", 0);
		 props.put("retries", 0);
		 props.put("linger.ms", 1);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("security.protocol", "SASL_SSL");
		 props.put("sasl.mechanism", "PLAIN");
		 props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\""+cp.getKafkaUser()+"\" password="+"\""+cp.getKafkaPassword()+"\""+";");
		 
		 Producer<String, String>  producer = new KafkaProducer<>(props);
		producer.send(new ProducerRecord<String, String>(topic, message));
		
 	 //TODO: considering messages load, creating and closing connection with producer each time, it may have to be addressed in future, if performance issues observed.
		producer.close();
		
}
	
	
}

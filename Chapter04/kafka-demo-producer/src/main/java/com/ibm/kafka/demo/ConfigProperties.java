package com.ibm.kafka.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka.producer")
public class ConfigProperties {

	private String kafkaTopic1;
	private String kafkaBrokers;
	private String kafkaUser;
	private String kafkaPassword;

	

	public String getKafkaBrokers() {
		return kafkaBrokers;
	}

	public void setKafkaBrokers(String kafkaBrokers) {
		this.kafkaBrokers = kafkaBrokers;
	}

	public String getKafkaUser() {
		return kafkaUser;
	}

	public void setKafkaUser(String kafkaUser) {
		this.kafkaUser = kafkaUser;
	}

	public String getKafkaPassword() {
		return kafkaPassword;
	}

	public void setKafkaPassword(String kafkaPassword) {
		this.kafkaPassword = kafkaPassword;
	}
	public String getKafkaTopic1() {
		return kafkaTopic1;
	}

	public void setKafkaTopic1(String kafkaTopic1) {
		this.kafkaTopic1 = kafkaTopic1;
	}

	
}
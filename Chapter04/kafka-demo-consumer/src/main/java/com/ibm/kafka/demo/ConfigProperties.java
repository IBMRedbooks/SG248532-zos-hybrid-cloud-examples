package com.ibm.kafka.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class ConfigProperties {

	private String kafkaTopic1;
	private String kafkaBrokers;
	private String kafkaUser;
	private String kafkaPassword;
	private String valueDeserializer;
	private String keyDeserializer;
	private String groupId;

	

	public String getValueDeserializer() {
		return valueDeserializer;
	}

	public void setValueDeserializer(String valueDeserializer) {
		this.valueDeserializer = valueDeserializer;
	}

	public String getKeyDeserializer() {
		return keyDeserializer;
	}

	public void setKeyDeserializer(String keyDeserializer) {
		this.keyDeserializer = keyDeserializer;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

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
/**
 * 
 */
package com.ibm.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author apatilus.ibm.com
 *
 */
@RestController
@RequestMapping(value = "/api/kafka/v1")
public class AppController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private  ConfigProperties cp;
	
	@Autowired
	private AppKafkaProducer appKafkaProducer;
	
	@RequestMapping(value = "/postEvent", method = RequestMethod.POST)
	 @ResponseBody
	public  String postMessage(String messageText) throws Exception {
		logger.debug("received input: " + messageText);
		appKafkaProducer.sendMessage(cp.getKafkaTopic1(),messageText );
		logger.debug("posted message {{ " + messageText + "}}, on topic: " + cp.getKafkaTopic1());
		return "Message posted successfully!";
		
	}
}
	
	

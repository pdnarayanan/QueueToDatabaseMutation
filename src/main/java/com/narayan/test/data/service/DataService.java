package com.narayan.test.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narayan.test.model.Employee;

/**
 * REST end-points exposed for testing 
 * 
 * @author Narayanan Durgadathan
 *
 */
@RestController
@RequestMapping("v1/data")
public class DataService {

	private static Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	@Value("${kafka.topic.name}")
	private String topicName;

	/**
	 * Publish the provided message to a kafka topic
	 * ONLY FOR TESTING
	 * @param emp
	 * @return
	 */
	@PostMapping
	@RequestMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestBody Employee emp) {

		try {
			kafkaTemplate.send(topicName, emp);

			return ResponseEntity.status(HttpStatus.OK).body("Succefully published the message to Kafka topic");
		} catch (Exception e) {
			logger.error("Unable to publish message ", e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Unable to publish the message to Kafka topic");

	}
}

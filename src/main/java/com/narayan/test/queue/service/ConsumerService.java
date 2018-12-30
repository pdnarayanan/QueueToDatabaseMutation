package com.narayan.test.queue.service;

import java.time.Duration;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narayan.test.data.dao.EmployeeDAO;
import com.narayan.test.model.Employee;

import kafka.utils.ShutdownableThread;

@Component
public class ConsumerService extends ShutdownableThread {

	@Autowired
	private Consumer<Long, String> kafkaConsumer;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	@Value("${kafka.error_topic.name}")
	private String errorTopicName;

	private static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

	public ConsumerService() {

		super("ConsumerService", false);
		logger.info("Starting consumer");
	}

	@Override
	public void doWork() {
		final ConsumerRecords<Long, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(500));

		for (ConsumerRecord<Long, String> record : consumerRecords) {
			logger.info(" Offset:" + record.offset() + ", key:" + record.key());

			String value = record.value();
			Employee employee = null;

			try {
				logger.info("\nValue:" + value + "\n");
				employee = mapper.readValue(value, Employee.class);
				employeeDAO.saveOrUpdate(employee);
		
			} catch (Exception e) {
				logger.error("Error inserialize the message ", e);
				if (employee != null) {
					// Publish the error messages to error topic
					kafkaTemplate.send(errorTopicName, employee);
				}	
			}
		}
	}

}

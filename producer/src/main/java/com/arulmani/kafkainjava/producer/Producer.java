package com.arulmani.kafkainjava.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/*
 * STEPS TO CREATE A KAFKA PRODUCER:
 * 		1. Create producer properties
 * 		2. Create the producer
 * 		3. Create a producer record
 * 		4. Send the data.
 */


public class Producer {

	public static void main(String[] args) {
		//1. Create producer properties
		String bootstrapServer = "localhost:9092";
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		//2. Create the producer
		KafkaProducer<String,String> firstProducer = new KafkaProducer<String,String>(properties);
		
		//3. Create a producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("my_first","Hi Im Arulmani");   
		//my_first is the topic to which the record (Hi Im Arulmani) need to be published 
		
		//4. Send the data
		firstProducer.send(record);
		firstProducer.flush();
		firstProducer.close();
		
	}

	/*
	 *
#To create a topic in kafka (my_first)
kafka-topics.bat -zookeeper localhost:2181 -topic my_first --create --partitions 1 --replication-factor 1


#To start kafka from the kafka folder
zookeeper-server-start.bat config\zookeeper.properties
kafka-server-start.bat config\server.properties

#To get the output from producer
kafka-console-consumer -bootstrap-server localhost:9092 -topic my_first -group first_app
	 */
}

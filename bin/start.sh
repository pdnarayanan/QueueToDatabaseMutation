#!/usr/bin/env bash

## starts Zookeper - for Kafka 
nohup kafka_2.12-2.1.0/bin/zookeeper-server-start.sh -daemon kafka_2.12-2.1.0/config/zookeeper.properties & 


### starts Kafka node 1
nohup kafka_2.12-2.1.0/bin/kafka-server-start.sh -daemon kafka_2.12-2.1.0/config/server-1.properties &

### starts Kafka node 2
nohup kafka_2.12-2.1.0/bin/kafka-server-start.sh -daemon kafka_2.12-2.1.0/config/server-2.properties &

### starts Kafka node 3
nohup kafka_2.12-2.1.0/bin/kafka-server-start.sh -daemon kafka_2.12-2.1.0/config/server-3.properties &

### sleep 2 seond
sleep 4 

### create topic
#kafka_2.12-2.1.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 2 --partitions 1 --topic database-queue &

### create error topic
#kafka_2.12-2.1.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 2 --partitions 1 --topic database-error_queue &




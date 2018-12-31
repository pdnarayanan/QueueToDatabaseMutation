#Queue-To-DB-Update 
A service, which consumes messages ( employee data in JSON serialized form)  from a Kafka topic and it inserts/updates the data in to a database (Sqlite DB) 

### Technologie used
- Kafka 2.12
- Sqlite Database
- Java 8
- Spring boot

###Features
- The service (Spring-boot app) reads messages from a topic "database-queue" ( can be configured) and it upserts to a "employee" database ( currently it contains only one table).
- If the update fails, the data will published to a error topic "database_error_queue" ( can be configured).
- A startup script ('bin/start.sh') will starts the Kafka cluster ( 3 node), ZooKeeper and also creates the topics.
- A REST endpoint ("v1/data/publish') is exposed for publish a message (employee data in JSON form) to kafka topic ( this end-point is ONLY FOR TESTING).


### Start the app and test
- start infrastructure ( kafka and ZooKeeper), `./start,sh`
- start application, `mvn clean spring-boot:run`
- Test (Publuish a mesasage) using REST endpoint
```javascript
curl -X POST \
  http://localhost:8080/v1/queue/employees \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d75fec9a-3b29-0e87-9afd-0f996e4f3e13' \
  -d '{"firstName":"Narayanan","lastName":"Durgadathan","address1":"4012", "address2":"Tryon PL","city":"Dublin","state":"CA", "zip":"94568","email":"nzrayasnasn.pd@gmail.com" }'
````
- Test ( publish message ) using Kafka client.
```javascript
cd bin/kafka_2.12-2.1.0
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic database-queue
```
- Verify in Sqlite Database
```javascript
cd bin/sqllite/
sqlite3 ../../employee.db
SELECT * FROM employee;
```

### TODOs

- Containerize the application using Docker 
- Externalize the Database configuration to support different database.
- Use JPA repository for DOA 
package tech.sabs.kafka.producers

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object MySimpleProducer extends App {

  val props = new Properties()

  val serializer = "org.apache.kafka.common.serialization.StringSerializer"

  props.put("bootstrap.servers","localhost:9092")
  props.put("key.serializer", serializer)
  props.put("value.serializer", serializer)

  val producer = new KafkaProducer[String, String](props)
  val TOPIC = "test"

  println("Start --- Producer")

  for(i <-1 to 50){
    val record = new ProducerRecord(TOPIC, "key", s"Hello $i")
    producer.send(record)
  }

  val record = new ProducerRecord(TOPIC, "key", "end of the record " + new java.util.Date)
  producer.send(record)

  producer.close()

  println("End --- Producer")

}

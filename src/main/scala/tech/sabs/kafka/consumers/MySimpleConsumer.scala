package tech.sabs.kafka.consumers

import java.util.Properties
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConverters._

object MySimpleConsumer extends App{
  val TOPIC = "test"

  val props = new Properties()

  val deserializer = "org.apache.kafka.common.serialization.StringDeserializer"
  props.put("bootstrap.servers","localhost:9092")

  props.put("key.deserializer", deserializer)
  props.put("value.deserializer", deserializer)
  props.put("group.id","something")

  val consumer = new KafkaConsumer[String, String](props)

  println("Start --- Consumer")
  consumer.subscribe(util.Collections.singletonList(TOPIC))

  while(true){
    val records = consumer.poll(100)
    for(record <- records.asScala){
      println(record)
    }
  }

  println("End --- Consumer")
}

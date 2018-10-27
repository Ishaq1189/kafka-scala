package tech.sabs.kafka.consumers

import java.util.Collections

import tech.sabs.kafka.utils.KafkaUtilities

import scala.collection.JavaConverters._

object MySimpleConsumer {

  def main(args: Array[String]): Unit = {
    val TOPIC = "test"

    val consumer = KafkaUtilities.createKafkaConsumer

    println("Start --- Consumer")
    consumer.subscribe(Collections.singletonList(TOPIC))

    while (true) {
      val records = consumer.poll(100)
      for (record <- records.asScala) {
        println(record)
      }
    }

    println("End --- Consumer")
  }
}

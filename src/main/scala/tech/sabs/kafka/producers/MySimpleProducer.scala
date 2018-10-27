package tech.sabs.kafka.producers

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import tech.sabs.kafka.utils.KafkaUtilities

object MySimpleProducer {

  def main(args: Array[String]): Unit = {
    val producer = KafkaUtilities.createKafkaProducer(args(0))

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
}

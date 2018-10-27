package tech.sabs.kafka.utils

import java.util.Properties

import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig}

object KafkaUtilities {
  def createKafkaProducer(configPath: String): KafkaProducer[String, String] = {

    val props = new Properties()
    val conf = ConfigFactory.load()
    val envProps = conf.getConfig(configPath)

    val serializer = "org.apache.kafka.common.serialization.StringSerializer"

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getString("bootstrap.server"))
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer)

    new KafkaProducer[String, String](props)
  }

  def createKafkaConsumer: KafkaConsumer[String, String] = {

    val deserializer = "org.apache.kafka.common.serialization.StringDeserializer"

    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")

    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializer)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "something1")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

    new KafkaConsumer[String, String](props)
  }

  def createTopicIntoKafka(topic: String, numPartitions: Int, replicationFactor: Int): Unit = {

    val zookeeperConnect = "localhost:2181"
    val sessionTimeoutMs = 10 * 1000;
    val connectionTimeoutMs = 8 * 1000;
  }
}

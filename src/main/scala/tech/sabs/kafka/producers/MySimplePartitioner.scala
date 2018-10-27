package tech.sabs.kafka.producers

import java.util

import kafka.utils.VerifiableProperties
import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.Cluster

class MySimplePartitioner(props: VerifiableProperties) extends Partitioner{
  override def partition(topic: String, key: Any, keyBytes: Array[Byte],
                         value: Any, valueBytes: Array[Byte], cluster: Cluster): Int = ???

  override def close(): Unit = ???

  override def configure(configs: util.Map[String, _]): Unit = ???
}

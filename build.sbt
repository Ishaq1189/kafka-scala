name := "mykafkaproject"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.0.0",
  "org.apache.kafka" % "kafka-clients" % "2.0.0"
)
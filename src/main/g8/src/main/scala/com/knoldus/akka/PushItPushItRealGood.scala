package com.knoldus.akka

object PushItPushItRealGood extends AkkaStreamJob(ActorSystem("Salt-N-Pepa")) {

  private val esHosts = config.getString("elasticsearch.host")
  private val esRestPort = config.getInt("elasticsearch.restport")
  private val esIndex: String = config.getString("elasticsearch.index.default")

  def main(args: Array[String]): Unit = {
    CreateIndex.run()
    val backend = new Backend(esIndex, esHosts, esRestPort)
    backend.run()
  }
}

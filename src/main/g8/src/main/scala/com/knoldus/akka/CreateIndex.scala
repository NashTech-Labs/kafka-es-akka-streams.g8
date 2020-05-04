package com.knoldus.akka

import com.knoldus.elasticsearch.api.Elasticsearch
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext}
object CreateIndex {

  private val config: Config = ConfigFactory.load()

  private val esHosts = config.getString("elasticsearch.host")

  private val esHostsList = esHosts.split(",")
  private val esIndex = config.getString("elasticsearch.index.default")

  implicit val ec: ExecutionContext = ExecutionContext.global

  def run(): Unit = {
    val es = new Elasticsearch(esHostsList)
    val indexCreated = es.createIndexWithType(esIndex)
     Await.result(indexCreated, 2.minutes)

  }
}

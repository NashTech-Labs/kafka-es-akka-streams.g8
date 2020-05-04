package com.knoldus.common

import scala.concurrent.ExecutionContextExecutor

trait AkkaStreamJobTrait extends HasLog {
  private lazy val materializerSettings = ActorMaterializerSettings(actorSystem).withSupervisionStrategy(decider)
  val config: Config = ConfigFactory.load()

  implicit val actorSystem: ActorSystem
  val decider: Supervision.Decider = { e =>
    log.error(s"Akka Stream encounted an error: ${e.getMessage}. The stream will be stopped.", e)
    Supervision.Stop
  }
  implicit lazy val streamMaterializer: ActorMaterializer = ActorMaterializer(materializerSettings)
  implicit lazy val executionContext: ExecutionContextExecutor = actorSystem.dispatcher

  def main(args: Array[String]): Unit
}

abstract class AkkaStreamJob(as: ActorSystem) extends AkkaStreamJobTrait {
  override implicit val actorSystem: ActorSystem = as
}
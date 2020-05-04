package com.knoldus.akka

class Backend(esIndex: String,
              esHosts: String, esRestPort: Int)(
               override implicit val actorSystem: ActorSystem,
               implicit val actorMaterializer: ActorMaterializer,
               implicit val dff: DeserializationFlowFactory = DeserializationFlowFactory.Synchronous)
  extends DataFlowToES(esIndex, esHosts, esRestPort) {

  private val writeEmployeeToEs = writeDataFlowToES("emp", Employee)
  private val writeCompanyToEs = writeDataFlowToES("comp", Company)

  def run(): Unit = {
    topicAndFlow(writeEmployeeToEs)
    topicAndFlow(writeCompanyToEs)
  }
}

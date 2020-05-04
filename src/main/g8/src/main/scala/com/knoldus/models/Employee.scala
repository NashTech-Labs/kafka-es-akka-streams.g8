package com.knoldus.models

case class Address(no: String,
                   area: String,
                   city: String,
                   state: String
                  )

object Address {
  implicit val format: Format[Address] = Json.format[Address]
}

case class Employee(empId: String,
                    name: String,
                    address: Address,
                    doj: String,
                    email: String,
                    mobileNo: Long,
                    designation: String,
                    salary: Int)

object Employee extends ResourceCompanion[Employee] with HasDefaultConfig {
  implicit val format: Format[Employee] = Json.format[Employee]

  implicit val _reads = Json.reads[Employee]

  implicit val defaultWrites = Json.writes[Employee]

  override lazy val index: String = config.getString("elasticsearch.index.default")
  override val resourceType: String = "employee-type"

  override def id(obj: Employee): String = obj.empId

  override def docType: String = resourceType

}
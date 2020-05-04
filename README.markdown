A [Giter8][g8] template for demonstrating how akka-streams can be used to publish the data from Kafka to ES.

#kafka-es-akka-streams
In this kafka to elasticsearch pipeline I have used akka-stream. 

For this you should have:
 1. Elasticsearch-1.7.6
    You can download this from here https://www.elastic.co/downloads/past-releases#elasticsearch
 2. Kafka
    You can download this from here https://kafka.apache.org/downloads.html

To run this:

 1. Clone the repository by
     ``sbt new knoldus/kafka-es-akka-streams.g8``
 2. Run the following on different terminals:
     a. Kafka
       - Start Zookeper
       - Start kafka server
       - Create 2 topics emp and comp
       - Start producer for both the topics
       - For emp topic, the data sent should be in following format : {"empId":"1111","name":"Neha","address":{"no":"111-E","area":"sec-9","city":"Kailash Nagar","state":"Delhi"}, "doj:"29.05.2018","email":"neha@gmail.com","mobileNo":678434,"designation":"Software Consultant","salary":30000}
       - For comp topic, the data sent should be in following format : {"regNo":"127G09","name":"Knoldus","address":{"no":"L-11","area":"NSEZ","city":"Noida","state":"Uttar Pradesh","pincode":"200189"},"email":"info.knoldus@gmail.com","phoneNo":729822389,"ceo":"Vikas","revenue":2181912}
     b. Elasticsearch: run the command ''bin/elasticsearch''
 3. Go into the project folder
 4. Run following commands one after another : `sbt` `clean` `compile` `run`

For looking the data on ES, hit following 
- http://localhost:9200/test-test/employee-type/_search?pretty=true 
- http://localhost:9200/test-test/company-type/_search?pretty=true

Template license
----------------
Written in 2020 by Muskan Gupta

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
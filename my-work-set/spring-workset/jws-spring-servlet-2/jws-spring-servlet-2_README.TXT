
This is simple project using jws and spring for supporting one endpoint. Setup is sample for exporting servlet based service(webservice) 


The webservice is spring maintained bean exposed using WSSpringServlet (RI from JAX-WS). The webservice is delegating call to other spring managed bean pojo service.


Ref:
https://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-spring-integration-example/
https://jax-ws-commons.java.net/spring/
Spring reference document - 4.4.3

Mistake-learnt
1) In Webseservice impl class method that are not part of the actual service should be properly annoted to the exclude. Ended up with error jaxb error 


2) xbean-spring is the lib to use learn
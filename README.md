**Update:** Now building a war archive containing a webapp directory.

spring-boot-example-wicket
==========================

This project builds and runs a minimal wicket web application.

Implemented:
* fat war starting a tomcat server
* wicket web application as spring boot starting point
* using ServletContextInitializer instead of web.xml
* spring wiring into wicket web pages
* SpringBootServletInitializer used for optional deployment on application server

##Notable classes

###WicketWebApplication

The Wicket Web Application class is a spring bean triggering the spring boot configuration and start up by using the @EnableAutoConfiguration annotation and providing the main class.

###WebInitializer

This class replaces the web.xml by using spring boot's ServletContextInitializer that is found and executed automatically on startup.

It's code is equivalent to the following web.xml part:
```xml
<filter>
  <filter-name>wicket-filter</filter-name>
	<filter-class>org.apache.wicket.protocol.http.WicketFilter</filter-class>
    <init-param>
        <param-name>applicationFactoryClassName</param-name>
        <param-value>org.apache.wicket.spring.SpringWebApplicationFactory</param-value>
    </init-param>
    <init-param>
        <param-name>applicationBean</param-name>
        <param-value>wicketWebApplication</param-value>
    </init-param>
</filter>
 
<filter-mapping>
	<filter-name>wicket-filter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```
###WarInitializer

This class is used when being deployed on an application server. In this scontext it has the functionality of the Application's main method. 

## Running / Deployment

Building the project provides two war archives. One is a fully featured spring boot runnable war, the other having the suffix original is a standard war archive ans can be deployed directly on an application server.

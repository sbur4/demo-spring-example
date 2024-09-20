package org.example;

import org.example.service.MyService;
import org.example.service.MyXmlService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringDemoApplication {
    public static void main(String[] args) {
        // Create the Spring application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoApplication.class);

        // Obtain a bean by its class type and call a method
        MyService service = context.getBean(MyService.class);
        service.execute();

        // Load the Spring context from XML
        ClassPathXmlApplicationContext contextXml = new ClassPathXmlApplicationContext("appContext.xml");
        MyXmlService xmlService = contextXml.getBean("xmlService", MyXmlService.class);
        xmlService.execute();

        // Close the context
        context.close();
        contextXml.close();
    }
}
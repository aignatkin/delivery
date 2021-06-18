package ru.aignatkin.delivery.mapper;

public class DeliveryPointMapperNew {
    // Can't delete as..

//    2021-06-18 13:07:57.843  WARN 3956 --- [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [ru.aignatkin.delivery.DeliveryApplication]; nested exception is java.io.FileNotFoundException: class path resource [ru/aignatkin/delivery/mapper/DeliveryPointMapperNew.class] cannot be opened because it does not exist
//2021-06-18 13:07:57.882 ERROR 3956 --- [           main] o.s.boot.SpringApplication               : Application run failed
//
//    org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [ru.aignatkin.delivery.DeliveryApplication]; nested exception is java.io.FileNotFoundException: class path resource [ru/aignatkin/delivery/mapper/DeliveryPointMapperNew.class] cannot be opened because it does not exist
//    at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:189) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:331) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:247) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:311) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:112) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:746) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:564) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:144) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:771) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:763) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:438) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:339) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1329) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1318) ~[spring-boot-2.4.6.jar:2.4.6]
//    at ru.aignatkin.delivery.DeliveryApplication.main(DeliveryApplication.java:12) ~[classes/:na]
//    Caused by: java.io.FileNotFoundException: class path resource [ru/aignatkin/delivery/mapper/DeliveryPointMapperNew.class] cannot be opened because it does not exist
//    at org.springframework.core.io.ClassPathResource.getInputStream(ClassPathResource.java:187) ~[spring-core-5.3.7.jar:5.3.7]
//    at org.springframework.core.type.classreading.SimpleMetadataReader.getClassReader(SimpleMetadataReader.java:55) ~[spring-core-5.3.7.jar:5.3.7]
//    at org.springframework.core.type.classreading.SimpleMetadataReader.<init>(SimpleMetadataReader.java:49) ~[spring-core-5.3.7.jar:5.3.7]
//    at org.springframework.core.type.classreading.SimpleMetadataReaderFactory.getMetadataReader(SimpleMetadataReaderFactory.java:103) ~[spring-core-5.3.7.jar:5.3.7]
//    at org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory.createMetadataReader(ConcurrentReferenceCachingMetadataReaderFactory.java:86) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory.getMetadataReader(ConcurrentReferenceCachingMetadataReaderFactory.java:73) ~[spring-boot-2.4.6.jar:2.4.6]
//    at org.springframework.core.type.classreading.SimpleMetadataReaderFactory.getMetadataReader(SimpleMetadataReaderFactory.java:81) ~[spring-core-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.asSourceClass(ConfigurationClassParser.java:696) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser$SourceClass.getSuperClass(ConfigurationClassParser.java:1010) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.doProcessConfigurationClass(ConfigurationClassParser.java:341) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.processConfigurationClass(ConfigurationClassParser.java:250) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:199) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.doProcessConfigurationClass(ConfigurationClassParser.java:304) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.processConfigurationClass(ConfigurationClassParser.java:250) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:207) ~[spring-context-5.3.7.jar:5.3.7]
//    at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:175) ~[spring-context-5.3.7.jar:5.3.7]
//            ... 14 common frames omitted

}

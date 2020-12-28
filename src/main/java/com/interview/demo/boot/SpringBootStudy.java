package com.interview.demo.boot;

/**
 * SpringBoot 启动原理
 */
public class SpringBootStudy {

    /**
     * 1. SpringBootApplication
     *      子注解为
     *      1. SpringBootConfiguration  被标注的类等于在spring的XML配置文件中(applicationContext.xml)，装配所有bean事务，提供了一个spring的上下文环境
     *      2. EnableAutoConfiguration  SpringBoot根据应用所声明的依赖来对Spring框架进行自动配置
     *      3. ComponentScan    组件扫描，可自动发现和装配Bean，默认扫描SpringApplication的run方法里的PengApplication.class所在的包路径下文件，所以最好将该启动类放到根包路径下
     */
    /**
     * 2. SpringBoot
     *      自动配置
     *      通过run 方法 注解的 EnableAutoConfiguration 找到 pom文件的
     *      springboot的自动装配就是通过自定义实现ImportSelector接口，
     *      从而导致项目启动时会自动将所有项目META-INF/spring.factories路径下的配置类注入到spring容器中，从而实现了自动装配。
     */
    /**
     * 3. SpringBoot
     *      启动原理
     */

}

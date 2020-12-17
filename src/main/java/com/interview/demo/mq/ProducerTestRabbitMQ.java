package com.interview.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerTestRabbitMQ {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";

    public static void oneByOne() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(ConsumerTestRabbitMQ.IP_ADDRESS);
        connectionFactory.setPort(ConsumerTestRabbitMQ.PORT);
        connectionFactory.setUsername(ConsumerTestRabbitMQ.MQ_USER_NAME);
        connectionFactory.setPassword(ConsumerTestRabbitMQ.MQ_USER_PWD);
        Connection connection = connectionFactory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 创建一个type="direct"、持久化的、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 将交换器和队列通过路由绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        // 发送一条持久化的消息：hello world!
        String message = "hello,world!";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        // 关闭资源
        channel.close();
        connection.close();

    }

    public static void main(String[] args) throws IOException, TimeoutException {
        oneByOne();
    }
}

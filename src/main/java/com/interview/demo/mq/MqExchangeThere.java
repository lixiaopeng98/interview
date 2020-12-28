package com.interview.demo.mq;

/**
 * rabbitMQ 的 Exchange模式
 * fanout(广播),
 * direct(指定),
 * topic(主题)
 */
public class MqExchangeThere {
    /**
     * 1. fanout 广播  交换机（Exchange）里的消息发送给所有绑定该交换机的队列，忽略routingKey。
     * 2. direct 指定  生产者和消费者，具有相同的交换机名称（Exchange）、交换机类型和相同的密匙（routingKey），那么消费者即可成功获取到消息。
     *                （PS：相对比只要交换机名称即可接收到消息的广播模式（fanout），direct模式在其基础上，多加了一层密码限制
     * 3. topic 主题  routing_key 不能随便设置 a.b.c  消费者 可以 *.b.* / a.*.* / *.*.c / a.b.#
     *               关于绑定键有两种特殊的情况：*（星号）可以代替一个任意标识符 ；#（井号）可以代替零个或多个标识符。
     */


    /**
     * broker
     * queue
     * exchange
     *
     */

    /**
     * 死信是啥东西
     */
}

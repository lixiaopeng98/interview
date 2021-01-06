package com.interview.demo.redis.releaseandsub;

/**
 * @describe: redis 发布 与 订阅
 * @author: lxp
 * @date: 2021/1/6 14:32
 */
public class ReleaseAndSub {

    /**
     * 命令
     *
     * 订阅某个频道
     * PUBSCRIBE "news.it"
     *
     * 向 news.it 频道 发送 hello 消息
     * PUBLISH "news.it" "hello"
     *
     */

    /**
     * 1. 服务器状态在 pubsub_channels 字典保存了所有频道的订阅关系：
     *      SUBSCRIBE命令负责将客户端和被订阅的频道关联到这个字典里面，
     *      UNSUBSCRIBE命令则负责接触客户端和被退订频道之间的关联
     * 2. 服务器状态在pubsub_patterns 链表保存了所有模式的订阅关系:
     *      PSUBSCRIBE 命令负责将客户端和被订阅的模式记录到这个链表中
     *      PUNSUBSCRIBE 命令则负责移除客户端和被退订模式在链表中的记录
     * 3. PUBLISH 命令通过访问 pubsub_channels 字典来向频道的所有订阅者发送消息，
     *      通过访问pubsub_channels 链表来向所有匹配频道的模式的订阅者发送消息
     * 4. PUBSUB 命令的三个子命令都是通过读取 pubsub_channels 字典和 pubsub_patterns
     *      链表中的信息来实现的
     */

}

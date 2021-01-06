package com.interview.demo.redis.cluster;

/**
 * @describe: redis 集群 消息
 * @author: lxp
 * @date: 2021/1/5 18:14
 */
public class RedisClusterMsg {

    /**
     * 集群中的各个节点通过发送和接收消息来进行通信
     * 我们称发送消息的节点为发送者 sender
     * 接收消息的节点为接收者 receiver
     *
     * 1. MEET 消息: 加入集群的命令
     * 2. PING 消息: 检测节点是否在线，更新节点信息
     * 3. PONG 消息: 正确回复 MEET和 PING 消息，
     *              向集群中的节点更新自己的信息，比如故障转移后 需要更新节点信息
     * 4. FAIL 消息: 如果 节点A 判断 另外一个节点B 进入FAIL时，节点A 会向集群广播一条
     *               关于节点B的FAIL 消息，所有收到这条消息的节点都会立即将节点B标记为已下线
     * 5. PUBLISH 消息: 当节点接收到一个PUBLISH命令时，节点会执行这个命令，并向集群广播一条
     *              PUBLISH消息，所有接收到这条PUBLISH消息的节点都会执行相同的PUBLISH命令
     */

    /**
     *
     *
     */

}

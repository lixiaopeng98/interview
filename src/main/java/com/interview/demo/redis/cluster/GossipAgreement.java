package com.interview.demo.redis.cluster;

/**
 * @describe: redis 通信 Gossip 协议
 * @author: lxp
 * @date: 2021/1/6 10:31
 */
public class GossipAgreement {

    /**
     * redis 每个节点通过gossip 协议来交换各自关于不同节点的状态信息，其中gossip协议有MEET、
     * PING、PONG三种消息实现
     */


    /**
     * 节点通过消息头的type属性来判断一条消息时MEET消息、PING消息还是PONG消息
     * 每次发送消息时，发送者都是从自己的已知节点列表中随机选出两个节点，并将这两个节点的信息分别
     * 保存到gossip里面，gossip结构 记录了节点的 名字，发送者与被选中节点最后一次发送和接收ping和pong
     * 消息的时间戳，被选中节点的ip地址和端口号，以及被选中节点的标识值；
     */

    /**
     * 1. 节点A向节点D发送PING消息，并且消息里面包含了节点B和节点C的信息，当节点D收到这条PING消息时，它将
     *      更新自己对节点B和节点C的认识
     * 2. 之后，节点D将向节点A返回一条PONG消息，并且消息里面包含了节点E和节点F的消息，当节点A收到这条PONG
     *      消息，它将更新自己对节点E和节点F的认识，
     */
}

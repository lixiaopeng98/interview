package com.interview.demo.http.tcp;

import java.net.Socket;

/**
 * @describe: tcp 详解
 * @author: lxp
 * @date: 2021/1/7 14:29
 */
public class TcpAnnotation {

    /**
     * tcp 的 三次握手协议
     *
     * 第一次握手：建立连接时，客户端发送syn包（syn=j）到服务器，并进入syn_send状态，等待服务器确认
     *              syn：同步序列编号（Synchronize Sequence Numbers）
     * 第二次握手：服务器收到syn包，必须确认客户的syn（ack=j+1）,同时自己也发送一个syn包，即syn+ack包，
     *          此时服务器进入syn_recv状态
     * 第三次握手：客户端收到服务器的syn_ack包，向服务器发送确认包ack(ack=k+1),此包发送完毕，
     *          客户端和服务器进入established状态，完成三次握手。
     *
     * a与b建立tcp连接时：首先a向b发syn（同步请求），然后b回复syn+ack（同步请求应答），最后a回复ack确认，
     * 这样tcp的一次连接（三次握手）的过程就建立了
     *
     */
    /**
     *
     * 还有个 四次挥手 这个是断开连接时的处理
     * 比较重要的问题是 为什么是四次挥手 而不是三次 五次的
     */
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Socket socket = new Socket();

    }

}

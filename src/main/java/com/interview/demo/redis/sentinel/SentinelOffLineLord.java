package com.interview.demo.redis.sentinel;

/**
 * @describe: 哨兵 主观下线
 * @author: lxp
 * @date: 2021/1/5 10:18
 */
public class SentinelOffLineLord {

    /**
     * 哨兵 会默认每间隔1秒 会向所有与他创建了命令连接的实例 发送ping命令，并根据 返回的数据进行判断实例是否在线：
     *
     * 1. 有效回复： +PONG -LOADING -MASTERDOWN
     * 2. 无效回复：除了1中 三个命令以外的命令，或者在指定时限内没有回复
     *
     * sentinel 配置文件中 down-after-milliseconds 用来判断实例进入主观下线所需的时间长度
     * 如果一个实例在 down-after-milliseconds 毫秒内，连续向sentinel返回无效回复，哨兵会打开 SRI_S_DOWN 标识，
     * 以此来标识这个实例已经进入主观下线状态
     *
     */
    /**
     *
     */

}

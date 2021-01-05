package com.interview.demo.redis.sentinel;

/**
 * @describe: 哨兵 客观下线
 * @author: lxp
 * @date: 2021/1/5 10:21
 */
public class SentinelOffLineCustomer {

    /**
     * 当哨兵 将一个主服务器判断为主观下线后，为了确保这个主服务器是否真的下线，它会向同样监视这一主服务器的其他
     * 哨兵进行询问，看它们是否也认为主服务器已经进入了下线状态（可以是主观下线或者客观下线），当哨兵1 从其他哨兵
     * 哪里接收到足够数量的已下线判断之后，哨兵就会将从服务器判定为客观下线，并对主服务器执行故障转移操作
     */

    /**
     * 主观下线后 判断 客观下线
     * 1. 哨兵询问其他哨兵是否同意主服务器已下线 sentinel is-master-down-by-addr <ip> <port> <current_epoch> <runid>
     * 2. 接收 的哨兵 会根据命令 中的参数 检查服务器是否已下线 然后会回复
     *              <down_state> <leader_runid> <leader_epoch>
     *              1下线 0未下线
     * 3. 接收 sentinel is-master-down-by-addr 命令 根据回复的数据，统计同意主服务器下线的数量，当这一数量达到配置指定的判断客观下线
     *  所需数量的时候，sentinel会将主服务器实例结构flags属性的SRI_O_DOWN标识打开，标识主服务器已经进入客观下线状态
     * 4. 选举领头sentinel
     *      算法 可以看 #{link https://v.youku.com/v_show/id_XNjQxOTk5MTk2.html}
     * 5. 故障转移
     *      1. 在已下线主服务器属下的所有从服务器里面，挑选出一个从服务器，并将其转换为主服务器
     *      2. 让已下线主服务器属下的所有从服务器改为复制新的主服务器
     *      3. 将已下线主服务器设置为新的主服务器的从服务器，当这个旧的主服务器重新上线时，它就会成为新的主服务器的从服务器。
     */

    /**
     * 故障转移
     * 1. 选出新的主服务器
     *      把所有从服务器保存到一个列表里面，按照规则一项一项过滤：
     *      1. 删除处于下线或者断线
     *      2. 删除最近五秒内没有回复过领头哨兵的info命令的从服务器
     *      3. 删除 已于 下线出服务器连接断开超过 down-after-milliseconds * 10 毫秒的从服务器
     *          确保从服务器保存的数据 都是比较 最先新的
     *      4. 如果此时还确定不了 会根据偏移量 对从服务器进行排序 选出偏移量最大的 从服务器
     *          确保从服务器保存的数据 都是比较 最新的
     *      5. 如果此时还确定不了 会根据允许id 排序 取最小的一个从服务器 为主服务器、
     *      6. 领头哨兵 通过 info 命令 来判断从服务器是否从  从服务器成功转换成主服务器
     * 2. 修改从服务器的复制目标
     *      可以用 slaveof 命令 来实现
     * 3. 将旧的主服务器变为从服务器
     *      领头哨兵 会在 旧的主服务器上线时，向他发送slaveof命令 让它成为新的主服务器的从服务器
     */

















}

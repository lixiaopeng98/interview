package com.interview.demo.redis;

public class TransactionRedis {

    /**
     * Redis 事务
     *
     * Redis 通过 MULTI、EXEC、WATCH 等命令来实现事务(transaction)功能。事务提供了一种将多个命令请求打包，
     * 然后一次性、按顺序地执行多个命令的机制，并且在事务执行期间，服务器不会中断事务而改去执行其他客户端的命令请求，
     * 它会将事务中的所有命令都执行完毕，然后才去处理其他客户端的命令请求。在传统的关系式数据库中，常常用 ACID 性质来检验事务功能的可靠性和安全性。
     * 在 Redis 中，事务总是具有原子性（Atomicity)、一致性(Consistency)和隔离性（Isolation），
     * 并且当 Redis 运行在某种特定的持久化模式下时，事务也具有持久性（Durability）
     */

}

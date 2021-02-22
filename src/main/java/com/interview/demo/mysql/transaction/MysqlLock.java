package com.interview.demo.mysql.transaction;

/**
 * @describe: mysql 的 lock
 * @author: lxp
 * @date: 2021/2/4 20:09
 */
public class MysqlLock {


    /**
     * 由事务的四种隔离级别引申出 几种 场景 脏读、不可重复读、幻读
     * 然后又根据隔离级别 解决 以上场景 从而 引申出 mysql的锁
     */
    /**
     * ##### mysql 的 锁
     *
     * 1. 意向锁
     *      innodb的意向锁主要用在，用户多粒度的锁并存的情况。比如事务A要在一个表上加S锁，如果表中的一行已被事务B加了X锁，
     *      那么该锁的申请也应被阻塞。如果表中的数据很多，逐行检查锁标志的开销将很大，系统的性能将会受到影响。为了解决这个问题，
     *      可以在表级上引入新的锁类型来表示其所属行的加锁情况，这就引出了“意向锁”的概念。
     *      说白了意向锁的主要作用是处理行锁和表锁之间的矛盾，能够显示“某个事务正在某一行上持有了锁，或者准备去持有锁”
     * 2. 共享锁 语法:lock in share mode / 读锁
     *      1.允许其它事务也可以增加共享锁读取
     *      2.不允许其它事物增加排他锁 (for update)
     *      3.当事务同时增加了共享锁的时候，事务的更新必须 等待 先执行更新的事务 commit 后才行，如果同时并发太大可能很容易造成死锁
     * 3. 排他锁 语法: for update / 写锁
     *      1.事务之间不允许其它排他锁或共享锁读取，修改更不可能
     *      2.一次只能有一个排他锁执行 commit 之后，其它事务才可执行
     *
     * 4. Record lock/记录锁
     *      单条索引记录上加锁，record lock锁住的永远是索引，而非记录本身，即使该表上没有任何索引，那么innodb会在后台创建一个隐藏的聚集主键索引，
     *      那么锁住的就是这个隐藏的聚集主键索引。所以说当一条sql没有走任何索引时，那么将会在每一条聚集索引后面加X锁，这个类似于表锁，但原理上和表锁应该是完全不同的。
     * 5. Gap lock/解决rr以上的 幻读问题
     *      在索引记录之间的间隙中加锁，或者是在某一条索引记录之前或者之后加锁，并不包括该索引记录本身。
     *      gap lock的机制主要是解决可重复读模式下的幻读问题.
     * 6. Next-Key Locks
     *      Next-Key locks = Record lock + Gap lock
     *      在默认情况下，mysql的事务隔离级别是可重复读，并且innodb_locks_unsafe_for_binlog参数为0，这时默认采用next-key locks。所谓Next-Key Locks，
     *      就是Record lock和gap lock的结合，即除了锁住记录本身，还要再锁住索引之间的间隙
     */

    /**
     * ##### 死锁
     *
     * 死锁 是指两个 或者多个事务在同一资源上相互占用，并请求锁定对方占用的资源，从而导致恶性循环的现象。当多个事务试图以不同的顺序锁定资源时，
     * 就可能会产生死锁，多个事务同事锁定同一个资源时，也会产生死锁。
     *
     * mysql 解决死锁的问题
     * 1. 死锁检测
     * 2. 死锁超时机制
     * 3. innoDB 的 处理方法是 将持有最少行级排它锁的事务进行回滚
     */
}
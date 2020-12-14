package com.interview.demo.mybatis;

public class MybatisDoc {

    /**
     * mybatis 的二级缓存
     *
     * 1. mybatis 的一级缓存 是基于 sqlSession
     *      第一次发出一个查询sql，sql 查询结果写入sqlsession 的一级缓存中，缓存使用的数据结构是一个map。
     *      key：MapperID+offset+limit+Sql+所有的入参
     *      value：用户信息
     *      同一个sqlsession 再次发出相同的sql，就从缓存中取出数据。如果两次中间出现commit 操作
     *      （修改、添加、删除），本sqlsession 中的一级缓存区域全部清空，下次再去缓存中查询不到所
     *      以要从数据库查询，从数据库查询到再写入缓存。
     * 2. mybatis 的二级缓存 是基于 mapper namespace
     *      二级缓存的范围是mapper 级别（mapper 同一个命名空间），mapper 以命名空间为单位创建缓
     *      存数据结构，结构是map。mybatis 的二级缓存是通过CacheExecutor 实现的。CacheExecutor
     *      其实是Executor 的代理对象。所有的查询操作，在CacheExecutor 中都会先匹配缓存中是否存
     *      在，不存在则查询数据库。
     *
     */
    public void a(){

    }

}

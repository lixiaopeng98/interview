package com.interview.demo.mysql;

/**
 * mysql 的聚集索引
 *
 */
public class MysqlClusteredIndex {


    /**
     *
     *
     *  [主键索引]: 一张表只有一个主键索引，不允许重复，不允许为null。
     *  [唯一索引]: 一张表可以有多个唯一索引，不允许重复，允许为null。
     *  [普通索引]: 基本的索引类型，允许数据重复，允许为null。
     *  [前缀索引]: 前缀索引用于字符串类型，取文本的前几个字符创建索引。
     *  [全文索引]: 一般用于大文本数据检索，是当前搜索引擎中使用的关键技术。
     *  以上索引中，除了主键索引外，其他四种索引统称为二级索引。
     */
    public static void testIndex(){

        

    }
}

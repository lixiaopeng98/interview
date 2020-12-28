package com.interview.demo.mysql;

/**
 * explain 详解
 */
public class ExplainStudy {

    /**
     * explain
     *
     * id:每个select子句的标识id
     * select_type:select语句的类型
     * table: 当前表名
     * type: 当前表内访问方式
     * possible_keys: 可能使用到的索引
     * key: 经过优化器评估最终使用的索引
     * key_length: 使用到的索引长度
     * ref: 引用到的上一个表的列
     * rows: rows_examined，要得到最终记录索要扫描经过的记录数
     * filtered: 表示存储引擎返回的数据在server层过滤后，剩下多少满足查询的记录数量的比例，注意是百分比，不是具体记录数。
     * Extra: 额外的信息说明
     */
    /**
     * type
     * ALL: 全表扫描
     * index: 索引全扫描
     * range:索引范围扫描
     * ref: 使用非唯一索引扫描
     * eq_ref: 使用唯一索引扫描
     * const: system:单表中最多只有一个匹配行
     * null: 一个值（比如说：select 1）
     */
    /**
     * Extra
     */
    public static void explainStudy(){

    }
}

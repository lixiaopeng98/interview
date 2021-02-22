package com.interview.demo.mysql.transaction;

/**
 * mysql 的 隔离级别
 * @author lxp
 */
public class GeLiLevel {

    /**
     * +----------+----------+
     * +
     * +
     * +
     */
    public void updateGeLiLevel(){
//        事务隔离级别	                脏读	    不可重复读	幻读
//        RU读未提交（read-uncommitted）	是	        是	    是
//        RC不可重复读（read-committed） 	否	        是	    是
//        RR可重复读（repeatable-read）	否	        否	    是       mysql默认
//        串行化（serializable）	        否	        否	    否

    }

}

package com.pd.tcc.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Sofa rpc tcc transaction application.
 *
 * @author zhangsen
 */
@SpringBootApplication
public class TccBusinessApp {

    public static void main(String[] args)  {
        SpringApplication.run(TccBusinessApp.class, args);
    }

//    private void transactionCommitDemo() throws InterruptedException {
//        String txId = tccTransactionService.doTransactionCommit();
//        System.out.println(txId);
//        Assert.isTrue(StringUtils.isNotBlank(txId), "事务开启失败");
//
//        System.out.println("transaction commit demo finish.");
//    }
//
//    private void transactionRollbackDemo() throws InterruptedException {
//        Map map = new HashMap(16);
//        try {
//            tccTransactionService.doTransactionRollback(map);
//            Assert.isTrue(false, "分布式事务未回滚");
//        } catch (Throwable t) {
//            Assert.isTrue(true, "分布式事务异常回滚");
//        }
//        String txId = (String)map.get("xid");
//
//        System.out.println("transaction rollback demo finish.");
//    }
}


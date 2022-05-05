package com.pd.tcc.samples.service;

import com.pd.tcc.samples.action.DeductTccAction;
import com.pd.tcc.samples.action.AddTccAction;
import io.seata.core.context.RootContext;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Tcc transaction service.
 *
 * @author zhangsen
 */
@Service
public class TccTransactionService {

    @Reference(version = "1.0")
    private DeductTccAction deductTccAction;
    @Reference(version = "1.0")
    private AddTccAction addTccAction;

    /**
     * Sets tcc action one.
     *
     * @param deductTccAction the tcc action one
     */
    public void setDeductTccAction(DeductTccAction deductTccAction) {
        this.deductTccAction = deductTccAction;
    }

    /**
     * Sets tcc action two.
     *
     * @param addTccAction the tcc action two
     */
    public void setAddTccAction(AddTccAction addTccAction) {
        this.addTccAction = addTccAction;
    }

    /**
     * 发起分布式事务
     *
     * @return string string
     */
    @GlobalTransactional
    public boolean doTransfer(int fromUid,int toUid,double amount) {
        //第一个TCC 事务参与者
        System.out.println(RootContext.getXID());
        boolean result = deductTccAction.prepare(null, fromUid,amount);
        if (!result) {
            throw new RuntimeException("deductTccAction failed.");
        }
        result = addTccAction.prepare(null, toUid, amount);
        if (!result) {
            throw new RuntimeException("addTccAction failed.");
        }
        return true;
    }

    /**
     * 分布式事务回滚
     * @param fromUid
     * @param toUid
     * @param amount
     * @return
     */
    @GlobalTransactional
    public String doTransactionRollback(int fromUid,int toUid,double amount) {
        //第一个TCC 事务参与者
        System.out.println(RootContext.getXID());
        boolean result = deductTccAction.prepare(null, fromUid,amount);
        if (!result) {
            throw new RuntimeException("TccActionOne failed.");
        }
        result = addTccAction.prepare(null, toUid, amount);
        if (!result) {
            throw new RuntimeException("TccActionTwo failed.");
        }
        throw new RuntimeException("transacton rollback");
    }

    /**
     * rpc 调用测试
     */
    public void rpcTest() {
        addTccAction.prepare(null,1,20);
    }
}

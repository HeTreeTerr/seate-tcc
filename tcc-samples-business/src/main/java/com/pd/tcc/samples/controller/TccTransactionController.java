package com.pd.tcc.samples.controller;

import com.pd.tcc.samples.service.TccTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TccTransactionController {

    @Autowired
    private TccTransactionService tccTransactionService;

    /**
     * dubbo 远程调用测试
     */
    @GetMapping(value = "/rpc-test")
    public String rpcTest(){
        tccTransactionService.rpcTest();
        return "success";
    }

    /**
     * tcc 测试
     */
    @GetMapping(value = "/tansfer")
    public String tcc() {
        tccTransactionService.doTransfer(1,2,1000);
        return "success";
    }

    @GetMapping(value = "/rollback")
    public String tccRollback() {
        tccTransactionService.doTransactionRollback(1,2,1000);
        return "fail";
    }
}

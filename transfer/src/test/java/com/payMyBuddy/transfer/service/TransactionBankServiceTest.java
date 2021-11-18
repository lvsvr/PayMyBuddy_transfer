package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionBankServiceTest {

    @Autowired
    private TransactionBankService underTest;

    @Test
    public void itShouldAddATransactionBank(){
//        WHEN
        TransactionBank tb = new TransactionBank();

//        THEN
        assertEquals(underTest.addTransaction(tb).toString(), tb.toString());

    }

}
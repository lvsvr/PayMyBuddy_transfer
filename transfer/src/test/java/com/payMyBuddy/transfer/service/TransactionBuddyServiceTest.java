package com.payMyBuddy.transfer.service;

import com.payMyBuddy.transfer.model.TransactionBuddy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TransactionBuddyServiceTest {

    @Autowired
    private TransactionBuddyService underTest;

    @Test
    public void itShouldAddATransactionBuddy(){
//        WHEN
        TransactionBuddy tb = new TransactionBuddy();

//        THEN
        assertEquals(underTest.addTransaction(tb).toString(), tb.toString());
        assertNotNull(underTest.getAllTransactions());
    }
}
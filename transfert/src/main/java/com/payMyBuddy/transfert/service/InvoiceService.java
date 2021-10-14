package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.Invoice;
import com.payMyBuddy.transfert.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Iterable<Invoice> getAllInvoices(){
      return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id){
      return invoiceRepository.findById(id);
    }

    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Long id){
        invoiceRepository.deleteById(id);
    }
}

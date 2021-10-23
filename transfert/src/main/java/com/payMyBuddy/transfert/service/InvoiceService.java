package com.payMyBuddy.transfert.service;

import com.payMyBuddy.transfert.model.Invoice;
import com.payMyBuddy.transfert.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Iterable<Invoice> getAllInvoices(){
      return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id){
      return invoiceRepository.findById(id);
    }

    public Invoice addInvoice(Invoice invoice){

        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Long id){
        invoiceRepository.deleteById(id);
    }
}

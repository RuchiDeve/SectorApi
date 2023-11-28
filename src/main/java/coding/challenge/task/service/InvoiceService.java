package coding.challenge.task.service;

import coding.challenge.task.model.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);
    Invoice getInvoiceById(Long id);
    List<Invoice> getAllInvoices();
    Invoice updateInvoice(Long id, Invoice updatedInvoice);
    void deleteInvoice(Long id);
}

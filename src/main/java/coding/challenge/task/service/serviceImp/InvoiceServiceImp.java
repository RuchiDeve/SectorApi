package coding.challenge.task.service.serviceImp;

import coding.challenge.task.model.Invoice;
import coding.challenge.task.repository.InvoiceRepository;
import coding.challenge.task.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice createInvoice(Invoice invoice)
    {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).get();
    }
    @Override
    public List<Invoice> getAllInvoices() {

        return invoiceRepository.findAll();
    }
    @Override
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElse(null);
        if (existingInvoice != null) {
            return invoiceRepository.save(updatedInvoice);
        }
        return null;
    }
    @Override
    public void deleteInvoice(Long id) {

        invoiceRepository.deleteById(id);
    }
}

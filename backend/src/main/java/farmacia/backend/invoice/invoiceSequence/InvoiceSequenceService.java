package farmacia.backend.invoice.invoiceSequence;

import org.springframework.stereotype.Service;

@Service
public class InvoiceSequenceService {

    public Long getSequence(){
        return (long)1;
    }
    
}

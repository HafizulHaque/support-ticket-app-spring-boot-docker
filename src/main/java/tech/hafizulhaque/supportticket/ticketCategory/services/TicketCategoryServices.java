package tech.hafizulhaque.supportticket.ticketCategory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hafizulhaque.supportticket.ticketCategory.repository.TicketCategoryRepository;

@Service
public class TicketCategoryServices {

    private final TicketCategoryRepository ticketCategoryRepository;

    @Autowired
    public TicketCategoryServices(TicketCategoryRepository ticketCategoryRepository){
        this.ticketCategoryRepository = ticketCategoryRepository;
    }
}

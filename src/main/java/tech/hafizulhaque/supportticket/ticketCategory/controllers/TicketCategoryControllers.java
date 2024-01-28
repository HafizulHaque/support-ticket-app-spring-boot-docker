package tech.hafizulhaque.supportticket.ticketCategory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.hafizulhaque.supportticket.ticketCategory.services.TicketCategoryServices;

@RestController
@RequestMapping("/api/v1/ticket-categories")
public class TicketCategoryControllers {

    private final TicketCategoryServices ticketCategoryServices;

    @Autowired
    public TicketCategoryControllers(TicketCategoryServices ticketCategoryServices){
        this.ticketCategoryServices = ticketCategoryServices;
    }

    @GetMapping()
    public String getAllTicketCategories(){
        return "all ticket categories list";
    }

    @GetMapping("/{categoryId}")
    public String getTicketCategoryById(@PathVariable Long categoryId){
        return "single ticket category by id " + categoryId;
    }

    @PostMapping()
    public String createTicketCategory(){
        return "created a single category";
    }

    @PutMapping("/{categoryId}")
    public String updateTicketCategory(@PathVariable Long categoryId){
        return "updated a single category by id " + categoryId;
    }

    @DeleteMapping("/{categoryId}")
    public String deleteTicketCategory(@PathVariable Long categoryId){
        return "deleted a single category by id " + categoryId;
    }
}

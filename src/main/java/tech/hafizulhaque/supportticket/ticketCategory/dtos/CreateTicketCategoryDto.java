package tech.hafizulhaque.supportticket.ticketCategory.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.hafizulhaque.supportticket.models.TicketCategoryEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketCategoryDto {

    private String title;
    private String description;

    public TicketCategoryEntity toTicketCategoryEntity(){
        TicketCategoryEntity ticketCategoryEntity = new TicketCategoryEntity();
        ticketCategoryEntity.setTitle(this.title);
        ticketCategoryEntity.setDescription(this.description);
        return ticketCategoryEntity;
    }
}

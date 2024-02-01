package tech.hafizulhaque.supportticket.ticketCategory.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.hafizulhaque.supportticket.models.TicketCategoryEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategoryResponseDto {

    private Long id;
    private String title;
    private String description;

    public static TicketCategoryResponseDto createFrom(TicketCategoryEntity ticketCategoryEntity){
        TicketCategoryResponseDto ticketCategoryResponseDto = new TicketCategoryResponseDto();
        ticketCategoryResponseDto.setId(ticketCategoryEntity.getId());
        ticketCategoryResponseDto.setTitle(ticketCategoryEntity.getTitle());
        ticketCategoryResponseDto.setDescription(ticketCategoryEntity.getDescription());
        return ticketCategoryResponseDto;
    }

}

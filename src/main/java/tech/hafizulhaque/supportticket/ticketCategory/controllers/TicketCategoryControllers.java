package tech.hafizulhaque.supportticket.ticketCategory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hafizulhaque.supportticket.models.TicketCategoryEntity;
import tech.hafizulhaque.supportticket.ticketCategory.dtos.TicketCategoryRequestDto;
import tech.hafizulhaque.supportticket.ticketCategory.dtos.TicketCategoryResponseDto;
import tech.hafizulhaque.supportticket.ticketCategory.services.TicketCategoryServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tickets/categories")
public class TicketCategoryControllers {

    private final TicketCategoryServices ticketCategoryServices;

    @Autowired
    public TicketCategoryControllers(TicketCategoryServices ticketCategoryServices){
        this.ticketCategoryServices = ticketCategoryServices;
    }

//    CREATE A NEW CATEGORY
    @PostMapping()
    public ResponseEntity<TicketCategoryResponseDto> createTicketCategory(@RequestBody(required = true) TicketCategoryRequestDto ticketCategoryRequestDto){
        TicketCategoryEntity response = ticketCategoryServices.createTicketCategory(ticketCategoryRequestDto);
        TicketCategoryResponseDto responseDto = TicketCategoryResponseDto.createFrom(response);
        return ResponseEntity.ok(responseDto);
    }

//    GET ALL CATEGORY LIST
    @GetMapping()
    public ResponseEntity<List<TicketCategoryResponseDto>> getAllTicketCategories(){
        List<TicketCategoryEntity> response = ticketCategoryServices.getAllTicketCategories();
        List<TicketCategoryResponseDto> responseDtos = response.stream()
                .map(entity -> TicketCategoryResponseDto.createFrom(entity))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

//    GET A CATEGORY BY ID
    @GetMapping("/{categoryId}")
    public ResponseEntity<TicketCategoryResponseDto> getTicketCategoryById(@PathVariable Long categoryId){
        TicketCategoryEntity response = ticketCategoryServices.getTicketById(categoryId);
        TicketCategoryResponseDto responseDto = response != null ? TicketCategoryResponseDto.createFrom(response) : null;
        return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

//    UPDATE A CATEGORY BY ID
    @PutMapping("/{categoryId}")
    public ResponseEntity<TicketCategoryResponseDto> updateTicketCategory(
            @PathVariable Long categoryId,
            @RequestBody(required = true) TicketCategoryRequestDto ticketCategoryRequestDto)
    {
        TicketCategoryEntity response = ticketCategoryServices.updateTicketCategoryById(categoryId, ticketCategoryRequestDto);
        TicketCategoryResponseDto responseDto = response != null ? TicketCategoryResponseDto.createFrom(response) : null;
        return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<TicketCategoryResponseDto> deleteTicketCategory(@PathVariable Long categoryId){
        TicketCategoryEntity response = ticketCategoryServices.deleteTicketCategoryById(categoryId);
        TicketCategoryResponseDto responseDto = response != null ? TicketCategoryResponseDto.createFrom(response) : null;
        return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

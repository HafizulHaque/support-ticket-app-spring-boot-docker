package tech.hafizulhaque.supportticket.ticketCategory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hafizulhaque.supportticket.models.TicketCategoryEntity;
import tech.hafizulhaque.supportticket.ticketCategory.dtos.TicketCategoryRequestDto;
import tech.hafizulhaque.supportticket.ticketCategory.repository.TicketCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketCategoryServices {

    private final TicketCategoryRepository ticketCategoryRepository;

    @Autowired
    public TicketCategoryServices(TicketCategoryRepository ticketCategoryRepository){
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    public TicketCategoryEntity createTicketCategory(TicketCategoryRequestDto ticketCategoryRequestDto) {
        TicketCategoryEntity ticketCategoryEntity = ticketCategoryRequestDto.toTicketCategoryEntity();
        return ticketCategoryRepository.save(ticketCategoryEntity);
    }

    public List<TicketCategoryEntity> getAllTicketCategories() {
        return ticketCategoryRepository.findAll();
    }

    public TicketCategoryEntity getTicketById(Long categoryId) {
        Optional<TicketCategoryEntity> ticketCategoryEntity = ticketCategoryRepository.findById(categoryId);
        if(ticketCategoryEntity.isPresent()){
            return ticketCategoryEntity.get();
        }else{
            return null;
        }
    }

    public TicketCategoryEntity updateTicketCategoryById(Long categoryId, TicketCategoryRequestDto ticketCategoryRequestDto){
        Optional<TicketCategoryEntity> categoryToUpdate = ticketCategoryRepository.findById(categoryId);
        if(categoryToUpdate.isPresent()){
            TicketCategoryEntity ticketCategoryEntity = categoryToUpdate.get();
            ticketCategoryEntity.setTitle(ticketCategoryRequestDto.getTitle());
            ticketCategoryEntity.setDescription(ticketCategoryRequestDto.getDescription());
            return ticketCategoryRepository.save(ticketCategoryEntity);
        }else{
            return null;
        }
    }

    public TicketCategoryEntity deleteTicketCategoryById(Long categoryId) {
        Optional<TicketCategoryEntity> categoryToDelete = ticketCategoryRepository.findById(categoryId);
        if(categoryToDelete.isPresent()){
            ticketCategoryRepository.delete(categoryToDelete.get());
            return categoryToDelete.get();
        }else {
            return null;
        }
    }
}

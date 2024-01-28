package tech.hafizulhaque.supportticket.ticketCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hafizulhaque.supportticket.models.TicketCategoryEntity;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategoryEntity, Long> {
}

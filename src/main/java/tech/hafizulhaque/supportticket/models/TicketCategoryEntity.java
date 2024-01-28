package tech.hafizulhaque.supportticket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ticket_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "ticketCategory")
    private List<TicketEntity> tickets;
}

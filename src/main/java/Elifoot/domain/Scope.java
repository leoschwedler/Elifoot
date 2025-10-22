package Elifoot.domain;


import jakarta.persistence.*;
import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scopes")
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scopes_seq")
    @SequenceGenerator(name = "scopes_seq", sequenceName = "scopes_seq", allocationSize = 1)
    private Long id;
    private String name;
}
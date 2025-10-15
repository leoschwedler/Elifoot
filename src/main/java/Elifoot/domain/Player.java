package Elifoot.domain;

import Elifoot.enums.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(name = "shirt_number")
    private Integer shirtNumber;
    @Column(name = "url_img")
    private String urlImg;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}

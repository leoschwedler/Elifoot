package Elifoot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq")
    @SequenceGenerator(name = "club_seq", sequenceName = "club_seq", allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate founded;
    @Column(name = "url_img")
    private String urlImg;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private Boolean active;
    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;
    @OneToMany(mappedBy = "club")
    private List<Player> players;
}

package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickname;

    private String email;

    private String password;

    private int wins;

    private int averageWins;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<Game> games;

    public void addWin(){
        wins++;
    }
}

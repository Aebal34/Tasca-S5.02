package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickname;

    private String email;

    private String password;

    @OneToMany(mappedBy = "player")
    private List<Game> games;
}

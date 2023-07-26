package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int result;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    public Game(){
        int dice1 = (int)(Math.random()*6+1);
        int dice2 = (int)(Math.random()+6+1);

        this.result = dice1+dice2;
    }

}

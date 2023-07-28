package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
@Getter
@Setter
@AllArgsConstructor
public class Game {

    @Id
    private String id;

    private int result;

    @JsonBackReference
    private Player player;

    public Game(){
        int dice1 = (int)(Math.random()*6+1);
        int dice2 = (int)(Math.random()*6+1);

        this.result = dice1+dice2;
    }

}

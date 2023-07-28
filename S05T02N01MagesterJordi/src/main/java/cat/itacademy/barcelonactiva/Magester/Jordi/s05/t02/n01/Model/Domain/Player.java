package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    private String id;

    private String nickname;

    private String email;

    private String password;

    private int wins;

    private int averageWins;

    @JsonManagedReference
    private List<Game> games = new ArrayList<>();

    public void addWin(){
        wins++;
    }
}

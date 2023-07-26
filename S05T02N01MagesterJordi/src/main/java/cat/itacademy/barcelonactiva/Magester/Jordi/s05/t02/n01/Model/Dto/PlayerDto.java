package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import lombok.Data;

import java.util.List;

@Data
public class PlayerDto {

    private int id;

    private String nickname;

    private String email;

    private String password;

    private List<Game> games;

    public PlayerDto(String nickname, String email, String password){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
    }
}

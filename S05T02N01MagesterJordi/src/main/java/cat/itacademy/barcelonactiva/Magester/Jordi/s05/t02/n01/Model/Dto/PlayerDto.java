package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PlayerDto {

    private String id;

    private String nickname;

    private String email;

    private String password;

    private int averageWins;

    public PlayerDto(String nickname, String email, String password){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
    }
}

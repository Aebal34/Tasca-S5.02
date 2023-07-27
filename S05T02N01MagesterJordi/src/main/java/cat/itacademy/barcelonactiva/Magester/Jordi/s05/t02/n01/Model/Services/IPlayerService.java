package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import org.springframework.http.ResponseEntity;

public interface IPlayerService {

    ResponseEntity<Player> createPlayer(PlayerDto playerDto);

    ResponseEntity<Player> editPlayerNickname(int id, String nickname);

    ResponseEntity<Player> playDiceRoll(int id, Game game);

    ResponseEntity<Player> getPlayerById(int id);
}

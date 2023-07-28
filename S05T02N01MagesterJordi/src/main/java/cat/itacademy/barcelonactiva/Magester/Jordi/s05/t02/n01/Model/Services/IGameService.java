package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.GameDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGameService {

    ResponseEntity<Game> rollDice(Player player);

    ResponseEntity<String> deleteGamesFromPlayer(Player player);

    ResponseEntity<List<GameDto>> getGamesFromPlayer(Player player);
}

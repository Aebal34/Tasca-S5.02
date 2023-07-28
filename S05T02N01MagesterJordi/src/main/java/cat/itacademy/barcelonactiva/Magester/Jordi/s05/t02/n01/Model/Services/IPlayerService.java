package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.GameDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPlayerService {

    ResponseEntity<Player> createPlayer(PlayerDto playerDto);

    ResponseEntity<Player> editPlayerNickname(String id, String nickname);

    ResponseEntity<Player> playDiceRoll(String id, Game game);

    ResponseEntity<Player> getPlayerById(String id);

    ResponseEntity<PlayerDto> deleteGamesFromPlayer(String id);

    ResponseEntity<List<PlayerDto>> getAllPlayersAverage();

    ResponseEntity<List<Integer>> getAllAverageResults();

    ResponseEntity<PlayerDto> getBestPlayer();

    ResponseEntity<PlayerDto> getWorstPlayer();
}

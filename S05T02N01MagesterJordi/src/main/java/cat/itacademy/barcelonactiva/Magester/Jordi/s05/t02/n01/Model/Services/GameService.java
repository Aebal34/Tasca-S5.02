package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService{

    @Autowired
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }


    @Override
    public ResponseEntity<Game> rollDice(Player player) {
        Game game = new Game();
        game.setPlayer(player);
        gameRepository.save(game);
        return ResponseEntity.ok(game);
    }

    @Override
    public ResponseEntity<String> deleteGamesFromPlayer(Player player) {
        List<Game> games = gameRepository.getByPlayer(player);

        gameRepository.deleteAll(games);
        return ResponseEntity.ok("Games deleted successfully.");
    }
}

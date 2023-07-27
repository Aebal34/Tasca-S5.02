package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.IGameService;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private final IPlayerService playerService;

    @Autowired
    private final IGameService gameService;

    public PlayerController(IPlayerService playerService, IGameService gameService){
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDto playerDto){

        return playerService.createPlayer(playerDto);
    }

    @PutMapping
    public ResponseEntity<Player> editPlayerNickname(@RequestParam int id, @RequestParam String nickname){
        return playerService.editPlayerNickname(id, nickname);
    }

    @PostMapping("/{id}/games")
    public ResponseEntity<Game> playDiceRoll(@PathVariable("id") int id){

        Player player = playerService.getPlayerById(id).getBody();
        Game game = gameService.rollDice(player).getBody();

        playerService.playDiceRoll(id, game);

        return ResponseEntity.ok(game);
    }
}

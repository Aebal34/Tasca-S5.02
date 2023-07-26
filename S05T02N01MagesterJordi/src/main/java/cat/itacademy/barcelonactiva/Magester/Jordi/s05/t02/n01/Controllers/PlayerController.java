package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    public PlayerController(IPlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDto playerDto){

        return playerService.createPlayer(playerDto);
    }

    @PutMapping
    public ResponseEntity<Player> editPlayerNickname(@RequestParam int id, @RequestParam String nickname){
        return playerService.editPlayerNickname(id, nickname);
    }

}

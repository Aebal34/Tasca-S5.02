package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.IPlayerService;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    public PlayerController(IPlayerService playerService){
        this.playerService = playerService;
    }
}

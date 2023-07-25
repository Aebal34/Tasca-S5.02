package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

}

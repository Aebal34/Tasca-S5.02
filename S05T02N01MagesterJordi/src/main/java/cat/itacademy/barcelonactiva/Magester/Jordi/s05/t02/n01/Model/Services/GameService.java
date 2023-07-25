package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService{

    @Autowired
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }


}

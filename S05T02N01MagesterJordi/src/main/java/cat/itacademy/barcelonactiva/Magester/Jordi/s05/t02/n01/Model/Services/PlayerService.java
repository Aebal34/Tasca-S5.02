package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public ResponseEntity<Player> createPlayer(PlayerDto playerDto) {

        if (playerDto != null) {

            Player player = new Player();
            player.setEmail(playerDto.getEmail());
            player.setPassword(playerDto.getPassword());
            player.setNickname(playerDto.getNickname());
            player.setGames(playerDto.getGames());
            playerRepository.save(player);
            return ResponseEntity.ok(player);

        }else{
            return ResponseEntity.badRequest().build();
        }


    }
}

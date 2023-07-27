package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService{

    @Autowired
    private final PlayerRepository playerRepository;

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

    @Override
    public ResponseEntity<Player> editPlayerNickname(int id, String nickname) {

        Player player = playerRepository.findById(id).orElse(null);
        if(player != null){
            player.setNickname(nickname);
            playerRepository.save(player);
            return ResponseEntity.ok(player);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Player> playDiceRoll(int id, Game game) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.getGames().add(game);
            playerRepository.save(player);
            return ResponseEntity.ok(player);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Player> getPlayerById(int id) {
        Player player = playerRepository.findById(id).orElse(null);
        if(player!=null){
            return ResponseEntity.ok(player);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

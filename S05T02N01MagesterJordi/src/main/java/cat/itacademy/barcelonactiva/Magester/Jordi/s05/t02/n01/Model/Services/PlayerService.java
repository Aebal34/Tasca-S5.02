package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            if(game.getResult() == 7){
                player.addWin();
            }
            player.setAverageWins((int)((double) player.getWins() /
                                                    player.getGames().size() * 100));
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

    @Override
    public ResponseEntity<PlayerDto> deleteGamesFromPlayer(int id) {
        Player player = playerRepository.findById(id).orElse(null);
        if(player != null){
            //Clear wins, average and games.
            player.getGames().clear();
            player.setWins(0);
            player.setAverageWins(0);
            playerRepository.save(player);
            //Return nickname of player whose games have been deleted
            PlayerDto playerDto = new PlayerDto();
            playerDto.setNickname(player.getNickname());
            return ResponseEntity.ok(playerDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<PlayerDto>> getAllPlayersAverage() {

        List<Player> players = playerRepository.findAll();
        List<PlayerDto> playerDtos = new ArrayList<>();

        for(Player player : players){

            PlayerDto playerDto = new PlayerDto();
            playerDto.setNickname(player.getNickname());
            playerDto.setAverageWins(player.getAverageWins());
            playerDtos.add(playerDto);
        }
        return ResponseEntity.ok(playerDtos);
    }

    @Override
    public ResponseEntity<List<Integer>> getAllAverageResults() {
        List<Integer> averageResults = new ArrayList<>();
        for(Player player : playerRepository.findAll()){
            averageResults.add(player.getAverageWins());
        }
        return ResponseEntity.ok(averageResults);
    }

    @Override
    public ResponseEntity<PlayerDto> getBestPlayer() {
        PlayerDto playerDto = new PlayerDto();
        for(Player player : playerRepository.findAll()){
            if(player.getAverageWins() > playerDto.getAverageWins()){
                playerDto.setAverageWins(player.getAverageWins());
                playerDto.setNickname(player.getNickname());
            }
        }
        return ResponseEntity.ok(playerDto);
    }

    @Override
    public ResponseEntity<PlayerDto> getWorstPlayer() {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setAverageWins(100);
        for(Player player : playerRepository.findAll()){
            if(player.getAverageWins() < playerDto.getAverageWins()){
                playerDto.setAverageWins(player.getAverageWins());
                playerDto.setNickname(player.getNickname());
            }
        }
        return ResponseEntity.ok(playerDto);
    }
}

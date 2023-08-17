package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.PlayerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void PlayerService_CreatePlayer_ReturnsSavedPlayer(){

        //Arrange
        PlayerDto playerDto = PlayerDto.builder()
                    .email("emily@mail.com")
                    .nickname("Emily123")
                    .build();
        Player player = Player.builder()
                .email("emily@mail.com")
                .nickname("Emily123")
                .build();

        //Act
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);
        Player savedPlayer = playerService.createPlayer(playerDto).getBody();

        //Assert
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getNickname()).isEqualTo(playerDto.getNickname());
    }

    @Test
    public void PlayerService_EditPlayerNickname_ReturnsModifiedPlayer(){

        //Arrange
        String nickname = "Emily123";

        Player player = Player.builder()
                .id("64c3e5c17d9af96907b99f51")
                .nickname(nickname)
                .build();

        //Act
        when(playerRepository.findById(Mockito.any(String.class))).thenReturn(Optional.ofNullable(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);
        Player modifiedPlayer = playerService.editPlayerNickname(player.getId(), "John123").getBody();

        //Assert
        assertThat(modifiedPlayer).isNotNull();
        assertThat(modifiedPlayer.getNickname()).isNotEqualTo(nickname);
    }

    @Test
    public void PlayerService_PlayDiceRoll_ReturnsPlayer(){

        //Arrange
        Player player = Player.builder()
                .id("64c3e5c17d9af96907b99f51")
                .nickname("Emily123")
                .games(new ArrayList<>())
                .build();
        Game game = new Game();

        //Act
        when(playerRepository.findById(Mockito.any(String.class))).thenReturn(Optional.ofNullable(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);

        Player rolledPlayer = playerService.playDiceRoll(player.getId(), game).getBody();

        //Assert
        assertThat(rolledPlayer).isNotNull();
        assertThat(rolledPlayer.getGames()).isNotEmpty();
        assertThat(rolledPlayer.getGames().size()).isEqualTo(1);
    }

    @Test
    public void PlayerService_DeleteGamesFromPlayer_ReturnsPlayerDto(){

        //Arrange
        List<Game> games = new ArrayList<>(List.of(new Game(), new Game(), new Game()));

        Player player = Player.builder()
                .id("64c3e5c17d9af96907b99f51")
                .nickname("Emily123")
                .games(games)
                .build();

        //Act
        when(playerRepository.findById(Mockito.any(String.class))).thenReturn(Optional.ofNullable(player));
        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(player);
        PlayerDto playerDto = playerService.deleteGamesFromPlayer(player.getId()).getBody();

        //Assert
        assertThat(playerDto).isNotNull();
        assertThat(playerDto.getNickname()).isEqualTo(player.getNickname());
        assertThat(player.getGames()).isEmpty();
    }

    @Test
    public void PlayerService_getAllPlayersAverage_ReturnsListOfPlayerDto(){

        //Arrange
        Player player1 = Player.builder()
                .nickname("Johny1")
                .id("64c3e5c17d9af96907b99f51")
                .averageWins(35)
                .games(new ArrayList<>())
                .build();
        Player player2 = Player.builder()
                .id("64c3e5c17d9af96907b99f52")
                .nickname("Johny2")
                .averageWins(60)
                .games(new ArrayList<>())
                .build();
        Player player3 = Player.builder()
                .id("64c3e5c17d9af96907b99f53")
                .nickname("Johny3")
                .averageWins(55)
                .games(new ArrayList<>())
                .build();
        List<Player> players = new ArrayList<>(List.of(player1, player2, player3));

        //Act
        when(playerRepository.findAll()).thenReturn(players);
        List<PlayerDto> playerDtos = playerService.getAllPlayersAverage().getBody();

        //Assert
        int avgWins = 0;
        assertThat(playerDtos).isNotEmpty();
        for(PlayerDto playerDto : playerDtos){
            assertThat(playerDto.getAverageWins()).isNotZero();
            avgWins += playerDto.getAverageWins();
        }
        assertThat(avgWins/playerDtos.size()).isEqualTo(50);
    }


}

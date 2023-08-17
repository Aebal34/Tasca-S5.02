package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Dto.GameDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.GameRepository;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.GameService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    @Test
    public void GameService_RollDice_ReturnsGame(){

        //Arrange
        Player player = Player.builder()
                .nickname("Mitsuki")
                .email("Mitsu29")
                .build();

        //Act
        when(gameRepository.save(Mockito.any(Game.class))).thenReturn(null);
        ResponseEntity<Game> response = gameService.rollDice(player);

        //Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPlayer()).isEqualTo(player);
    }

    @Test
    public void GameService_getGamesFromPlayer_ReturnsListOfGameDtos(){

        //Arrange
        List<Game> games = new ArrayList<>(List.of(new Game(), new Game(), new Game()));
        Player player = Player.builder()
                .nickname("Aebal")
                .email("balae@mail.com")
                .games(games)
                .build();

        //Act
        ResponseEntity<List<GameDto>> response = gameService.getGamesFromPlayer(player);

        //Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(3);
    }

    @Test
    public void GameService_deleteGamesFromPlayer_ReturnsResponseEntity(){

        //Arrange
        List<Game> games = new ArrayList<>(List.of(new Game(), new Game(), new Game()));
        Player player = Player.builder()
                .nickname("Aebal")
                .email("balae@mail.com")
                .games(games)
                .build();

        //Act
        when(gameRepository.getByPlayer(player)).thenReturn(games);
        doNothing().when(gameRepository).deleteAll(games);

        ResponseEntity<String> response = gameService.deleteGamesFromPlayer(player);

        //Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Repositories;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Game;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.GameRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

@DataMongoTest
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void GameRepository_Save_ReturnsGame(){

        //Arrange
        Game game = new Game();
        game.setPlayer(Player.builder().email("helen456@ye.com").nickname("Helen456").build());

        //Act
        Game savedGame = gameRepository.save(game);

        //Assert
        assertThat(savedGame).isNotNull();
        assertThat(savedGame.getPlayer()).isNotNull();
    }

    @Test
    public void GameRepository_DeleteAll_ReturnsEmptyList(){

        //Arrange
        Game game = new Game();
        Game game1 = new Game();
        gameRepository.save(game);
        gameRepository.save(game1);

        //Act
        gameRepository.deleteAll();
        List<Game> savedGames = gameRepository.findAll();

        //Assert
        assertThat(savedGames).isEmpty();
    }

    @Test
    public void GameRepository_GetByPlayer_ReturnsList(){

        //Arrange
        Game game = new Game();
        Game game1 = new Game();
        Player player = Player.builder().email("helen456@ye.com").nickname("Helen456").build();

        game.setPlayer(player);
        game1.setPlayer(player);
        gameRepository.save(game);
        gameRepository.save(game1);

        //Act
        List<Game> playersGames = gameRepository.getByPlayer(player);

        //Assert
        assertThat(playersGames).isNotEmpty();
        assertThat(playersGames.size()).isEqualTo(2);
    }
}

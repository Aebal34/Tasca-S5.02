package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Repositories;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataMongoTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void PlayerRepository_Save_ReturnsSavedPlayer(){

        //Arrange
        Player player = Player.builder()
                .email("john123@mail.com")
                .password("john123")
                .nickname("Johny4")
                .build();

        //Act
        Player savedPlayer = playerRepository.save(player);

        //Assert
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getId()).isNotNull();
    }

    @AfterEach
    public void removePlayer(Player player){
        playerRepository.delete(player);
    }
}

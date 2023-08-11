package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Repositories;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

@DataMongoTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    //Arrange
    Player player = Player.builder()
            .email("john123@mail.com")
            .nickname("Johny4")
            .build();

    @Test
    public void PlayerRepository_Save_ReturnsSavedPlayer(){

        //Act
        Player savedPlayer = playerRepository.save(player);

        //Assert
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getId()).isNotNull();
    }

    @Test
    public void PlayerRepository_FindById_ReturnsSavedPlayer(){

        //Act
        Player savedPlayer = playerRepository.findById("64c3e5c17d9af96907b99f51").orElse(null);

        //Assert
        assertThat(savedPlayer).isNotNull();
        assertThat(savedPlayer.getId()).isEqualTo("64c3e5c17d9af96907b99f51");
        assertThat(savedPlayer.getNickname()).isEqualTo("Helen456");
    }

}

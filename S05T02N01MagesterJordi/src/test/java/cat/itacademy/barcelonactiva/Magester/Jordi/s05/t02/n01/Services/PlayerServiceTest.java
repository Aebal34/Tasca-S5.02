package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Services;

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
}

package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByEmail(String email);
}

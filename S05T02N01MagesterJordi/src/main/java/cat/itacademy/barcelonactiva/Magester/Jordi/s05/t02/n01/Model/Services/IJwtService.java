package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface IJwtService {

    public String extractEmail(String token);

    public Claims extractAllClaims(String token);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public String generateToken(UserDetails userDetails);

    public boolean isTokenValid(String token, UserDetails userDetails);

    public boolean isTokenExpired(String token);
}

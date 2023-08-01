package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.AuthenticationRequest;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.AuthenticationResponse;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.RegisterRequest;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

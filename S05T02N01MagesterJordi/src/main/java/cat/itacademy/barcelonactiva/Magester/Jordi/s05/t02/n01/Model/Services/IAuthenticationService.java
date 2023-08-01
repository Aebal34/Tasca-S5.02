package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.AuthenticationRequest;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.AuthenticationResponse;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Auth.RegisterRequest;

public interface IAuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}

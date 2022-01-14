package teste.desenvolvedor.backend.java.santander.api.v1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteListDTO;
import teste.desenvolvedor.backend.java.santander.services.ClienteService;

@RestController
@RequestMapping(ClienteController.BASE_URL)
public class ClienteController {

    public static final String BASE_URL = "/api/v1/clientes";

    private final ClienteService clienteService;

    public ClienteController(final ClienteService pClienteService) {

	clienteService = pClienteService;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteListDTO getClientes() {

	return new ClienteListDTO(clienteService.getClientes());

    }

}

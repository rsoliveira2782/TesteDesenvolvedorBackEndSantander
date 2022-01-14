package teste.desenvolvedor.backend.java.santander.api.v1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteDTO;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO criarCliente(@RequestBody ClienteDTO pClienteDTO) {

	return clienteService.criarCliente(pClienteDTO);

    }

    @GetMapping({ "/{id}" })
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO getClienteById(@PathVariable Long id) {

	return clienteService.getClienteById(id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteListDTO getClientes(@RequestParam(defaultValue = "0") Integer pagina) {

	return new ClienteListDTO(clienteService.getClientes(pagina));

    }

}

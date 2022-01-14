package teste.desenvolvedor.backend.java.santander.api.v1.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.ClienteListDTO;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.TransacaoListDTO;
import teste.desenvolvedor.backend.java.santander.services.TransacaoService;

import java.time.LocalDate;

@RestController
@RequestMapping(TransacaoController.BASE_URL)
public class TransacaoController {

    public static final String BASE_URL = "/api/v1/transacoes";

    private final TransacaoService transacaoService;

    public TransacaoController(final TransacaoService pTransacaoService) {

	transacaoService = pTransacaoService;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TransacaoListDTO getTransacoes(final @RequestParam String tipo, final @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
		    final @RequestParam(defaultValue = "0") Integer pagina) {

	return new TransacaoListDTO(transacaoService.getTransacoesPorTipoEData(tipo, data, pagina));

    }

}

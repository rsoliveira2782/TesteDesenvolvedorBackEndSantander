package teste.desenvolvedor.backend.java.santander.services;

import org.springframework.stereotype.Service;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.TransacaoDTO;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TransacaoService extends CrudService<Transacao, Long> {

    public List<TransacaoDTO> getTransacoesPorTipoEData(final String pTipo, final LocalDate pData, final int pNumeroPagina);

}

package teste.desenvolvedor.backend.java.santander.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import teste.desenvolvedor.backend.java.santander.api.v1.dto.TransacaoDTO;
import teste.desenvolvedor.backend.java.santander.model.Transacao;

@Mapper
public interface TransacaoMapper {

    TransacaoMapper INSTANCE = Mappers.getMapper(TransacaoMapper.class);

    Transacao transacaoDtoToTransacao(final TransacaoDTO pTransacaoDTO);

    @Mapping(target = "clienteId", source = "cliente.id")
    TransacaoDTO transacaoToTransacaoDTO(final Transacao pTransacao);

}

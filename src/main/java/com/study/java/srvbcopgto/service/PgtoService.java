package com.study.java.srvbcopgto.service;

import com.study.java.srvbcopgto.Enum.StatusPgto;
import com.study.java.srvbcopgto.Model.PagamentoModel;
import com.study.java.srvbcopgto.dto.PagamentoDto;
import com.study.java.srvbcopgto.repository.PagamentoRepositoy;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PgtoService {

    private final ModelMapper modelMapper;

    private final PagamentoRepositoy repository;

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        PagamentoModel pagamento = modelMapper.map(dto, PagamentoModel.class);
        pagamento.setStatus(StatusPgto.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto obterPorId(UUID uuid) {
        PagamentoModel pagamento = repository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, PagamentoDto.class);
    }
}

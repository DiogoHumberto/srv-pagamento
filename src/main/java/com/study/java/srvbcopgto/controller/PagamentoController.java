package com.study.java.srvbcopgto.controller;

import com.study.java.srvbcopgto.dto.PagamentoDto;
import com.study.java.srvbcopgto.service.PgtoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

import static com.study.java.srvbcopgto.utils.ConstantsUltils.RAABIT_EX_PAGAMENTO;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
public class PagamentoController {

    private final PgtoService service;

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder){

        PagamentoDto respDto = service.criarPagamento(dto);

        URI url = uriBuilder.path("/pagamentos/{id}").buildAndExpand(respDto.getUuid()).toUri();

        //enviando para todas as rotas - usando fanout
        rabbitTemplate.convertAndSend(RAABIT_EX_PAGAMENTO,"", respDto);

        return ResponseEntity.created(url).body(respDto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull UUID uuid) {

        return ResponseEntity.ok(service.obterPorId(uuid));
    }

}

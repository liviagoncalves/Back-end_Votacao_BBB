package com.lgm.coding.votacaobbbapi.controller;

import com.lgm.coding.votacaobbbapi.model.ParticipanteModel;
import com.lgm.coding.votacaobbbapi.service.VotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votacao")
@AllArgsConstructor
public class VotacaoController {

    private final VotacaoService servico;

    @PostMapping
    public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante){
        servico.adicionarEvento(participante);
        return ResponseEntity.ok("Voto Computador com Sucesso");
    }
}

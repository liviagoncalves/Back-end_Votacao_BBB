package com.lgm.coding.votacaobbbms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgm.coding.votacaobbbms.model.VotacaoModel;
import com.lgm.coding.votacaobbbms.model.ParticipanteModel;
import com.lgm.coding.votacaobbbms.repository.VotacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    @KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro){
        String participanteStr = registro.value();
        log.info("Voto Recebido com Sucesso = {}", participanteStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipanteModel participante = null;

        try {
            participante = mapper.readValue(participanteStr, ParticipanteModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao Converter Voto [{}]", participante, ex);
            return;
        }

        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entity = repository.save(votacao);

        log.info("Voto Registrado com Sucesso[id={}, dataHora{}]", entity.getId(), entity.getDataHora());
    }
}

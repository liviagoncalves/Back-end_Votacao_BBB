package com.lgm.coding.votacaobbbapi.repository;

import com.lgm.coding.votacaobbbapi.model.ParticipanteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {
}

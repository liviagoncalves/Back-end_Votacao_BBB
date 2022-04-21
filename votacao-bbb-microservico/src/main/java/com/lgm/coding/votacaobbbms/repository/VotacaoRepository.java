package com.lgm.coding.votacaobbbms.repository;

import com.lgm.coding.votacaobbbms.model.VotacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {
}

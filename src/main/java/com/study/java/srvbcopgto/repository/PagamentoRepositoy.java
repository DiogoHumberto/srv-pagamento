package com.study.java.srvbcopgto.repository;

import com.study.java.srvbcopgto.model.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepositoy extends JpaRepository<PagamentoModel, UUID> {

}

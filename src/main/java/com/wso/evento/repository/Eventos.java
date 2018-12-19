package com.wso.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wso.evento.model.Evento;

public interface Eventos extends JpaRepository<Evento, Long> {

}

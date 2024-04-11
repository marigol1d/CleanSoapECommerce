package com.cleansoap.coursework.repository;

import com.cleansoap.coursework.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> { // Integer - тип данных поля идентификатора
    List<Client> findByClientEmail(String clientEmail);

}

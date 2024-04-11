package com.cleansoap.coursework.service.impl;

import com.cleansoap.coursework.exception.ClientNotFoundException;
import com.cleansoap.coursework.model.Client;
import com.cleansoap.coursework.repository.ClientRepository;
import com.cleansoap.coursework.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Получаем экземпляр репозитория, т.к. он взаимодействует с БД
    ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) { // Конструктор репозитория
        this.clientRepository = clientRepository;
    }


    @Override
    public String createClient(Client client) {
        clientRepository.save(client); // Сохранение уровня репозитория проводных данных
        return "Успешное создание";
    }

    @Override
    public String updateClient(Client client) {
        clientRepository.save(client);
        return "Успешное обновление";
    }

    @Override
    public String deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId); // Удаляем по id из БД
        return "Успешное удаление";
    }

    @Override
    public Client getClient(Integer clientId) {
        if(clientRepository.findById(clientId).isEmpty())
            throw new ClientNotFoundException("Клиента Не Существует В БД");
        return clientRepository.findById(clientId).get(); // Возвращает данные конкретного клиента
    }

    @Override
    public List<Client> getAllClients() {
        if(clientRepository.findAll().isEmpty())
            throw new ClientNotFoundException("Клиентов Не Существует В БД");
        return clientRepository.findAll();
    }
}

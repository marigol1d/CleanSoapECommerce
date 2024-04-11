package com.cleansoap.coursework.service;

import com.cleansoap.coursework.model.Client;

import java.util.List;

public interface ClientService { // Все методы бизнес-уровня
    public String createClient(Client client);
    public String updateClient(Client client);
    public String deleteClient(Integer clientId); // Удаляем по id
    public Client getClient(Integer clientId); // Получаем информацию по id
    public List<Client> getAllClients(); // Аргумент пустой, т.к. доступно всем
}

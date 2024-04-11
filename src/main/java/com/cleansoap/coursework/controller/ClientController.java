package com.cleansoap.coursework.controller;

import com.cleansoap.coursework.model.Client;
import com.cleansoap.coursework.response.ResponseHandler;
import com.cleansoap.coursework.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // для понимания, что это контроллер для Rest сервиса
@RequestMapping("/clients") // RequestMapping - запросы, обрабатываемые этим контроллером, должны начинаться с URL clients
public class ClientController { // запросы, связанные с клиентами
    ClientService clientService; // Экземпляр уровня обслуживания

    public ClientController(ClientService clientService) { // Конструктор
        this.clientService = clientService;
    }

    // Получение данных конкретного клиента из БД
    @GetMapping("{clientId}")
    public ResponseEntity<Object> getClientInformation(@PathVariable("clientId") Integer clientId){ // @PathVariable() - переменная пути
        return ResponseHandler.responseBuilder("Запрошенные Данные Приведены Выше",
                HttpStatus.OK, clientService.getClient(clientId));
    }

    // Получение данных обо всех клиентах из БД
    @GetMapping()
    public List<Client> getAllClientInformation(){ // Нет конкретного идентификатора
        return clientService.getAllClients();
    }


    @PostMapping
    public String createClient(@RequestBody Client client){ // Будем получать объект
        clientService.createClient(client);
        return "Клиент Успешно Добавлен В БД";
    }

    @PutMapping // Обновляем
    public String updateClient(@RequestBody Client client){ // Передаем в качестве тела запроса
        clientService.updateClient(client);
        return "Клиент Успешно Обновлен В БД";
    }

    @DeleteMapping("{clientId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId){ // Передаем идентификатор клиента
        clientService.deleteClient(clientId);
        return "Клиент Успешно Удален Из БД";
    }

//    @GetMapping("/")
//    public ResponseEntity getClients(){ // для того, чтобы убедиться, что сервер работает
//        try { // ok - вернет код 200
//            return ResponseEntity.ok("Сервер работает.");
//        } catch (Exception e){ // badRequest, т.е. на клиент вернется 400 статус с ошибкой
//            return ResponseEntity.badRequest().body("Произошла ошибка.");
//        }
//    }
}

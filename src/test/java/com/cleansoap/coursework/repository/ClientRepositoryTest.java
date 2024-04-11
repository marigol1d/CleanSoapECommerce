package com.cleansoap.coursework.repository;

import com.cleansoap.coursework.model.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ClientRepositoryTest {
    // given - when -then

    @Autowired // Внедряем класс
    private ClientRepository clientRepository;
    Client client;

    @BeforeEach
    void setUp() {
        client = new Client(3, "Viktoria",
                "Melesh", "375293344556",
                "client2@gmail.com", "client2",
                true, false);
        clientRepository.save(client);
    }

    // После завершения метода setUp, данные будут удалены
    @AfterEach
    void tearDown() {
        client = null;
        clientRepository.deleteAll();
    }

    // Тестовый пример SUCCESS

    @Test
    void testFindByClientEmail_Found(){
        // Поиск по email
        List<Client> clientList = clientRepository.findByClientEmail("client2@gmail.com");
        assertThat(clientList.get(0).getClientId()).isEqualTo(client.getClientId());
        assertThat(clientList.get(0).getEmail()).isEqualTo(client.getEmail());
        // Если значения совпадают, значит функция работает
    }

    // Тестовый пример FAILURE

}

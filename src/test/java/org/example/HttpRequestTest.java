package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createAddress() throws Exception {
        restTemplate.getForEntity("http://localhost:" + port + "/book/create", String.class);

        ResponseEntity<AddressBook> bookResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/book/viewtest?book=1", AddressBook.class);

        Assertions.assertEquals(1, bookResponseEntity.getBody().getId());
    }

    @Test
    public void buddyAdd() throws Exception {
        restTemplate.getForEntity("http://localhost:" + port + "/book/create", String.class);
        restTemplate.getForEntity("http://localhost:" + port +
                "/buddy/add?name=bill&address=\"2 Main\"&number=123&book=1", String.class);

        ResponseEntity<AddressBook> bookResponseEntity = restTemplate.getForEntity(
                "http://localhost:" + port + "/book/viewtest?book=1",
                AddressBook.class);

        Assertions.assertEquals(1, bookResponseEntity.getBody().getAddressBook().size());
    }
}

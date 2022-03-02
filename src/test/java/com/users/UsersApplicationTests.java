package com.users;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.users.config.Configuracion;
import com.users.model.UserResponse;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureWebTestClient(timeout = "200000")
@TestPropertySource(locations = { "classpath:application.properties" })
@DisplayName("UsersApplicationTests - Pruebas")
class UsersApplicationTests {
    
    @Autowired
    private WebTestClient webCliente;
    
    @SpyBean
    private Configuracion properties;
    
    private static final String RESPONSE_200_FILENAME = "response-200.json";
    
    private static MockWebServer mockWebServer;
    private static MockResponse mockTokenResponse;
    
    private static Object request;
    
    
    
    @BeforeAll
    static void setUpBeforeClass() throws IOException, KeyManagementException, NoSuchAlgorithmException {
        
        mockWebServer = new MockWebServer();
        mockWebServer.start(9097);
        mockTokenResponse = new MockResponse()
                .setBody(utility.getContent(RESPONSE_200_FILENAME))
                .setResponseCode(HttpStatus.OK.value())
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        
        System.out.println("users.testbody :" + utility.getContent(RESPONSE_200_FILENAME));
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        mockWebServer.shutdown();
    }
    
    @BeforeAll
    static void setup() throws SftpException, JSchException{

        ObjectMapper mapper = new ObjectMapper();

        ClassLoader classLoader = UsersApplicationTests.class.getClassLoader();

        TypeReference<Object> requestObj = new TypeReference<Object>() {
        };

        try {

            request = mapper.readValue(new File(
                    classLoader.getResource("request01.json").getFile()),
                    requestObj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void Test01Ok() {
        
        mockWebServer.enqueue(mockTokenResponse);

        WebTestClient.ResponseSpec responseSpec = webCliente.post()
                .uri(uriBuilder -> uriBuilder.path("/apiuser/v1/user")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))//
                .exchange();
        responseSpec.expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(UserResponse.class);

    }
    
}

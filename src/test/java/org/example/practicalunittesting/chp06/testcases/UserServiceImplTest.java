package org.example.practicalunittesting.chp06.testcases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService service;

    @Mock
    UserDAO userDAO;

    @Mock
    SecurityService securityService;

    @BeforeEach
    void setUp() {
        service = new UserServiceImpl(userDAO, securityService);
    }

    @Test
    public void getTest() {
        when(securityService.md5(anyString())).thenReturn("");
    }


    @AfterEach
    void tearDown() {
    }
}
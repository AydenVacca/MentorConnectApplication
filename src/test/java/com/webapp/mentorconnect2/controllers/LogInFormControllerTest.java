package com.webapp.mentorconnect2.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class LogInFormControllerTest {

    @InjectMocks
    private LogInFormController logInFormController;

    @Mock
    private AccountService accountService;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginPage() {
        String expectedViewName = "login";
        String returnedViewName = logInFormController.loginPage();
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testSuccessfulLogin() {
        String username = "testUser";
        String password = "testPassword";

        Account mockUser = new Account();
        mockUser.setUsername(username);
        mockUser.setPassword(password);
        when(accountService.findByUsername(username)).thenReturn(mockUser);

        when(session.getAttribute("username")).thenReturn(username);
        when(session.getAttribute("role")).thenReturn(mockUser.getRole());

        Model mockModel = mock(Model.class);
        String expectedViewName = "redirect:/home";
        String returnedViewName = logInFormController.login(username, password, mockModel, session);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testFailedLogin() {
        String username = "test";
        String password = "wrongPassword";

        Account mockUser = new Account();
        mockUser.setUsername(username);
        mockUser.setPassword("correctPassword");
        when(accountService.findByUsername(username)).thenReturn(mockUser);

        Model mockModel = mock(Model.class);
        String expectedViewName = "login";
        String returnedViewName = logInFormController.login(username, password, mockModel, session);
        assertEquals(expectedViewName, returnedViewName);
    }
}

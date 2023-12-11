package com.webapp.mentorconnect2.controllers;

import com.webapp.mentorconnect2.models.Account;
import com.webapp.mentorconnect2.repository.AccountService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SignUpFormControllerTest {

    @InjectMocks
    private SignUpFormController signUpFormController;

    @Mock
    private AccountService accountService;

    @Mock
    private HttpSession session;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSignupPage() {
        Model model = mock(Model.class);
        String expectedViewName = "signup";

        String returnedViewName = signUpFormController.signupPage(model);

        assertEquals(expectedViewName, returnedViewName);
        verify(model).addAttribute(eq("user"), any(Account.class));
    }

    @Test
    void testSuccessfulSignup() {
        Account user = new Account();
        user.setUsername("testUser");
        user.setEmail("testUser@ilstu.edu");
        user.setEmail("testUser@ilstu.edu");
        user.setRole("ROLE_USER");
        user.setPassword("password");

        when(accountService.save(user)).thenReturn(user);

        String expectedViewName = "redirect:/login";
        String returnedViewName = signUpFormController.signup(user, session);

        assertEquals(expectedViewName, returnedViewName);
        verify(session).setAttribute("username", user.getUsername());
        verify(session).setAttribute("role", user.getRole());
    }

    @Test
    void testInvalidEmailSignup() {
        Account user = new Account();
        user.setEmail("invalidEmail");
        user.setRole("ROLE_USER");
        user.setPassword("password");
        user.setUsername("testUser");

        String expectedViewName = "redirect:/signup?error=email";
        String returnedViewName = signUpFormController.signup(user, session);

        assertEquals(expectedViewName, returnedViewName);
    }
}

/////////////////////////////////////////////////////
//Doesn't work due to how login is currently set up//
/////////////////////////////////////////////////////

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.web.servlet.ModelAndView;

// import com.webapp.mentorconnect2.models.Account;
// import com.webapp.mentorconnect2.models.ForumPost;
// import com.webapp.mentorconnect2.repository.AccountService;
// import com.webapp.mentorconnect2.repository.ForumPostService;

// public class HomeFormControllerTest {

//     private HomeFormController homeFormController;

//     @Mock
//     private AccountService accountServiceMock;

//     @Mock
//     private ForumPostService forumPostServiceMock;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//         homeFormController = new HomeFormController();
//         homeFormController.setAccountService(accountServiceMock);
//         homeFormController.setForumPostService(forumPostServiceMock);
//     }

//     @Test
//     void testHomePage() {
//         ModelAndView modelAndView = homeFormController.homePage();
//         assertEquals("home", modelAndView.getViewName());
//     }

//     @Test
//     void testGetAllAccounts() {
//         // Mock data
//         List<Account> accounts = Arrays.asList(new Account(), new Account());
        
//         // Define mock behavior
//         when(accountServiceMock.getAllAccounts()).thenReturn(accounts);

//         // Call the method being tested
//         ModelAndView modelAndView = homeFormController.getAllAccounts();

//         // Assertions
//         assertEquals("accountList", modelAndView.getViewName());
//         assertEquals(accounts, modelAndView.getModel().get("accounts"));
//     }

//     @Test
//     void testGetForumPostById() {
//         // Mock data
//         long postId = 1L;
//         ForumPost forumPost = new ForumPost();
//         forumPost.setId(postId);
        
//         // Define mock behavior
//         when(forumPostServiceMock.getForumPostById(postId)).thenReturn(Optional.of(forumPost));

//         // Call the method being tested
//         ModelAndView modelAndView = homeFormController.getForumPost(postId);

//         // Assertions
//         assertEquals("forumPost", modelAndView.getViewName());
//         assertEquals(forumPost, modelAndView.getModel().get("forumPost"));
//     }

// }
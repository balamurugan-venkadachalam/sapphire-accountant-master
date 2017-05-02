package ae.kbgroup.spring.security.login;

import ae.kbgroup.sapphire.config.spring.SpringRootConfig;
import ae.kbgroup.sapphire.config.spring.SpringWebConfig;
import ae.kbgroup.sapphire.web.rest.UserController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.jayway.jsonpath.Predicate;


import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by geethu on 08-04-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringWebConfig.class,SpringRootConfig.class })
@WebAppConfiguration
public class LoginTest {

    private MockMvc mockMvc;

    @Autowired
    private UserController sampleRestControllerMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
// We have to reset our mock between tests because the mock objects
// are managed by the Spring container. If we would not reset them,
// stubbing and verified behavior would "leak" from one test to another.
       // Mockito.reset(sampleRestControllerMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }


    @Test
    public void testLoginService_expect_success() throws Exception {

        mockMvc.perform(get("/testJson"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", Matchers.anything()))
                .andExpect(jsonPath("$.nameEn", is("Karthik")))
                .andExpect(jsonPath("$.nameAr", is("TEST")))
                .andExpect(jsonPath("$.id", is(1)));
    }



    @Test
    public void testLoginService_expect_un_authorized_error() throws Exception {

        mockMvc.perform(get("/admin/testJson"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", Matchers.anything()))
                .andExpect(jsonPath("$.nameEn", is("Bala")))
                .andExpect(jsonPath("$.nameAr", is("TEST")))
                .andExpect(jsonPath("$.id", is(1)));
    }


}

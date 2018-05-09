package com.example.freelancerbackend;

import com.example.freelancerbackend.controller.ProjectController;
import com.example.freelancerbackend.controller.UserController;
import com.example.freelancerbackend.models.User;
import com.example.freelancerbackend.entity.Users;
import com.example.freelancerbackend.service.ProjectService;
import com.example.freelancerbackend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ContextConfiguration
@RunWith(SpringRunner.class)
@WebMvcTest(value = { UserController.class, ProjectController.class }, secure = false)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@MockBean
	private ProjectService profileService;

	public User getUser() {
		User mockUser = new User();
		mockUser.setUsername("Rohit");
		mockUser.setName("Rohit M");
		mockUser.setSkills("React,NodeJS,Redux,MySQL");
		return mockUser;
	}
	@Test
	public void userAuthenticationTest() throws Exception {

		//Mockito.when(userService.getUser(Mockito.any(User.class))).thenReturn("NOT_AVAILABLE");
		Mockito.when(userService.login(Mockito.any(Users.class))).thenReturn(getUser());

		String userJson = "{\"username\":\"Rohit\",\"password\":\"ro\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/users/authenticate")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\n" +
                "    \"username\": \"Rohit\",\n" +
                "    \"name\": \"Rohit M\",\n" +
                "    \"skills\": \"React,NodeJS,Redux,MySQL\"" +
                "}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}




    public User getNewUser() {
        User mockUser = new User();
        mockUser.setUsername("TestUsername");
        mockUser.setName("TestName");
        mockUser.setEmail("TestUsername@gmail.com");
        return mockUser;
    }
    @Test
    public void userRegisterTest() throws Exception {

        Mockito.when(userService.registerUser(Mockito.any(Users.class))).thenReturn(getNewUser());

        String userJson = "{\n" +
                "    \"username\": \"TestUsername\",\n" +
                "    \"email\": \"TestUsername@gmail.com\",\n" +
                "    \"name\": \"TestName\"" +
                "}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/users/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();



        String expected = "{\n" +
                "    \"username\": \"TestUsername\",\n" +
                "    \"email\": \"TestUsername@gmail.com\",\n" +
                "    \"name\": \"TestName\"" +
                "}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    public Users getUpdatedUser() {
        Users mockUser = new Users();
        mockUser.setUsername("TestUsername");
        mockUser.setName("TestName");
        mockUser.setPhone("123123123");
        return mockUser;
    }
    @Test
    public void updateUserPhoneTest() throws Exception {

        Mockito.when(userService.updateUserFields(Mockito.eq("TestUsername"),Mockito.any(Users.class),
                Mockito.eq("phone"))).thenReturn(getUpdatedUser());
        String userJson = "{\"phone\":\"123123123\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/updatePhone")
                .sessionAttr("username", "TestUsername")
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\n" +
                "    \"username\": \"TestUsername\",\n" +
                "    \"name\": \"TestName\",\n" +
                "    \"phone\": \"123123123\"" +
                "}\n";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }




    public Users getUpdatedSummaryUser() {
        Users mockUser = new Users();
        mockUser.setUsername("TestUsername");
        mockUser.setName("TestName");
        mockUser.setSummary("Summary");
        return mockUser;
    }
    @Test
    public void updateUserSummaryTest() throws Exception {

        Mockito.when(userService.updateUserFields(Mockito.eq("TestUsername"),
                Mockito.any(Users.class), Mockito.eq("summary"))).thenReturn(getUpdatedSummaryUser());

        String userJson = "{\"summary\":\"Summary\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/updateSummary")
                .sessionAttr("username", "TestUsername")
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\n" +
                "    \"username\": \"TestUsername\",\n" +
                "    \"name\": \"TestName\",\n" +
                "    \"summary\": \"Summary\"" +
                "}\n";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }




    public Users getUpdatedSkillsUser() {
        Users mockUser = new Users();
        mockUser.setUsername("TestUsername");
        mockUser.setName("TestName");
        mockUser.setSkills("skills");
        return mockUser;
    }
    @Test
    public void updateUserSkillsTest() throws Exception {

        Mockito.when(userService.updateUserFields(Mockito.eq("TestUsername"),
                Mockito.any(Users.class), Mockito.eq("skills"))).thenReturn(getUpdatedSkillsUser());

        String userJson = "{\"summary\":\"Summary\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/updateSkills")
                .sessionAttr("username", "TestUsername")
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\n" +
                "    \"username\": \"TestUsername\",\n" +
                "    \"name\": \"TestName\",\n" +
                "    \"skills\": \"skills\"" +
                "}\n";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}



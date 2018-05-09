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
	public void loginUserTest() throws Exception {

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




}


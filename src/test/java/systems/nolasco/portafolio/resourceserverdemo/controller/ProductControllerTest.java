package systems.nolasco.portafolio.resourceserverdemo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testPublicEndpoint() throws Exception {
		final String request = "/api/v1/products/public";

		mockMvc.perform(MockMvcRequestBuilders.get(request))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void testPrivateEndpoint() throws Exception {
		final String request = "/api/v1/products/private";

		mockMvc.perform(MockMvcRequestBuilders.get(request)
				.with(jwt())) // .jwt(j -> j.claim("", ""))))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void testPrivateScopedEndpoint() throws Exception {
		final String request = "/api/v1/products/private-scoped";

		mockMvc.perform(MockMvcRequestBuilders.get(request)
				.with(jwt())) // .jwt(j -> j.claim("", ""))))
				.andDo(print())
				.andExpect(status().isOk());
	}
}

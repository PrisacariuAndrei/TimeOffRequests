package timeOffRequests.monolith.mainApp;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MainAppApplicationTests {

	private final int PORT = 8082;

	@MockBean
	private RestTemplate restTemplate;

	@MockBean
	private ModelMapper modelMapper;

	@Test
	public void testApplicationStartup() {
		assertNotNull(new TestRestTemplate().getForObject("http://localhost:" + PORT + "/", String.class));
	}
}

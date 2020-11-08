package io.coupin.restapi.interfaces;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Common test-resource for testing interface layer (controller class)
 */
@SpringBootTest
public abstract class AbstractControllerTest {

  protected MockMvc mockMvc;

  @BeforeEach
  private void injectMockMvc() {

    // Init @Mock Objects
    MockitoAnnotations.initMocks( this );

    mockMvc = MockMvcBuilders.standaloneSetup( serveController() )
                             .addFilter( new CharacterEncodingFilter( StandardCharsets.UTF_8.name(), true ) )
                             .build();

    // Set Mocks with dummy value
    setupBeforeEach();
  }

  protected abstract Object serveController();

  protected abstract void setupBeforeEach();

}
package io.coupin.restapi.applications;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

abstract class AbstractServiceTest {

  @BeforeEach
  protected void initMocks() {

    // Init @Mock Objects
    MockitoAnnotations.initMocks( this );

    // Set Mocks with dummy value
    setupBeforeEach();
  }

  protected abstract void setupBeforeEach();
}

package com.kodekonveyor.authentication;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Data access")
@TestedService("AuthenticatedUserService")
class AuthenticatedUserServiceLoggingTest
    extends AuthenticatedUserServiceTestBase {

  @BeforeEach
  @Override
  void setUp() {
    super.setUp();
    AuthenticationStubs.authenticated();
    authenticatedUserService.call();
  }

  @Test
  @DisplayName("Logs the username based on external authentication")
  void test() {
    verify(loggerService)
        .info(
            RemoteAuthenticationFilterTestData.LOGIN,
            UserEntityTestData.LOGIN
        );
  }

}

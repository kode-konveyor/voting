package com.kodekonveyor.authentication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
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
@TestedBehaviour("Uses the userEntity to return various data")
@TestedService("RemoteAuthentication")
class RemoteAuthenticationTest extends RemoteAuthenticationTestBase {

  @DisplayName("getAuthorities returns an empty list")
  @Test
  void test() {
    assertEquals(
        UserEntityTestData.listEmpty(), remoteAuthentication.getAuthorities()
    );
  }

  @DisplayName("getCredentials returns the login name")
  @Test
  void test1() {
    assertEquals(
        UserEntityTestData.LOGIN, remoteAuthentication.getCredentials()
    );
  }

  @DisplayName("getDetails returns the user")
  @Test
  void test2() {
    assertEquals(UserEntityTestData.get(), remoteAuthentication.getDetails());
  }

  @DisplayName("the returned user has the correct id")
  @Test
  void test21() {
    assertEquals(
        UserEntityTestData.ID,
        ((UserEntity) remoteAuthentication.getDetails()).getId()
    );
  }

  @DisplayName("getPrincipal returns the login name")
  @Test
  void test3() {
    assertEquals(UserEntityTestData.LOGIN, remoteAuthentication.getPrincipal());
  }

  @DisplayName("getName returns the login name")
  @Test
  void test31() {
    assertEquals(UserEntityTestData.LOGIN, remoteAuthentication.getName());
  }

  @DisplayName("isAuthenticated returns true")
  @Test
  void test4() {
    assertThat(remoteAuthentication.isAuthenticated()).isTrue();
  }

  @DisplayName("setAuthenticated throws IllegalArgumentException")
  @Test
  void test5() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> remoteAuthentication.setAuthenticated(true)
    );
  }

}

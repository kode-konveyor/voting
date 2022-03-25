package com.kodekonveyor.init;

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

@TestedBehaviour("unimplemented")
@TestedService("GetServiceByNameService")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
class GetServiceByNameServiceUnimplementedTest
    extends GetServiceByNameServiceTestBase {

  @Test
  @DisplayName("call returns null because its not implemented yet")
  void test1() {

    Assertions.assertNull(getServiceByNameService.call(null));

  }
}

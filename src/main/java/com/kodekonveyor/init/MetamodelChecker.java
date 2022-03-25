package com.kodekonveyor.init;

import org.springframework.stereotype.Service;

import com.kodekonveyor.annotations.InterfaceClass;

@InterfaceClass
@Service
public interface MetamodelChecker {

  void call();
}

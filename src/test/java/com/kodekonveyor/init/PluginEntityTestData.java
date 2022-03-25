package com.kodekonveyor.init;

import java.util.List;

import org.mockito.Mockito;

public class PluginEntityTestData {

  public static final String SERVICE_NAME = "MetaModelCheckService";
  public static final Object SERVICE_OBJECT =
      Mockito.mock(MetamodelChecker.class);

  public static PluginEntity get() {

    final PluginEntity pluginEntity = new PluginEntity();
    pluginEntity.setMetamodelCheckServiceName(SERVICE_NAME);
    return pluginEntity;
  }

  public static Iterable<PluginEntity> list() {
    return List.of(get());
  }

}

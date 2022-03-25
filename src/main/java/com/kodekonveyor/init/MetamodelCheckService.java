package com.kodekonveyor.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetamodelCheckService {

  @Autowired
  private GetServiceByNameService getServiceByNameService;

  @Autowired
  private PluginEntityRepository pluginEntityRepository;

  public void call() {

    final Iterable<PluginEntity> pluginEntities =
        pluginEntityRepository.findAll();
    for (final PluginEntity pluginEntity : pluginEntities) {
      final String serviceName = pluginEntity.getMetamodelCheckServiceName();
      final MetamodelChecker service =
          (MetamodelChecker) getServiceByNameService.call(serviceName);
      service.call();
    }

  }

}

package com.kodekonveyor.init;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PluginEntityRepository
    extends PagingAndSortingRepository<PluginEntity, Long> {

}

package dev.pollito.device_manager.mapper;

import dev.pollito.device_manager.model.Device;
import dev.pollito.device_manager.model.Devices;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceModelMapper {
  Device map(dev.pollito.device_manager.entity.Device deviceEntity);

  Devices map(Page<dev.pollito.device_manager.entity.Device> devicePage);
}

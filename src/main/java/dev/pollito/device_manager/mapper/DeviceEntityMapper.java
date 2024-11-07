package dev.pollito.device_manager.mapper;

import dev.pollito.device_manager.entity.Device;
import dev.pollito.device_manager.model.DeviceRequestBodyRequiredProperties;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeviceEntityMapper {
  Device map(DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);
}

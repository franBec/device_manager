package dev.pollito.device_manager.service;

import dev.pollito.device_manager.model.Device;
import dev.pollito.device_manager.model.DeviceRequestBody;
import dev.pollito.device_manager.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.device_manager.model.Devices;
import org.springframework.data.domain.PageRequest;

public interface DeviceService {
  Device addDevice(DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);

  Void deleteDevice(Integer id);

  Devices getAll(PageRequest pageRequest, String brand);

  Device getDevice(Integer id);

  Device partialUpdateDevice(Integer id, DeviceRequestBody deviceRequestBody);

  Device updateDevice(
      Integer id, DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties);
}

package dev.pollito.device_manager.service.impl;

import dev.pollito.device_manager.mapper.DeviceEntityMapper;
import dev.pollito.device_manager.mapper.DeviceModelMapper;
import dev.pollito.device_manager.model.Device;
import dev.pollito.device_manager.model.DeviceRequestBody;
import dev.pollito.device_manager.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.device_manager.model.Devices;
import dev.pollito.device_manager.repository.DeviceRepository;
import dev.pollito.device_manager.service.DeviceService;
import java.util.NoSuchElementException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
  private final DeviceRepository deviceRepository;
  private final DeviceEntityMapper deviceEntityMapper;
  private final DeviceModelMapper deviceModelMapper;

  @Override
  public Device addDevice(DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties) {
    return deviceModelMapper.map(
        deviceRepository.save(deviceEntityMapper.map(deviceRequestBodyRequiredProperties)));
  }

  @Override
  public Void deleteDevice(Integer id) {
    Long idLong = Long.valueOf(id);
    if (!deviceRepository.existsById(idLong)) {
      throw new NoSuchElementException();
    }
    deviceRepository.deleteById(idLong);
    return null;
  }

  @Override
  public Devices getAll(PageRequest pageRequest, String brand) {
    return deviceModelMapper.map(
        deviceRepository.findAllByBrandContainingIgnoreCase(pageRequest, brand));
  }

  @Override
  public Device getDevice(Integer id) {
    return deviceModelMapper.map(deviceRepository.findById(Long.valueOf(id)).orElseThrow());
  }

  @Override
  public Device partialUpdateDevice(Integer id, @NotNull DeviceRequestBody deviceRequestBody) {
    dev.pollito.device_manager.entity.Device deviceEntity =
        deviceRepository.findById(Long.valueOf(id)).orElseThrow();

    if (Objects.nonNull(deviceRequestBody.getBrand()) && !deviceRequestBody.getBrand().isEmpty()) {
      deviceEntity.setBrand(deviceRequestBody.getBrand());
    }

    if (Objects.nonNull(deviceRequestBody.getName()) && !deviceRequestBody.getName().isEmpty()) {
      deviceEntity.setName(deviceRequestBody.getName());
    }

    return deviceModelMapper.map(deviceRepository.save(deviceEntity));
  }

  @Override
  public Device updateDevice(
      Integer id,
      @NotNull DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties) {
    dev.pollito.device_manager.entity.Device deviceEntity =
        deviceRepository.findById(Long.valueOf(id)).orElseThrow();

    deviceEntity.setBrand(deviceRequestBodyRequiredProperties.getBrand());
    deviceEntity.setName(deviceRequestBodyRequiredProperties.getName());
    return deviceModelMapper.map(deviceRepository.save(deviceEntity));
  }
}

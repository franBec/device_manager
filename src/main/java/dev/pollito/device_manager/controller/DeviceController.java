package dev.pollito.device_manager.controller;

import dev.pollito.device_manager.api.DeviceApi;
import dev.pollito.device_manager.model.Device;
import dev.pollito.device_manager.model.DeviceRequestBody;
import dev.pollito.device_manager.model.DeviceRequestBodyRequiredProperties;
import dev.pollito.device_manager.model.DeviceSortProperty;
import dev.pollito.device_manager.model.Devices;
import dev.pollito.device_manager.model.SortDirection;
import dev.pollito.device_manager.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeviceController implements DeviceApi {
  private final DeviceService deviceService;

  @Override
  public ResponseEntity<Device> addDevice(
      DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties) {
    return new ResponseEntity<>(
        deviceService.addDevice(deviceRequestBodyRequiredProperties), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteDevice(Integer id) {
    return new ResponseEntity<>(deviceService.deleteDevice(id), HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<Devices> getAll(
      Integer pageNumber,
      Integer pageSize,
      @NotNull DeviceSortProperty sortProperty,
      @NotNull SortDirection sortDirection,
      String brand) {
    return ResponseEntity.ok(
        deviceService.getAll(
            PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(sortDirection.getValue()),
                sortProperty.getValue()),
            brand));
  }

  @Override
  public ResponseEntity<Device> getDevice(Integer id) {
    return ResponseEntity.ok(deviceService.getDevice(id));
  }

  @Override
  public ResponseEntity<Device> partialUpdateDevice(
      Integer id, DeviceRequestBody deviceRequestBody) {
    return ResponseEntity.ok(deviceService.partialUpdateDevice(id, deviceRequestBody));
  }

  @Override
  public ResponseEntity<Device> updateDevice(
      Integer id, DeviceRequestBodyRequiredProperties deviceRequestBodyRequiredProperties) {
    return ResponseEntity.ok(deviceService.updateDevice(id, deviceRequestBodyRequiredProperties));
  }
}

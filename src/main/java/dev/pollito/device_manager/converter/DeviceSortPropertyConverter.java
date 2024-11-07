package dev.pollito.device_manager.converter;

import dev.pollito.device_manager.model.DeviceSortProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DeviceSortPropertyConverter implements Converter<String, DeviceSortProperty> {
  @Override
  public DeviceSortProperty convert(@NotNull String source) {
    return DeviceSortProperty.fromValue(source);
  }
}

package io.ghcr.heliannuuthus.devtools.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class SignatureResponse {
  private String signature;
}

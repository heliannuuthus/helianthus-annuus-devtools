package io.ghcr.heliannuuthus.devtools.crypto.parameters.rsa;

import io.ghcr.heliannuuthus.devtools.crypto.parameters.SignParameters;

public class RSAParameters extends SignParameters {
  protected RSAParameters() {
    super();
  }

  public RSAParameters(byte[] key, boolean isPrivate) {
    super(key, isPrivate);
  }

  public RSAParameters(byte[] privateKey, byte[] publicKey) {
    super(privateKey, publicKey);
  }

  @Override
  public String getName() {
    return RSA_ALGORITHM;
  }
}

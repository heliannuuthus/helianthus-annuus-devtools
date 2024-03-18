package io.ghcr.heliannuuthus.devtools.provider;

import io.ghcr.heliannuuthus.devtools.exception.CryptoException;
import javax.crypto.KeyGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SymmetricKeyProvider {

  public byte[] generate(KeyGenParameters parameters) {
    try {
      KeyGenerator keyGenerator =
          KeyGenerator.getInstance(parameters.getName(), BouncyCastleProvider.PROVIDER_NAME);
      keyGenerator.init(parameters.getSize());
      return keyGenerator.generateKey().getEncoded();
    } catch (Exception e) {
      throw new CryptoException(CryptoException.INIT_MODE, parameters.getName(), e);
    }
  }
}

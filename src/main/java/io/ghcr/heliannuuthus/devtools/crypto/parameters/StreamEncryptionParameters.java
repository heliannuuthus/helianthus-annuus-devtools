package io.ghcr.heliannuuthus.devtools.crypto.parameters;

import io.ghcr.heliannuuthus.devtools.exception.CryptoException;
import lombok.Getter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

@Getter
public class StreamEncryptionParameters implements EncryptionParameters {

  private PrivateKey privateKey;
  private PublicKey publicKey;

  protected StreamEncryptionParameters() {
  }
  public StreamEncryptionParameters(byte[] key, boolean isPrivate) {
    this();
    try {
      KeyFactory keyFactory =
          KeyFactory.getInstance(this.getName(), BouncyCastleProvider.PROVIDER_NAME);
      if (isPrivate) {
        this.privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(key));
      } else {
        this.publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(key));
      }
    } catch (Exception e) {
      throw new CryptoException(CryptoException.INIT_MODE, getName(), e);
    }
  }

  @Override
  public Key getKey() {
    return Objects.nonNull(getPrivateKey()) ? privateKey : publicKey;
  }

  @Override
  public String getMode() {
    return null;
  }
}

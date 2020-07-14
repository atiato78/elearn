package saml2;

import javax.annotation.Generated;
import net.karneim.pojobuilder.GwtIncompatible;
import org.springframework.core.io.Resource;

@Generated("PojoBuilder")
public class KeystoreBeanBuilder
    implements Cloneable {
  protected KeystoreBeanBuilder self;
  protected String value$jksPath$java$lang$String;
  protected boolean isSet$jksPath$java$lang$String;
  protected String value$keystoreAlias$java$lang$String;
  protected boolean isSet$keystoreAlias$java$lang$String;
  protected String value$keystorePassword$java$lang$String;
  protected boolean isSet$keystorePassword$java$lang$String;
  protected String value$keystorePrivateKeyPassword$java$lang$String;
  protected boolean isSet$keystorePrivateKeyPassword$java$lang$String;
  protected Resource value$keystoreResource$org$springframework$core$io$Resource;
  protected boolean isSet$keystoreResource$org$springframework$core$io$Resource;

  /**
   * Creates a new {@link KeystoreBeanBuilder}.
   */
  public KeystoreBeanBuilder() {
    self = (KeystoreBeanBuilder)this;
  }

  /**
   * Sets the default value for the jksPath property.
   *
   * @param value the default value
   * @return this builder
   */
  public KeystoreBeanBuilder withJksPath(String value) {
    this.value$jksPath$java$lang$String = value;
    this.isSet$jksPath$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystoreAlias property.
   *
   * @param value the default value
   * @return this builder
   */
  public KeystoreBeanBuilder withKeystoreAlias(String value) {
    this.value$keystoreAlias$java$lang$String = value;
    this.isSet$keystoreAlias$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystorePassword property.
   *
   * @param value the default value
   * @return this builder
   */
  public KeystoreBeanBuilder withKeystorePassword(String value) {
    this.value$keystorePassword$java$lang$String = value;
    this.isSet$keystorePassword$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystorePrivateKeyPassword property.
   *
   * @param value the default value
   * @return this builder
   */
  public KeystoreBeanBuilder withKeystorePrivateKeyPassword(String value) {
    this.value$keystorePrivateKeyPassword$java$lang$String = value;
    this.isSet$keystorePrivateKeyPassword$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the keystoreResource property.
   *
   * @param value the default value
   * @return this builder
   */
  public KeystoreBeanBuilder withKeystoreResource(Resource value) {
    this.value$keystoreResource$org$springframework$core$io$Resource = value;
    this.isSet$keystoreResource$org$springframework$core$io$Resource = true;
    return self;
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @Override
  @GwtIncompatible
  public Object clone() {
    try {
      KeystoreBeanBuilder result = (KeystoreBeanBuilder)super.clone();
      result.self = result;
      return result;
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.getMessage());
    }
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @GwtIncompatible
  public KeystoreBeanBuilder but() {
    return (KeystoreBeanBuilder)clone();
  }

  /**
   * Creates a new {@link KeystoreBean} based on this builder's settings.
   *
   * @return the created KeystoreBean
   */
  public KeystoreBean build() {
    try {
      KeystoreBean result = new KeystoreBean(value$jksPath$java$lang$String, value$keystoreAlias$java$lang$String, value$keystorePassword$java$lang$String, value$keystorePrivateKeyPassword$java$lang$String, value$keystoreResource$org$springframework$core$io$Resource);
      return result;
    } catch (RuntimeException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}

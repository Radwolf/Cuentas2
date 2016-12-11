package org.rul.cuentas.mappers;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class CuentaUiMapper_Factory implements Factory<CuentaUiMapper> {
  private final MembersInjector<CuentaUiMapper> membersInjector;

  public CuentaUiMapper_Factory(MembersInjector<CuentaUiMapper> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public CuentaUiMapper get() {  
    CuentaUiMapper instance = new CuentaUiMapper();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<CuentaUiMapper> create(MembersInjector<CuentaUiMapper> membersInjector) {  
    return new CuentaUiMapper_Factory(membersInjector);
  }
}


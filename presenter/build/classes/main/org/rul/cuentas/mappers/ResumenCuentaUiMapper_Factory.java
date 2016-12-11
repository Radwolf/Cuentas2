package org.rul.cuentas.mappers;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ResumenCuentaUiMapper_Factory implements Factory<ResumenCuentaUiMapper> {
  private final MembersInjector<ResumenCuentaUiMapper> membersInjector;

  public ResumenCuentaUiMapper_Factory(MembersInjector<ResumenCuentaUiMapper> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public ResumenCuentaUiMapper get() {  
    ResumenCuentaUiMapper instance = new ResumenCuentaUiMapper();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<ResumenCuentaUiMapper> create(MembersInjector<ResumenCuentaUiMapper> membersInjector) {  
    return new ResumenCuentaUiMapper_Factory(membersInjector);
  }
}


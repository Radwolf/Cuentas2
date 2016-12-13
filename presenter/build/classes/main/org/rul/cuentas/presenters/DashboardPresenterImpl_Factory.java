package org.rul.cuentas.presenters;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.rul.cuentas.interactors.cuenta.dummy.LoadDummyDatosInteractor;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.cuentas.mappers.ResumenCuentaUiMapper;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DashboardPresenterImpl_Factory implements Factory<DashboardPresenterImpl> {
  private final Provider<GetActualResumenCuentasInteractor> getActualResumenCuentasInteractorProvider;
  private final Provider<LoadDummyDatosInteractor> loadDummyDatosInteractorProvider;
  private final Provider<ResumenCuentaUiMapper> resumenCuentaUiMapperProvider;

  public DashboardPresenterImpl_Factory(Provider<GetActualResumenCuentasInteractor> getActualResumenCuentasInteractorProvider, Provider<LoadDummyDatosInteractor> loadDummyDatosInteractorProvider, Provider<ResumenCuentaUiMapper> resumenCuentaUiMapperProvider) {  
    assert getActualResumenCuentasInteractorProvider != null;
    this.getActualResumenCuentasInteractorProvider = getActualResumenCuentasInteractorProvider;
    assert loadDummyDatosInteractorProvider != null;
    this.loadDummyDatosInteractorProvider = loadDummyDatosInteractorProvider;
    assert resumenCuentaUiMapperProvider != null;
    this.resumenCuentaUiMapperProvider = resumenCuentaUiMapperProvider;
  }

  @Override
  public DashboardPresenterImpl get() {  
    return new DashboardPresenterImpl(getActualResumenCuentasInteractorProvider.get(), loadDummyDatosInteractorProvider.get(), resumenCuentaUiMapperProvider.get());
  }

  public static Factory<DashboardPresenterImpl> create(Provider<GetActualResumenCuentasInteractor> getActualResumenCuentasInteractorProvider, Provider<LoadDummyDatosInteractor> loadDummyDatosInteractorProvider, Provider<ResumenCuentaUiMapper> resumenCuentaUiMapperProvider) {  
    return new DashboardPresenterImpl_Factory(getActualResumenCuentasInteractorProvider, loadDummyDatosInteractorProvider, resumenCuentaUiMapperProvider);
  }
}


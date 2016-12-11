package org.rul.cuentas.presenters;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.mappers.CuentaUiMapper;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HomePresenterImpl_Factory implements Factory<HomePresenterImpl> {
  private final Provider<GetAllCuentasInteractor> getAllCuentasInteractorProvider;
  private final Provider<InsertCuentaInteractor> insertCuentaInteractorProvider;
  private final Provider<RemoveCuentaInteractor> removeCuentaInteractorProvider;
  private final Provider<CuentaUiMapper> cuentaUiMapperProvider;

  public HomePresenterImpl_Factory(Provider<GetAllCuentasInteractor> getAllCuentasInteractorProvider, Provider<InsertCuentaInteractor> insertCuentaInteractorProvider, Provider<RemoveCuentaInteractor> removeCuentaInteractorProvider, Provider<CuentaUiMapper> cuentaUiMapperProvider) {  
    assert getAllCuentasInteractorProvider != null;
    this.getAllCuentasInteractorProvider = getAllCuentasInteractorProvider;
    assert insertCuentaInteractorProvider != null;
    this.insertCuentaInteractorProvider = insertCuentaInteractorProvider;
    assert removeCuentaInteractorProvider != null;
    this.removeCuentaInteractorProvider = removeCuentaInteractorProvider;
    assert cuentaUiMapperProvider != null;
    this.cuentaUiMapperProvider = cuentaUiMapperProvider;
  }

  @Override
  public HomePresenterImpl get() {  
    return new HomePresenterImpl(getAllCuentasInteractorProvider.get(), insertCuentaInteractorProvider.get(), removeCuentaInteractorProvider.get(), cuentaUiMapperProvider.get());
  }

  public static Factory<HomePresenterImpl> create(Provider<GetAllCuentasInteractor> getAllCuentasInteractorProvider, Provider<InsertCuentaInteractor> insertCuentaInteractorProvider, Provider<RemoveCuentaInteractor> removeCuentaInteractorProvider, Provider<CuentaUiMapper> cuentaUiMapperProvider) {  
    return new HomePresenterImpl_Factory(getAllCuentasInteractorProvider, insertCuentaInteractorProvider, removeCuentaInteractorProvider, cuentaUiMapperProvider);
  }
}


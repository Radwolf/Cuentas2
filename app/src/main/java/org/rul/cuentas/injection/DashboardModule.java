package org.rul.cuentas.injection;

import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.domain.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.domain.interactors.cuenta.get.GetActualResumenCuentasInteractorImpl;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractorImpl;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractorImpl;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractorImpl;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.model.ResumenCuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.repository.ResumenCuentaRepository;
import org.rul.domain.util.Mapper;
import org.rul.presenter.mappers.CuentaUiMapper;
import org.rul.presenter.mappers.ResumenCuentaUiMapper;
import org.rul.presenter.presenters.DashboardPresenter;
import org.rul.presenter.presenters.DashboardPresenterImpl;
import org.rul.presenter.presenters.HomePresenter;
import org.rul.presenter.presenters.HomePresenterImpl;
import org.rul.presenter.ui.model.Cuenta;
import org.rul.presenter.ui.model.ResumenCuenta;
import org.rul.repository.CuentaRepositoryImpl;
import org.rul.repository.ResumenCuentaRepositoryImpl;
import org.rul.repository.datasource.CuentaDbDatasource;
import org.rul.repository.datasource.CuentaDbDatasourceImpl;
import org.rul.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.repository.datasource.ResumenCuentaDbDatasourceImpl;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.model.ResumenCuentaDb;
import org.rul.repository.util.CuentaDomainMapper;
import org.rul.repository.util.ResumenCuentaDomainMapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 03/12/2016.
 */

@Module
public class DashboardModule {

    @Provides
    @ForActivity
    public DashboardPresenter providesPresenter(DashboardPresenterImpl dashboardPresenter){
        return dashboardPresenter;
    }

    @Provides
    @ForActivity
    public GetActualResumenCuentasInteractor providesGetActualResumenCuentasInteractor(GetActualResumenCuentasInteractorImpl getActualResumenCuentasInteractor){
        return  getActualResumenCuentasInteractor;
    }

    @Provides
    @ForActivity
    public ResumenCuentaRepository providesResumenCuentaRepository(ResumenCuentaRepositoryImpl resumenCuentaRepository){
        return resumenCuentaRepository;
    }

    @Provides
    @ForActivity
    public ResumenCuentaDbDatasource providesCuentaDbDatasource(ResumenCuentaDbDatasourceImpl resumenCuentaDbDatasource){
        return resumenCuentaDbDatasource;
    }

    @Provides
    @ForActivity
    public Mapper<ResumenCuenta, ResumenCuentaDomain> providesResumenCuentaUiMapper(ResumenCuentaUiMapper resumenCuentaUiMapper){
        return resumenCuentaUiMapper;
    }

    @Provides
    @ForActivity
    public Mapper<ResumenCuentaDomain, ResumenCuentaDb> provideResumenCuentaDomainMapper(ResumenCuentaDomainMapper resumenCuentaDomainMapper){
        return resumenCuentaDomainMapper;
    }

}

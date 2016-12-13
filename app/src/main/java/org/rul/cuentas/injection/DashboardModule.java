package org.rul.cuentas.injection;

import org.rul.cuentas.repository.DummyRepositoryImpl;
import org.rul.cuentas.repository.datasource.DummyDbDatasource;
import org.rul.cuentas.repository.datasource.DummyDbDatasourceImpl;
import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.interactors.cuenta.dummy.LoadDummyDatosInteractor;
import org.rul.cuentas.interactors.cuenta.dummy.LoadDummyDatosInteractorImpl;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.get.GetActualResumenCuentasInteractorImpl;
import org.rul.cuentas.model.ResumenCuentaDomain;
import org.rul.cuentas.repository.DummyRepository;
import org.rul.cuentas.repository.ResumenCuentaRepository;
import org.rul.cuentas.util.Mapper;
import org.rul.cuentas.mappers.ResumenCuentaUiMapper;
import org.rul.cuentas.presenters.DashboardPresenter;
import org.rul.cuentas.presenters.DashboardPresenterImpl;
import org.rul.cuentas.ui.model.ResumenCuenta;
import org.rul.cuentas.repository.ResumenCuentaRepositoryImpl;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasourceImpl;
import org.rul.cuentas.repository.model.ResumenCuentaDb;
import org.rul.cuentas.repository.util.ResumenCuentaDomainMapper;

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
    public LoadDummyDatosInteractor providesLoadDummyDatosInteractor(LoadDummyDatosInteractorImpl loadDummyDatosInteractor){
        return  loadDummyDatosInteractor;
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

    @Provides
    @ForActivity
    public DummyRepository providesDummyRepository(DummyRepositoryImpl dummyRepository){
        return dummyRepository;
    }

    @Provides
    @ForActivity
    public DummyDbDatasource providesDummyDatasource(DummyDbDatasourceImpl dummyDbDatasource){
        return dummyDbDatasource;
    }
}

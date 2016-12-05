package org.rul.cuentas.injection;

import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.domain.interactors.cuenta.get.GetAllCuentasInteractorImpl;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.domain.interactors.cuenta.insert.InsertCuentaInteractorImpl;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.domain.interactors.cuenta.remove.RemoveCuentaInteractorImpl;
import org.rul.domain.model.CuentaDomain;
import org.rul.domain.repository.CuentaRepository;
import org.rul.domain.util.Mapper;
import org.rul.presenter.mappers.CuentaUiMapper;
import org.rul.presenter.presenters.HomePresenter;
import org.rul.presenter.presenters.HomePresenterImpl;
import org.rul.presenter.ui.model.Cuenta;
import org.rul.repository.CuentaRepositoryImpl;
import org.rul.repository.datasource.CuentaDbDatasource;
import org.rul.repository.datasource.CuentaDbDatasourceImpl;
import org.rul.repository.model.CuentaDb;
import org.rul.repository.util.CuentaDomainMapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 03/12/2016.
 */

@Module
public class HomeModule {

    @Provides
    @ForActivity
    public HomePresenter providesPresenter(HomePresenterImpl homePresenter){
        return homePresenter;
    }

    @Provides
    @ForActivity
    public GetAllCuentasInteractor providesGetAllCuentasInteractor(GetAllCuentasInteractorImpl getAllCuentasInteractor){
        return  getAllCuentasInteractor;
    }

    @Provides
    @ForActivity
    public InsertCuentaInteractor providesInsertCuentaInteractor(InsertCuentaInteractorImpl insertCuentaInteractor){
        return  insertCuentaInteractor;
    }

    @Provides
    @ForActivity
    public RemoveCuentaInteractor providesRemoveCuentaInteractor(RemoveCuentaInteractorImpl removeCuentaInteractor){
        return removeCuentaInteractor;
    }

    @Provides
    @ForActivity
    public CuentaRepository providesCuentaRepository(CuentaRepositoryImpl cuentaRepository){
        return cuentaRepository;
    }

    @Provides
    @ForActivity
    public CuentaDbDatasource providesCuentaDbDatasource(CuentaDbDatasourceImpl cuentaDbDatasource){
        return cuentaDbDatasource;
    }

    @Provides
    @ForActivity
    public Mapper<Cuenta, CuentaDomain> providesCuentaUiMapper(CuentaUiMapper cuentaUiMapper){
        return cuentaUiMapper;
    }

    @Provides
    @ForActivity
    public Mapper<CuentaDomain, CuentaDb> provideCuentaDomainMapper(CuentaDomainMapper cuentaDomainMapper){
        return cuentaDomainMapper;
    }

}

package org.rul.cuentas.injection;

import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.insert.InsertCuentaInteractorImpl;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.presenters.AddCuentaPresenter;
import org.rul.cuentas.presenters.AddCuentaPresenterImpl;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.CuentaRepositoryImpl;
import org.rul.cuentas.repository.datasource.CategoriaDbDatasource;
import org.rul.cuentas.repository.datasource.CategoriaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.datasource.CuentaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasource;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.mapper.CuentaDomainMapper;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.util.Mapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 03/12/2016.
 */

@Module
public class AddCuentaModule {

    @Provides
    @ForActivity
    public AddCuentaPresenter providesPresenter(AddCuentaPresenterImpl addCuentaPresenter){
        return addCuentaPresenter;
    }

    @Provides
    @ForActivity
    public Mapper<Cuenta, CuentaDomain> providesCuentaUiMapper(CuentaUiMapper cuentaUiMapper){
        return cuentaUiMapper;
    }

    @Provides
    @ForActivity
    public InsertCuentaInteractor providesInsertCuentaInteractor(InsertCuentaInteractorImpl insertCuentaInteractor){
        return insertCuentaInteractor;
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
    public CategoriaDbDatasource providesCategoriaDbDatasource(CategoriaDbDatasourceImpl categoriaDbDatasource){
        return categoriaDbDatasource;
    }

    @Provides
    @ForActivity
    public MovimientoDbDatasource providesMovimientoDbDatasource(MovimientoDbDatasourceImpl movimientoDbDatasource){
        return movimientoDbDatasource;
    }

    @Provides
    @ForActivity
    public ResumenCuentaDbDatasource providesResumenCuentaDbDatasource(ResumenCuentaDbDatasourceImpl resumenCuentaDbDatasource){
        return resumenCuentaDbDatasource;
    }

    @Provides
    @ForActivity
    public Mapper<CuentaDomain, CuentaDb> provideCuentaDomainMapper(CuentaDomainMapper cuentaDomainMapper){
        return cuentaDomainMapper;
    }

}

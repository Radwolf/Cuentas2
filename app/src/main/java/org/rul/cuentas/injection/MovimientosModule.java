package org.rul.cuentas.injection;

import org.rul.cuentas.injection.annotations.ForActivity;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractor;
import org.rul.cuentas.interactors.cuenta.get.GetAllCuentasInteractorImpl;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractor;
import org.rul.cuentas.interactors.cuenta.remove.RemoveCuentaInteractorImpl;
import org.rul.cuentas.interactors.movimiento.get.GetAllMovimientosInteractor;
import org.rul.cuentas.interactors.movimiento.get.GetAllMovimientosInteractorImpl;
import org.rul.cuentas.interactors.movimiento.remove.LogicRemoveMovimientoInteractor;
import org.rul.cuentas.interactors.movimiento.remove.LogicRemoveMovimientoInteractorImpl;
import org.rul.cuentas.interactors.movimiento.remove.RemoveMovimientoInteractor;
import org.rul.cuentas.interactors.movimiento.remove.RemoveMovimientoInteractorImpl;
import org.rul.cuentas.mappers.CuentaUiMapper;
import org.rul.cuentas.mappers.MovimientoUiMapper;
import org.rul.cuentas.model.CuentaDomain;
import org.rul.cuentas.model.MovimientoDomain;
import org.rul.cuentas.presenters.CuentasPresenter;
import org.rul.cuentas.presenters.CuentasPresenterImpl;
import org.rul.cuentas.presenters.MovimientosPresenter;
import org.rul.cuentas.presenters.MovimientosPresenterImpl;
import org.rul.cuentas.repository.CuentaRepository;
import org.rul.cuentas.repository.CuentaRepositoryImpl;
import org.rul.cuentas.repository.MovimientoRepository;
import org.rul.cuentas.repository.MovimientoRepositoryImpl;
import org.rul.cuentas.repository.datasource.CategoriaDbDatasource;
import org.rul.cuentas.repository.datasource.CategoriaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.CuentaDbDatasource;
import org.rul.cuentas.repository.datasource.CuentaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasource;
import org.rul.cuentas.repository.datasource.MovimientoDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasource;
import org.rul.cuentas.repository.datasource.ResumenCuentaDbDatasourceImpl;
import org.rul.cuentas.repository.datasource.mapper.CuentaDomainMapper;
import org.rul.cuentas.repository.datasource.mapper.MovimientoDomainMapper;
import org.rul.cuentas.repository.datasource.model.CuentaDb;
import org.rul.cuentas.repository.datasource.model.MovimientoDb;
import org.rul.cuentas.ui.model.Cuenta;
import org.rul.cuentas.ui.model.Movimiento;
import org.rul.cuentas.util.Mapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rul on 03/12/2016.
 */

@Module
public class MovimientosModule {

    @Provides
    @ForActivity
    public MovimientosPresenter providesPresenter(MovimientosPresenterImpl movimientosPresenter){
        return movimientosPresenter;
    }

    @Provides
    @ForActivity
    public GetAllMovimientosInteractor providesGetAllMovimientosInteractor(GetAllMovimientosInteractorImpl getAllMovimientosInteractor){
        return getAllMovimientosInteractor;
    }

    @Provides
    @ForActivity
    public RemoveMovimientoInteractor providesRemoveMovimientoInteractor(RemoveMovimientoInteractorImpl removeMovimientoInteractor){
        return removeMovimientoInteractor;
    }

    @Provides
    @ForActivity
    public LogicRemoveMovimientoInteractor providesLogicRemoveMovimientoInteractor(LogicRemoveMovimientoInteractorImpl logicRemoveMovimientoInteractor){
        return logicRemoveMovimientoInteractor;
    }

    @Provides
    @ForActivity
    public MovimientoRepository providesMovimientoRepository(MovimientoRepositoryImpl movimientoRepository){
        return movimientoRepository;
    }

    @Provides
    @ForActivity
    public MovimientoDbDatasource providesMovimientoDbDatasource(MovimientoDbDatasourceImpl movimientoDbDatasource){
        return movimientoDbDatasource;
    }

    @Provides
    @ForActivity
    public CategoriaDbDatasource providesCategoriaDbDatasource(CategoriaDbDatasourceImpl categoriaDbDatasource){
        return categoriaDbDatasource;
    }

    @Provides
    @ForActivity
    public Mapper<Movimiento, MovimientoDomain> providesMovimientoUiMapper(MovimientoUiMapper movimientoUiMapper){
        return movimientoUiMapper;
    }

    @Provides
    @ForActivity
    public Mapper<MovimientoDomain, MovimientoDb> provideMovimientoDomainMapper(MovimientoDomainMapper movimientoDomainMapper){
        return movimientoDomainMapper;
    }

}

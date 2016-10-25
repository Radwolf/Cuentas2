package org.rul.cuentas;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.rul.cuentas.model.Cuenta;
import org.rul.cuentas.repository.CuentaRepositoriImpl;
import org.rul.cuentas.repository.CuentaRepository;

import io.realm.Realm;
import io.realm.log.RealmLog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@SuppressStaticInitializationFor("io.realm.internal.Util")
@PrepareForTest({Realm.class, RealmLog.class})
public class ExampleRealmTest {
    // Robolectric, Using Power Mock https://github.com/robolectric/robolectric/wiki/Using-PowerMock

    @Rule
    public PowerMockRule rule = new PowerMockRule();
    Realm mockRealm;

    @Before
    public void setup() {
        mockStatic(RealmLog.class);
        mockStatic(Realm.class);

        Realm mockRealm = PowerMockito.mock(Realm.class);

        when(Realm.getDefaultInstance()).thenReturn(mockRealm);

        this.mockRealm = mockRealm;
    }

    @Test
    public void shouldBeAbleToGetDefaultInstance() {
        assertThat(Realm.getDefaultInstance(), is(mockRealm));
    }

    @Test
    public void shouldBeAbleToMockRealmMethods() {
        when(mockRealm.isAutoRefresh()).thenReturn(true);
        assertThat(mockRealm.isAutoRefresh(), is(true));

        when(mockRealm.isAutoRefresh()).thenReturn(false);
        assertThat(mockRealm.isAutoRefresh(), is(false));
    }

    @Test
    public void shouldBeAbleToCreateARealmObject() {
        Cuenta cuenta = new Cuenta();
        when(mockRealm.createObject(Cuenta.class)).thenReturn(cuenta);

        Cuenta output = mockRealm.createObject(Cuenta.class);

        assertThat(output, is(cuenta));
    }

    /**
     * This test verifies the behavior in the {@link org.rul.cuentas.repository.CuentaRepositoriImpl} class.
     */
    @Test
    public void shouldVerifyThatCuentaWasCreated() {

        doCallRealMethod().when(mockRealm).executeTransaction(Mockito.any(Realm.Transaction.class));

        Cuenta cuenta = mock(Cuenta.class);
        when(mockRealm.createObject(Cuenta.class)).thenReturn(cuenta);

        CuentaRepository cuentaRepository = new CuentaRepositoriImpl();
        cuentaRepository.createCuenta("Casa");

        // Attempting to verify that a method was called (executeTransaction) on a partial
        // mock will return unexpected resultes due to the partial mock. For example,
        // verifying that `executeTransaction` was called only once will fail as Powermock
        // actually calls the method 3 times for some reason. I cannot determine why at this
        // point.


        // Verify that Realm#createObject was called only once
        verify(mockRealm, times(1)).createObject(Cuenta.class); // Verify that a Dog was in fact created.

        // Verify that Dog#setName() is called only once
        verify(cuenta, times(1)).setNombre(Mockito.anyString()); // Any string will do

        // Verify that the Realm was closed only once.
        verify(mockRealm, times(1)).close();
    }

    /**
     * Have to verify the {@link Realm#executeTransaction(Realm.Transaction)} call in a different
     * test because of a problem with Powermock: https://github.com/jayway/powermock/issues/649
     */
    @Test
    public void shouldVerifyThatTransactionWasExecuted() {

        CuentaRepository dogRepo = new CuentaRepositoriImpl();
        dogRepo.createCuenta("Casa");

        // Verify that the begin transaction was called only once
        verify(mockRealm, times(1)).executeTransaction(Mockito.any(Realm.Transaction.class));

        // Verify that the Realm was closed only once.
        verify(mockRealm, times(1)).close();
    }
}
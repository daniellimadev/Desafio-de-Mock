package com.github.daniellimadev;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CaixaEletronicoTest {
    @Mock
    private Banco bancoMock;

    @InjectMocks
    private CaixaEletronico caixaEletronico;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testeExibirSaldosComMock() {
        when(bancoMock.getSaldoContaCorrente()).thenReturn(500.00);
        when(bancoMock.getSaldoContaPoupanca()).thenReturn(1500.00);

        caixaEletronico.exibirSaldos();

        verify(bancoMock).getSaldoContaCorrente();
        verify(bancoMock).getSaldoContaPoupanca();
    }

    @Test
    void testeExibirSaldosComSpy() {
        Banco bancoReal = new Banco();
        Banco bancoSpy = spy(bancoReal);

        doReturn(600.00).when(bancoSpy).getSaldoContaCorrente();

        CaixaEletronico caixaEletronicoComSpy = new CaixaEletronico(bancoSpy);

        caixaEletronicoComSpy.exibirSaldos();

        verify(bancoSpy).getSaldoContaCorrente();
        verify(bancoSpy).getSaldoContaPoupanca();
    }
}

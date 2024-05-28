package com.github.daniellimadev;

public class CaixaEletronico {
    private Banco banco;

    public CaixaEletronico(Banco banco) {
        this.banco = banco;
    }

    public void exibirSaldos() {
        double saldoCC = banco.getSaldoContaCorrente();
        double saldoCP = banco.getSaldoContaPoupanca();
        System.out.println("Saldo Conta Corrente: " + saldoCC);
        System.out.println("Saldo Conta Poupança: " + saldoCP);
    }
}


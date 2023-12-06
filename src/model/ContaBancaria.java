package model;

public class ContaBancaria {

    private String agencia;

    private String numero;

    private double saldo;

    private Pessoa contratante;


    public ContaBancaria(String agencia, String numeroConta, double saldo) {
        this.agencia = agencia;
        this.numero = numeroConta;
        this.saldo = saldo;
    }

    public ContaBancaria(String agencia, String numeroConta, double saldo, Pessoa contratante) {
        this.agencia = agencia;
        this.numero = numeroConta;
        this.saldo = saldo;
        this.contratante = contratante;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getContratante() {
        return contratante;
    }


    public void depositar(double valor){
        saldo += valor;

    }

    public boolean sacar(double valor){
        if (valor > saldo){
            System.out.println("Nao é possivel sacar");
            return false;
        }
        saldo -= valor;
        return true;
    }

    public void transferir(ContaBancaria contaDestino, double valor){
        if (this.sacar(valor)){
            contaDestino.depositar(valor);
        }

    }
}

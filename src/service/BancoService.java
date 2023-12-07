package service;

import model.ContaBancaria;
import model.Pessoa;

import java.util.Random;

public class BancoService {

    private ContaBancaria[] contas = new ContaBancaria[1000];

    private ContaBancaria conta;

    private Random random = new Random();

    private int tamanho = 0;

    public void adicionar(Pessoa contratante){
        Integer agencia = random.nextInt(1, 9999);
        Integer numeroConta = random.nextInt(1, 9999);

        ContaBancaria novaConta = new ContaBancaria(agencia.toString(), numeroConta.toString(), 0, contratante);

        contas[tamanho] = novaConta;
        tamanho ++;

    }

    public void depositar(ContaBancaria conta, double valorDeposito){
        conta.depositar(100);

    }

    public void sacar(ContaBancaria conta, double valorSaque){
        conta.sacar(100);
    }


//    operar com uma conta no banco - depositar, sacar  e transferir
//    utilizar array de 1000 posicoes
}

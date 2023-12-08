package service;

import model.ContaBancaria;
import model.Pessoa;

import java.util.Random;

public class BancoService {

    private ContaBancaria[] contas = new ContaBancaria[1000];

    private Random random = new Random();

    private int tamanho = 0;

    public void adicionar(Pessoa contratante){
        if(estaCpfJaCadastrado(contratante.getCpf())){
            System.out.println("Cpf ja cadastrado");
            return;
        }

        Integer agencia = random.nextInt(1, 9999);
        Integer numeroConta = random.nextInt(1, 9999);

        ContaBancaria novaConta = new ContaBancaria(agencia.toString(), numeroConta.toString(), 0, contratante);

        contas[tamanho] = novaConta;
        tamanho ++;
    }

    public void depositar(String cpfDestino, double valorDeposito) {
        ContaBancaria contaDestino = buscaContaPorCpf(cpfDestino);

        if(contaDestino == null)
            return;

        contaDestino.depositar(valorDeposito);
    }

    public void sacar(String cpfOrigem, double valorSaque){
        ContaBancaria contaOrigem = buscaContaPorCpf(cpfOrigem);

        if(contaOrigem == null)
            return;

        contaOrigem.sacar(valorSaque);
    }

    public void transferir(String cpfOrigem, String cpfDestino, double valorTransferencia){
        ContaBancaria contaOrigem = buscaContaPorCpf(cpfOrigem);
        ContaBancaria contaDestino = buscaContaPorCpf(cpfDestino);

        if(contaOrigem == null || contaDestino == null)
            return;

        contaOrigem.transferir(contaDestino, valorTransferencia);
    }

    public ContaBancaria buscaContaPorCpf(String cpf) {
        for(int i=0; i < tamanho; i++) {
            if(contas[i].getContratante().getCpf().equals(cpf))
                return contas[i];
        }

        return null;
    }

    private boolean estaCpfJaCadastrado(String cpf) {
        for (int i = 0; i < tamanho; i++) {
            if(contas[i].getContratante().getCpf().equals(cpf))
                return true;
        }

        return false;
    }

//    operar com uma conta no banco - depositar, sacar  e transferir
//    utilizar array de 1000 posicoes
}

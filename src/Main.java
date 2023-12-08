import model.ContaBancaria;
import model.Pessoa;
import service.BancoService;

public class Main {
    public static void main(String[] args) {

        // CRUD = Create Read Update Delete

        BancoService bancoService = new BancoService();
        bancoService.adicionar(new Pessoa("Mario", "111.222.333-99", 40));
        bancoService.adicionar(new Pessoa("Hugo", "111.222.333-98", 40));


        bancoService.depositar("111.222.333-98", 300);
        System.out.println(bancoService.buscaContaPorCpf("111.222.333-98"));
    }
}
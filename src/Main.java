import model.ContaBancaria;
import model.Pessoa;
import service.BancoService;

public class Main {
    public static void main(String[] args) {

        BancoService bancoService = new BancoService();
        bancoService.adicionar(new Pessoa("Mario", "111.222.333-99", 40));



    }
}
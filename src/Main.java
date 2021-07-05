
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private Scanner l;
    private boolean execute;
    private List<Dados> dados;

    public static void main(String[] args) throws ParseException {
        new Main();
    }

    private Main() throws ParseException {
        l = new Scanner(System.in);
        execute = true;
        dados = new ArrayList<Dados>();

        System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");

        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("n")) {
                cadastrar();
            } else if (opcao.equalsIgnoreCase("l")) {
                listarCadastros();
            } else if (opcao.equalsIgnoreCase("x")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida!!! \n");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione a opção:");
        System.out.println("N - Novo cadastro");
        System.out.println("L - Listar cadastros");
        System.out.println("X - Sair");
        return l.nextLine();
    }

    private void cadastrar() throws ParseException {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Anúncios");
            Dados d = new Dados();
            d.setNomeCliente(textInput("Nome do Cliente:"));
            d.setNomeAnuncio(textInput("Nome do Anúncio: "));
            d.setDataInicio(textInput("Data de Inicio do Anúncio: "));
            d.setDataTermino(textInput("Data de término do Anúncio:"));
            d.setInvPorDia(textInput("Valor investido por dia:"));



            String cadastrar = textInput("Adicionar cadastro (S/N) ?");

            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado !!!");
                dados.add(d);
            } else if (cadastrar.equalsIgnoreCase("n")){
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida!!! \n");
            }

            String continua = textInput("Continuar cadastrando (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")){
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida!!! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastros() {
        if (dados.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < dados.size(); i++) {
                Dados d = dados.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.println("\tNome do Cliente: " + d.getNomeCliente());
                System.out.println("\tNome do Anuncio: " + d.getNomeAnuncio());
                System.out.println("\tData de inicio do anúncio: " + d.getDataInicio() );
                System.out.println("\tData de término do anúncio:" +d.getDataTermino());
                System.out.println("\tValor investido por dia: " +d.getInvPorDia()+ "\n");
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }

    public class Dados {

        private String nomeCliente;

        private String NomeAnuncio;

        private String dataInicio = "00/11/2222";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(getDataInicio());

        private String dataTermino = "00/11/2222";
        SimpleDateFormat formatterr = new SimpleDateFormat("dd/MM/yyyy");
        Date datee = formatterr.parse(getDataInicio());

        private String invPorDia;

        public Dados() throws ParseException {


        }

        public String getNomeCliente(){

            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente){

            this.nomeCliente = nomeCliente;
        }

        public String getNomeAnuncio(){

            return NomeAnuncio;
        }

        public void setNomeAnuncio(String NomeAnuncio ){

            this.NomeAnuncio = NomeAnuncio;
        }

        public String getDataInicio(){

            return dataInicio;
        }

        public void setDataInicio(String dataInicio){

            this.dataInicio = dataInicio;
        }


        public String getDataTermino() {
            return dataTermino;
        }

        public void setDataTermino(String dataTermino) {
            this.dataTermino = dataTermino;
        }

        public String getInvPorDia() {
            return invPorDia;
        }

        public void setInvPorDia(String invPorDia) {
            this.invPorDia = invPorDia;
        }


    }
}


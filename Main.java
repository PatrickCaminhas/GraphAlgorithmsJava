import java.io.IOException;
import java.util.Scanner;

public class Main {



  public static void main(String[] args) throws IOException {
    int opcao = -1;
    int segundaopcao = -1;
    int terceiraopcao = -1;
    GraphList grafolist;
    int source=0, end=0;

    GraphMatrix grafomatriz;

    Scanner leitor = new Scanner(System.in);
    InterfaceUsuario m = new InterfaceUsuario();
    long tempoInicial = System.currentTimeMillis();
    do {
      m.menutext();
      opcao = leitor.nextInt();
      switch (opcao) {
        case 1:
          do{
            m.caminhotext();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              case 1:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //DIJKSTRA
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");

                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USAroaddtDC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USAroaddtNY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Dijkstra...");
                      break;
                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 2:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USAroaddtDC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USAroaddtNY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 3:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //FLOYDWARSHALL
                    case 1:
                      grafomatriz= new GraphMatrix("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafomatriz = new GraphMatrix("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafomatriz = new GraphMatrix("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafomatriz = new GraphMatrix("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafomatriz = new GraphMatrix("USAroaddtDC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafomatriz = new GraphMatrix("USAroaddtNY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Floyd-Warshall...");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 4:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD MELHORADO
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USAroaddtDC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USAroaddtNY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.improvedBellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Bellman-Ford melhorado...");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 5:
                break;
              default:
            }
          }while(segundaopcao!=5);

          break;
        case 2:
          do{
            m.labirintotext();
            segundaopcao=leitor.nextInt();
            System.out.println("FUNÇÃO A SER IMPLEMENTADA");
            switch (segundaopcao){
              //LABIRINTO
              case 1:
                System.out.println("CAMINHO 1 NÃO USADO");
                break;
              case 2:
                System.out.println("CAMINHO 2 NÃO USADO");
                break;
              case 3:
                System.out.println("CAMINHO 3 NÃO USADO");
                break;
              case 4:
                System.out.println("CAMINHO 4 NÃO USADO");
                break;
              case 5:
                System.out.println("CAMINHO 5 NÃO USADO");
                break;
              case 6:
                System.out.println("CAMINHO 5 NÃO USADO");
                break;
              case 7:
                System.out.println("Saindo algoritmo do labirinto...");
                break;

              default:
            }
          }while(segundaopcao!=7);



          break;
        case 3:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("OPCAO INCORRETA!!!");
          break;
      }
    } while (opcao != 3);
  }
}

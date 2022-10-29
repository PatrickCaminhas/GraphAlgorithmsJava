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
    maze labirinto = new maze();

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
                    case 7:
                      System.out.println("Saindo do algoritmo de Bellman-Ford...");
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
              case 7:
                System.out.println("Saindo dos algoritmos de caminho minimo...");
                break;

              default:
            }
          }while(segundaopcao!=5);

          break;
        case 2:
          do{
            m.labirintotext();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              //LABIRINTO
              case 1:
                tempoInicial = System.currentTimeMillis();
                labirinto.abrirLabirinto("mazetoy.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 2:
                tempoInicial = System.currentTimeMillis();
                labirinto.abrirLabirinto("maze3.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 3:
                tempoInicial = System.currentTimeMillis();
                labirinto.abrirLabirinto("maze10.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 4:
                tempoInicial = System.currentTimeMillis();
               labirinto.abrirLabirinto("maze20.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 5:
                tempoInicial = System.currentTimeMillis();
                labirinto.abrirLabirinto("maze30.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 6:
                tempoInicial = System.currentTimeMillis();
                 labirinto.abrirLabirinto("maze40.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 7:
                tempoInicial = System.currentTimeMillis();
                labirinto.abrirLabirinto("maze50.txt");
                System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                break;
              case 8:
                System.out.println("Saindo algoritmo do labirinto...");
                break;

              default:
            }
          }while(segundaopcao!=8);



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

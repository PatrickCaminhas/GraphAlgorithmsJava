import java.io.*;

public class maze {

    public void abrirLabirinto(String fileName, int y, int x, char[][] matriz, int source,int end, GraphList grafo ) throws IOException {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                try {
                    if (matriz[i][j] == 'S' || matriz[i][j] == 'E' || matriz[i][j] == ' ') {
                        if (matriz[i][j] == 'S') {
                            source = (i * x + j);
                        }
                        if (matriz[i][j] == 'E') {
                            end = (i * x + j);
                        }
                        try {
                            if (matriz[i][j + 1] == 'S' || matriz[i][j + 1] == 'E' || matriz[i][j + 1] == ' ') {
                                grafo.addEdgeUnoriented((i * x + j), (i * x + (j + 1)), 1);
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (matriz[i + 1][j] == 'S' || matriz[i + 1][j] == 'E' || matriz[i + 1][j] == ' ') {
                                grafo.addEdgeUnoriented((i * x + j), ((i + 1) * x + j), 1);
                            }
                        } catch (Exception ignored) {
                        }

                    }
                } catch (Exception e) {

                }
            }
        }

        grafo.bellmanFord(source,end);
    }

    public void abrirLabirinto(String fileName) throws IOException {

        LineNumberReader tamanhoLinha = new LineNumberReader(new FileReader(fileName));
        BufferedReader leitor = new BufferedReader(new FileReader(fileName));
        String linha;
        linha = leitor.readLine();
        int x = linha.length();
        int y = tamanhoLinha.getLineNumber();
        int source = 0;
        int end = 0;
        tamanhoLinha.skip(999999);
        GraphList grafo = new GraphList(y * x);
        char[][] matriz = new char[y][x];

        int i = 0;
        matriz[i] = linha.toCharArray();
        i = i + 1;
        while (leitor.ready()) {
            linha = leitor.readLine();
            matriz[i] = linha.toCharArray();
            i++;
        }

        leitor.close();
        abrirLabirinto(fileName,y,x,matriz,source,end,grafo);
    }



}
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class GerenciadorDeEstoque {
    
    private HashMap<String, Produto> listaEstoque;

    public GerenciadorDeEstoque() {
        this.listaEstoque = new HashMap<String, Produto>();
    }

    public String adicionarProduto(final String produto, final int quantidade, final int valor, final int Id){
        if(quantidade <= 0 || valor < 0 || Id < 0) {
            return "Erro: quantidade, valor e ID inválidos!";
        }
        if(listaEstoque.containsKey(produto)){
            return "Erro: produto já existe no estoque!";
        }

        for(Produto produtoExistente : listaEstoque.values()){
            if(produtoExistente.getId() == Id){
                return "Erro: ID já existe no estoque!";
            }
        }

        listaEstoque.put(produto, new Produto(quantidade, valor, Id));
        return "Produto " + produto + " adicionado com sucesso! Quantidade: " + quantidade + " - Valor: " + valor + " - ID: " + Id;
    }

    public void removerProduto(){
        if(listaEstoque.isEmpty()){
            JOptionPane.showMessageDialog(null, "Estoque vazio!");
            return;
        }

        String[] colunas = {"Nome", "Quantidade", "Valor", "ID"};
        String[][] dados = new String[listaEstoque.size()][colunas.length];

        List<String> nomes = new ArrayList<>(listaEstoque.keySet());
        for(int i = 0; i < nomes.size(); i++){
            Produto p = listaEstoque.get(nomes.get(i));
            dados[i][0] = nomes.get(i);
            dados[i][1] = String.valueOf(p.getQuantidade());
            dados[i][2] = String.valueOf(p.getValor());
            dados[i][3] = String.valueOf(p.getId());
        }
        
        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int opc = JOptionPane.showConfirmDialog(null, scrollPane, "Selecione o produto a remover", JOptionPane.OK_CANCEL_OPTION);

        if(opc == JOptionPane.OK_OPTION){
            int linhaSelcionada = tabela.getSelectedRow();
            if(linhaSelcionada != -1){
                String nomeProduto = tabela.getValueAt(linhaSelcionada, 0).toString();
                listaEstoque.remove(nomeProduto);
                JOptionPane.showMessageDialog(null, "Produto \"" + nomeProduto + "\" removido com sucesso!");
            } else{
                JOptionPane.showMessageDialog(null, "Nenhum produto selecionado!");
            }
        }
    }        
    public void exibirTodosProdutos(){
        if(listaEstoque.isEmpty()){
            JOptionPane.showMessageDialog(null, "Estoque vazio!");
            return;
        }

        List<String[]> dadosLista = new ArrayList<>();

        for(Map.Entry<String, Produto> entry : listaEstoque.entrySet()){
            Produto p = entry.getValue();
            dadosLista.add(new String[]{entry.getKey(), String.valueOf(p.getQuantidade()), String.valueOf(p.getValor()), String.valueOf(p.getId())});
        }

        String[] colunas = {"Nome", "Quantidade", "Valor", "ID"};
        String[][] dados = dadosLista.toArray(new String[0][]);

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.setFillsViewportHeight(true);

        JOptionPane.showMessageDialog(null, scrollPane, "Estoque Atual", JOptionPane.INFORMATION_MESSAGE);
    }

    public void salvarEstoqueEmArquivo(String nomeArquivo){
        try(PrintWriter escritor = new PrintWriter(nomeArquivo)){
            escritor.println("Nome,Quantidade,Valor,ID");

            for (Map.Entry<String, Produto> entry : listaEstoque.entrySet()){
                Produto p = entry.getValue();
                escritor.printf("%s,%d,%d,%d\n", entry.getKey(), p.getQuantidade(), p.getValor(), p.getId());
            }   

            JOptionPane.showMessageDialog(null, "Estoque salvo com sucesso em" +nomeArquivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar estoque em" + e.getMessage());
        }
    }



    public static void main(String[] args) {
        GerenciadorDeEstoque gerenciador = new GerenciadorDeEstoque();
        int opt = 5;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog
        (
            "1 - Adicionar Produto ou Atualizar\n" +
            "2 - Remover Produto\n" +
            "3 - Verificar Produtos\n" +
            "4 - Salvar Estoque\n" +
            "0 - Sair\n"
        ));
        switch (opt) {
            case 1:
                try{
                String produto = JOptionPane.showInputDialog("Digite o nome do produto: ", "");
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: ", ""));
                int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do produto: ", ""));
                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto: ", ""));
                String resposta = gerenciador.adicionarProduto(produto, quantidade, valor, id);
                JOptionPane.showMessageDialog(null, resposta);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Entrada inválida!");
                }
                break;
            case 2:
                gerenciador.removerProduto();
                break;
            case 3:
                gerenciador.exibirTodosProdutos();
                break;
            case 4:
                gerenciador.salvarEstoqueEmArquivo(JOptionPane.showInputDialog("Digite o nome do arquivo para salvar estoque: ", ""));
                break;
            case 0:
            JOptionPane.showMessageDialog(null, "Saindo do programa!");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }while (opt != 5);
    }

    
}


    
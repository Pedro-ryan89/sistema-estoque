/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque;

import dev.pedroryan.estoque.sistema.estoque.model.Produto;
import dev.pedroryan.estoque.sistema.estoque.service.ProdutoService;
import dev.pedroryan.estoque.sistema.estoque.util.GsonUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author preya
 */
public class MenuPrincipal {
    private final ProdutoService service;
    private final Scanner scanner = new Scanner(System.in);

    public MenuPrincipal(ProdutoService service) {
        this.service = service;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Atualizar produto");
            System.out.println("6 - Remover produto");
            System.out.println("7 - Valor total do estoque");
            System.out.println("8 - Exportar produtos para JSON");
            System.out.println("9 - Importar produtos do JSON");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1" -> adicionarProduto();
                    case "2" -> listarProdutos();
                    case "3" -> buscarPorId();
                    case "4" -> buscarPorNome();
                    case "5" -> atualizarProduto();
                    case "6" -> removerProduto();
                    case "7" -> calcularValorTotal();
                    case "8" -> exportarJSON();
                    case "9" -> importarJSON();
                    case "0" -> {
                        System.out.println("Encerrando o sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void adicionarProduto() throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        Produto produto = new Produto(0, nome, qtd, (int) preco);
        service.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void listarProdutos() throws SQLException {
        List<Produto> produtos = service.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtos.forEach(System.out::println);
    }

    private void buscarPorId() throws SQLException {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Produto produto = service.buscarPorId(id);
        System.out.println(produto != null ? produto : "Produto não encontrado.");
    }

    private void buscarPorNome() throws SQLException {
       System.out.print("Nome: ");
    String nome = scanner.nextLine();
    List<Produto> encontrados = service.buscarPorNome(nome);

    if (encontrados.isEmpty()) {
        System.out.println("Produto não encontrado.");
    } else {
        for (Produto p : encontrados) {
            System.out.println(p);
        }
    }
    }

    private void atualizarProduto() throws SQLException {
        System.out.print("ID do produto: ");
        int id = Integer.parseInt(scanner.nextLine());
        Produto produto = service.buscarPorId(id);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Novo nome (" + produto.getNome() + "): ");
        produto.setNome(scanner.nextLine());
        System.out.print("Novo preço (" + produto.getPreco() + "): ");
        produto.setPreco(Double.parseDouble(scanner.nextLine()));
        System.out.print("Nova quantidade (" + produto.getQuantidade() + "): ");
        produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

        service.atualizarProduto(produto);
        System.out.println("Produto atualizado com sucesso!");
    }

    private void removerProduto() throws SQLException {
        System.out.print("ID do produto a remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.removerProduto(id);
        System.out.println("Produto removido com sucesso!");
    }

    private void calcularValorTotal() throws SQLException {
        double total = service.valorTotalEstoque();
        System.out.printf("Valor total do estoque: R$ %.2f%n", total);
    }

    private void exportarJSON() throws SQLException, IOException {
        var produtos = service.listarProdutos();
        GsonUtil.exportarProdutos(produtos);
        System.out.println("Produtos exportados para 'produtos.json'.");
    }

    private void importarJSON() throws IOException, SQLException {
        var produtosImportados = GsonUtil.importarProdutos();
        for (Produto p : produtosImportados) {
            service.adicionarProduto(p);
        }
        System.out.println("Produtos importados com sucesso!");
    }
    
}

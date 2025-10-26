/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.pedroryan.estoque.sistema.estoque.main;

import dev.pedroryan.estoque.sistema.estoque.model.Produto;
import dev.pedroryan.estoque.sistema.estoque.service.ProdutoService;

/**
 *
 * @author preya
 */
public class SistemaEstoque {

    public static void main(String[] args) {
         ProdutoService service = new ProdutoService();

        Produto p1 = new Produto(1, "Teclado", 5, 150.0);
        Produto p2 = new Produto(2, "Mouse", 10, 80.0);

        service.adicionarProduto(p1);
        service.adicionarProduto(p2);

        System.out.println("Lista de produtos:");
        for (Produto p : service.listarProdutos()) {
            System.out.println(p.getNome() + " - R$" + p.getPreco());
        }

        // Atualizando
        Produto novo = new Produto(1, "Teclado Mecânico", 5, 200.0);
        service.atualizarProduto(1, novo);

        System.out.println("\nApós atualização:");
        for (Produto p : service.listarProdutos()) {
            System.out.println(p.getNome() + " - R$" + p.getPreco());
        }

        // Removendo
        service.removerProduto(2);

        System.out.println("\nApós remoção:");
        for (Produto p : service.listarProdutos()) {
            System.out.println(p.getNome());
        }
        
    }
}

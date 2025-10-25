/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.service;

import dev.pedroryan.estoque.sistema.estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author preya
 */
public class ProdutoService {
    
    private List<Produto> produtos = new ArrayList<>();
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    
    }
    
    public List<Produto> listarProdutos(){
        return produtos;
    }
    
    public Produto buscarPorId(int id){
        for(Produto p : produtos){
            if(p.getID() == id){
                return p;
            }
        }
        return null;
    }
    
    public boolean atualizarProduto(int id,Produto novoProduto){
        for(int i = 0;i < produtos.size();i++){
            if(produtos.get(i).getID() == id){
                produtos.set(i, novoProduto);
                return true;
            }
        }
        return false;
    }
    
}

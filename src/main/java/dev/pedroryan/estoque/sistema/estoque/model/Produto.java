/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.model;

/**
 *
 * @author preya
 */
public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;
    
    public Produto(){}
    
    
    public Produto(int id,String nome,int quantidade,double preco){
        this.id = id; this.nome = nome; this.quantidade = quantidade; this.preco = preco;
    }
    
    public int getID(){return this.id;}
    public String getNome(){return this.nome;}
    public  int getQuantidade(){return this.quantidade;}
    public double getPreco(){return this.preco;}
    public int setID(){return this.id = id;}
    public String setNome(){return this.nome = nome;}
    public int setQuantidade(){return this.quantidade = quantidade;}
    public double setPreco(){return this.preco = preco;}
    
    
    @Override
    public String toString() { return id + " | " + nome + " | " + quantidade + " | " + preco; }
    
    }

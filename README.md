# Sistema de Estoque

Sistema de gerenciamento de estoque desenvolvido em **Java**. Permite adicionar, listar, buscar, atualizar e remover produtos, calcular o valor total do estoque e importar/exportar produtos em formato JSON. Utiliza **SQLite** como banco de dados e **Gson** para manipulação de arquivos JSON.

---

## Funcionalidades

- Adicionar produto
- Listar todos os produtos
- Buscar produto por ID
- Buscar produto por nome
- Atualizar produto
- Remover produto
- Calcular valor total do estoque
- Exportar produtos para JSON
- Importar produtos do JSON
- Persistência em banco de dados SQLite

---

## Estrutura do Projeto
``` bash
sistema-estoque/
│
├─ data/ # Arquivos de dados como produtos.json
├─ src/main/java/
│ └─ dev/pedroryan/estoque/sistema/estoque/
│ ├─ dao/ # Classes de acesso ao banco de dados (ProdutoDAO, ConexaoBD)
│ ├─ model/ # Modelo de dados (Produto)
│ ├─ service/ # Lógica de negócio (ProdutoService)
│ └─ util/ # Utilitários (GsonUtil)
├─ pom.xml # Configuração Maven

```


---

## Tecnologias Utilizadas

- Java 17+
- Maven
- SQLite (via JDBC)
- Gson (importação/exportação JSON)

---

## Como Executar

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/Pedro-ryan89/sistema-estoque.git
cd sistema-estoque

```
### 2️⃣ compilar e executar
``` bash
mvn compile exec:java -Dexec.mainClass="dev.pedroryan.estoque.sistema.estoque.main.SistemaEstoque"
```
### Observação: O sistema criará automaticamente:
- "data/produtos.json para armazenar os produtos em JSON"
- "estoque.db como banco de dados SQLite"

---
#exemplo de uso

``` bash
=== SISTEMA DE ESTOQUE ===
1 - Adicionar produto
2 - Listar produtos
3 - Buscar por ID
4 - Buscar por nome
5 - Atualizar produto
6 - Remover produto
7 - Valor total do estoque
8 - Exportar produtos para JSON
9 - Importar produtos do JSON
0 - Sair
Escolha: 1
Nome: Teclado
Preço: 150.0
Quantidade: 10
Produto adicionado com sucesso!

Escolha: 2
ID: 1 | Nome: Teclado | Preço: R$ 150.00 | Quantidade: 10

Escolha: 4
Nome: Teclado
ID: 1 | Nome: Teclado | Preço: R$ 150.00 | Quantidade: 10
```

### Observações
- Buscar por nome retorna todos os produtos que contenham o termo informado.
- Ao importar do JSON, produtos duplicados podem ser adicionados (futuras versões podem implementar verificação de duplicidade).
- O arquivo JSON (data/produtos.json) e o banco SQLite (estoque.db) são criados automaticamente se não existirem.

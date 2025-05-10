# Gerenciador de Estoque

Este é um projeto simples de gerenciamento de estoque desenvolvido em Java. Ele permite adicionar, remover, visualizar e salvar produtos em um arquivo CSV.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de pastas e arquivos:

- **`src/Produto.java`**: Classe que representa um produto no estoque.
- **`src/GerenciadorDeEstoque.java`**: Classe principal que gerencia o estoque e fornece funcionalidades como adicionar, remover, exibir e salvar produtos.

## Tecnologias Utilizadas

- **Java Swing**: Para criar a interface gráfica do usuário.
- **Coleções Java**: Uso de `HashMap` e `ArrayList` para gerenciar os dados do estoque.
- **Manipulação de Arquivos**: Exportação dos dados para um arquivo CSV com `PrintWriter`.

## Funcionalidades

1. **Adicionar Produto**: Adiciona um novo produto ao estoque, verificando se o nome ou ID já existem.
2. **Remover Produto**: Remove um produto selecionado pelo usuário.
3. **Exibir Produtos**: Mostra todos os produtos do estoque em uma tabela.
4. **Salvar Estoque**: Salva os dados do estoque em um arquivo CSV.

## Como Executar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.
2. Compile os arquivos `.java` na pasta `src`:
   ```sh
   javac -d bin src/*.java
   ```
3. Execute o programa:
```
  java -cp bin GerenciadorDeEstoque
```
## Exemplo de Uso
Ao executar o programa, você verá um menu com as seguintes opções:

```
1 - Adicionar Produto ou Atualizar
2 - Remover Produto
3 - Verificar Produtos
4 - Salvar Estoque
0 - Sair
```
* Escolha a opção desejada e siga as instruções exibidas na tela.
* Para salvar o estoque, insira o nome do arquivo (ex.: estoque.csv).

# Estrutura do Arquivo CSV
O arquivo CSV gerado terá o seguinte formato:
```
Nome,Quantidade,Valor,ID
cebola,1,1,1
```
## Personalização
Se desejar alterar a estrutura do projeto, você pode modificar o arquivo .vscode/settings.json para ajustar os caminhos de saída e dependências.

## Dependências
Este projeto utiliza apenas bibliotecas padrão do Java e não requer dependências externas.

## Contribuição
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades. Basta abrir um pull request ou relatar problemas.

## Licença
Este projeto é de uso livre e não possui uma licença específica.

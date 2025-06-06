# Roteiro_Sala

## Erros de Lógica:
### DoublyLinkedList:
* Na linha 25 do código original, a condição para comparar os dados do nó com o dado que vai ser inserido na lista estava com a lógica invertida. O método esperara que os elementos fossem inseridos de forma crescente, porém era inserido de forma decrescente.

### Main: 
* Na linha 13 do código original, era esperado que fosse impresso na tela o resultado da função "printBackward", porém não era usado a função de "System.out.println()".

## Erro que ferem os conceitos de Orientação a objetos:
### Node:
* Na classe Node foi implementado o método "hashCode".
* Não era usado os modificadores de visibilidade para os atributos da classe e nem os métodos acessores e modificadores. Foi implementado essas mudanças para satisfazer o conceito de encapsulamento.
### DoublyLinkedList: 
* Não era usado os modificadores de visibilidade para os atributos da classe e nem os métodos acessores e modificadores. Foi implementado essas mudanças para satisfazer o conceito de encapsulamento.

## Otimizações: 
### DoublyLinkedList:
* Foi criado um ponteiro para a cauda da lista encadeada que facilita as operações de inserção e remoção de elementos no final da lista.
* No método insertOrdered, a estrutura do método foi modificada para satisfazer todos os cenários de inserção e abranger o ponteiro da cauda da lista.
* No método "printForward" e printBackward, foi implementado o StringBuilder ao invés de String, para facilitar a construção da mensagem de retorno final.
* No método printBackward, o laço while da linha 52 do código original foi removido. A função agora passa a usar o apontador para a cauda da lista para facilitar a construção da mensagem de retorno do método. 
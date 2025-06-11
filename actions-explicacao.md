#### Resposta
Como o nome sugere, um *workflow* (fluxo de trabalho) é um sequencia de etapas que se repetem durante a execução de uma tarefa. No contexto de Desenvolvimento de software, usamos este termo para se referir a um código que viza a automatizar estes fluxos de trabalho, agrupando etapas e definindo quais gatilhos (ou ações) irão dar inicio a um determinado fluxo.

Em contrapartida, *Actions* (ações) correspondem a etapas distintas destes fluxos, ações unicas e modulares que usamos para construir um fluxo, como por exemplo validação, testagem, build, deploy. Um workflow em geral possui diversas Actions, e diferentes workflows podem ter como uma de suas etapas a mesma action, isso porque estas ações são modulares. 

Internamente, tanto actions quanto workflows podem ser configuradas usando arquivos `.yaml`. No caso de uma action, ela é definida por suas propriedades **Input**, **output** e **run**.

###### Exemplo
Exemplo de como um workflow chama uma action, extraido no arquivo `ci.yaml` no job `test`

``` yaml
- name: Configurar Java             # Nome que o workflow da a esta etapa do fluxo
    uses: actions/setup-java@v3     # Caminho para a ação que queremos chamar
    with:                           # Palavra chave para a passagem de parametros (input)
        java-version: '21'          # Nome_do_parametro : valor do parametro (input)
        distribution: 'temurin'
```
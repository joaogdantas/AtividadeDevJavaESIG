# Projeto - Pessoas e Salários

Este projeto foi desenvolvido como parte de um teste técnico para desenvolvedor Java na ESIG. Ele utiliza Java e JSF (JavaServer Faces) com PrimeFaces para criar uma página web que lista informações de pessoas com salários calculados e consolidados.

#### Tecnologias necessárias
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/tomcat-000000?style=for-the-badge&logo=apache&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

### Pontos de avaliação
1. Criar uma aplicação Web Java, usando a especificação JSF (JavaServer Faces)
com uma tela de Listagem de Pessoas, onde deve constar as informações
consolidadas na tabela pessoa_salario_consolidado, após a realização do cálculo
dos salários (item 2). :white_check_mark:

2. Implementação do cálculo dos salários das pessoas, com uma opção na tela acima
para calcular / recalcular salários. :white_check_mark:

## Funcionalidades Implementadas

- Lista de pessoas com seus salários consolidados
- Cálculo de salários por pessoa com base em informações de outras tabelas forcenidas (como pessoa, cargo, vencimentos e suas relações etc.)
- Testes unitários

## Executando Localmente

Para executar este projeto localmente, siga estas instruções:

1. Clone este repositório:

```bash
git clone https://github.com/joaogdantas/AtividadeDevJavaESIG.git
```

2. Navegue até o diretório do projeto:
```
cd AtividadeDevJavaESIG
```

3. Compile o projeto:
```
mvn package
```

4. Implante o arquivo WAR gerado no seu servidor Tomcat(Recomenda-se usar a versão 8.5 do Tomcat, pois versões superiores podem causar problemas de compatibilidade.)

5. Acesse a aplicação no navegador web, geralmente em:
```
http://localhost:8080/nome_do_contexto_da_aplicacao
```

Substitua o nome do contexto pelo nome do contexto do seu build. Por padrão: 
```
atividade-esig-joaogdantas-0.0.1-SNAPSHOT
```

Este projeto foi desenvolvido como parte de um teste técnico e pode conter áreas que podem ser melhoradas ou otimizadas. Sinta-se à vontade para explorar, modificar e contribuir. Busco sempre evoluir como desenvolvedor e ouvir outras opiniões e ideias.
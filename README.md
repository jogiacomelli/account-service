# account-service

Parte do projeto desenvolvido para o [desafio-banco-java](https://github.com/rh-southsystem/desafio-java-banco).

Como executar a aplicação:
        
  1. Executar o docker do servidor do RabbitMq:
  ```
  docker run -d --hostname local-rabbit --name rabbit-mq -p 15672:15672 -p 5672:5672 rabbitmq:3.6.9-management
  ```

      http://localhost:15672
      username: guest
      password: guest

  2. Executar cada um dos projetos abaixo com o maven:
    ``` mvn spring-boot:run```
        - [user-service](https://github.com/jogiacomelli/user-service)
          * Executa na porta 9191
        - [account-service](https://github.com/jogiacomelli/account-service)
          * Executa na porta 9192
        - [service-registry]https://github.com/jogiacomelli/service-registry
          * Executa na porta 8761
        - [cloud-gateway](https://github.com/jogiacomelli/cloud-gateway)
          * Executa na porta 8989

  3. Acessar a aplicação:
      - Criação de usuário:
        * Post no endpoint http://localhost:8989/user
          ```
          {
              "type": "PF",
              "document": "0031231231987",
              "name": "Joseane Brondani",
              "score": 9
          }
          ```
      - Listagem de usuários:
        * Get no endpoint http://localhost:8989/user
      - Listagem de contas criadas:
        * Get no endpoint http://localhost:8989/account
        

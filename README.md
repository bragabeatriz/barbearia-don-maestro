Barbearia Don Maestro - Projeto Java Spring Boot (H2) + Frontend (static)
--------------------------------------------------------------------------

Como executar:

1. Tenha Java 17+ e Maven instalados.
2. Dentro da pasta do projeto, rode:
   mvn spring-boot:run
3. Abra http://localhost:8080 para ver o frontend elegante (preto e amarelo).
4. Console H2 disponível em http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:barbearia
   User: sa
   Password: (vazio)

O projeto inclui endpoints REST em /api/appointments para listar, criar e deletar agendamentos.
# barbaria-don-maestro

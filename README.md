🎾 Sports Manager
Projeto full-stack desenvolvido como forma de estudo, para aprender como as diferentes tecnologias que compõem um software, interagem entre si. 

Para o Frontend foram usadas tecnologias como:
React e Tailwind CSS. 
Para o Backend foram usadas tecnologias como:
Java & Spring Boot, Spring Security & JWT,Spring Data JPA / Hibernate e Maven
Como ferramenta de integração e testes foi usado Postman

🚀 Como Executar o Projeto Localmente
Para correres este servidor na tua máquina, precisas do Java 17+ e de uma base de dados relacional devidamente configurada.

Navega para a pasta do projeto backend:

Bash
cd backend
Instala as dependências e arranca a aplicação utilizando o wrapper do Maven:

Bash
./mvnw spring-boot:run
O servidor iniciará por defeito na porta 8080.

🧪 Testes de API com o Postman
Como este projeto é puramente uma API RESTful, a interação principal é feita via Postman.

Para rotas públicas (ex: criar conta ou fazer login), podes enviar um pedido POST diretamente com os dados no formato JSON.

Para rotas protegidas (ex: criar uma reserva), deves primeiro efetuar o login para obteres o Token JWT. De seguida, no Postman, acede ao separador Authorization, escolhe Bearer Token e cola o token recebido antes de enviares o novo pedido.

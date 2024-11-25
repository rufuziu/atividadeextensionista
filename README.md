"APLICATIVO WEB PARA APRIMORAMENTO DO ENSINO BÁSICO"  

Esse é um projeto de um aplicativo Web com a intenção  
de melhorar e auxiliar o acesso à educação de  
qualidade no Brasil.  

## Notas do desenvolvedor

O projeto ainda está na versão de protótipo,  
cada funcionalidade está separada por pastas.  

## Instruções

O projeto está configurado para rodar em containers docker.

Há um script (build_microservices_and_run_docker_compose.bat) desenvolvido para o ambiente Windows que irá realizar todo o processo de build de dependências e "up" dos containers.

É necessário ter conhecimento prévio nas seguintes linguagens:  
- front-end:  
-Web (HTML,CSS,JavaScript);  
-Vue.js;  
-Quasar.       
   
- back-end:  
-Java 17;  
-SpringBoot;     
-MongoDB.   

- outros:
-Docker

O front-end e o back-end estão configurados para  
trabalhar em sincronia com algumas exceções.

Para visualizar o projeto é necessário estar com os containers em execução.

Visualizar o front-end:  
- Acessar "http://localhost:80".

Visualizar o back-end:  
- Acessar "http://localhost:8081/swagger-ui/index.html" para o microsserviço de registro e autenticação.
- Acessar "http://localhost:8082/swagger-ui/index.html" para o microsserviço de níveis de ensino, áreas de conhecimento e matérias.
- Acessar "http://localhost:8083/swagger-ui/index.html" para o microsserviço de lições/aulas.
- Acessar "http://localhost:8084/swagger-ui/index.html" para o microsserviço de exercícios.

Visualizar o banco de dados em Mongo:
- Acessar através de um software de gerenciamento de banco de dados "mongodb://localhost:27018/"

___
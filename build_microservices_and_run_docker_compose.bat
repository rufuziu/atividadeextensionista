@echo off

:: Lista dos micro serviços
set ms-register-and-auth=microservices/ms-register-and-auth
set ms-knowledgearea-and-subjects=microservices/ms-knowledgearea-and-subjects
set ms-classes=microservices/ms-classes
set ms-exercises=microservices/ms-exercises

:: Build de cada micro serviço
echo Building %ms-register-and-auth%...
cd %ms-register-and-auth%
call mvnw install
cd ../..

echo Building %ms-knowledgearea-and-subjects%...
cd %ms-knowledgearea-and-subjects%
call mvnw install
cd ../..

echo Building %ms-classes%...
cd %ms-classes%
call mvnw install
cd ../..

echo Building %ms-exercises%...
cd %ms-exercises%
call mvnw install
cd ../..

:: Subir o Docker Compose
echo Starting Docker Compose...
docker-compose up -d
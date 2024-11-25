# Etapa 1: Construção da aplicação Vue.js
FROM node:18 AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY package*.json ./

# Instalar as dependências
RUN npm install

# Copiar o código fonte da aplicação
COPY . .

# Construir a aplicação Vue.js
RUN npm run build

# Etapa 2: Servir a aplicação com Nginx
FROM nginx:alpine

# Copiar os arquivos compilados do Vue.js para o diretório do Nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Expor a porta 80 para acessar a aplicação
EXPOSE 80

# Iniciar o Nginx
CMD ["nginx", "-g", "daemon off;"]
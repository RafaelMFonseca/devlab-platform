# Devlab platform

IDE oficial para escrever código JavaScript: Visual Studio Code \
IDE oficial para escrever código Java: Visual Studio Code ou Eclipse (VSCode é o recomendado)

---

### Configurando o ambiente

> - Faça download da última versão do OpenJDK: https://jdk.java.net/13/ (clique em Windows / x64 zip (sha256) )
> - Extraia o OpenJDK para alguma pasta, de preferência em "C:\Program Files\Java\"
> - Faça download da última versão do Maven: https://maven.apache.org/download.cgi ( clique em apache-maven-x.x.x-bin.zip )
> - Extraia o Maven para alguma pasta
> - Crie a variável de ambiente JAVA_HOME apontando para a pasta do Java
> - Crie a variável de ambiente MAVEN_HOME apontando para a pasta do Maven

![Variáveis de ambiente](https://i.ibb.co/T0D289B/devlab-vars.png)

Se o ambiente ainda persistir com erros, vá até `File -> Preferences -> Settings` do VSCode, pesquise pela configuração `java home` e preencha com o caminho da instalação do Java, faça o mesmo com a configuração do Maven: `maven user settings`, mas indicando o caminho do arquivo `conf/settings.xml` do Maven.

---

### Extensões do VSCode necessárias para executar o projeto

#### VSCode Java pack:
https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack \
Utilizado para compilar o Java, debbugar código Java e para executar comandos do Maven.

#### EditorConfig:
https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig \
Utilizado para sincronizar arquivos .editorconfig (está no projeto) com sua workspace do vscode.
Ele indica como os arquivos serão indentados, se irá inserir uma linha no final do arquivo, os encodings, etc...

### Outras extensões opcionais que ajudam no desenvolvimento:
- vscode-icons
- Bracket Pair Colorizer 2
- GitLens

---

### Configurando uma instância do MySQL e iniciando por linha de comando

> - Faça download da última versão do MySQL Community: https://dev.mysql.com/downloads/mysql/
> - Extraia para alguma pasta
> - Inicialize o MySQL com o seguinte comando e execute apenas uma vez: 
```
bin\mysqld --initialize-insecure --user=root
pause
```
> - Para iniciar o mysql crie um arquivo .bat com o seguinte conteudo:
```
bin\mysqld
pause
```
> - Execute o .bat e altere o arquivo `persistence.xml` de acordo com sua conexão
> - O usuário será root e a senha é vazia

~~ou use o instalador do Mysql~~

---

### Inicializando a plataforma web

> - Navegue até a pasta web \
> `cd web`
> - Faça download dos pacotes \
> `npm install`
> - Inicie o servidor do Angular CLI \
> `ng serve`

--- 

### Inicializando o servidor

> - Navegue até a pasta web \
> `cd api` 
> - Para iniciar o servidor HTTP, abra o arquivo App.java: \
> `CTRL + P > App.java`
> - Inicie o projeto em modo debug \
> `F5`

### Gerando chave SSH para autenticar no GitHub

Rode os seguintes comandos no Git Bash:

> - Configure o usuário e senha do seu git ( é o que aparece nos commits )
> - `git config --global user.name "Your Name"`
> - `git config --global user.email "your_email@example.com"`
> - Para verificar se as alterações foram aplicadas:
> - `git config --list`
> - Gere uma chave RSA
> - `ssh-keygen -t rsa -b 4096 -C "your_email@example.com"`
> - O comando irá pedir o local para salvar e a chave secreta, apenas aperte enter para seguir com o valor padrão
> - Acesse: https://github.com/settings/keys e clique em `New SSH key`
> - Vá ao local da chave gerada, abra o arquivo com extensão .PUB com o bloco de notas, copie o seu conteúdo e registre no github.
> - Faça clone do repositório ou adicione a URL remota a um repositório vazio e faça pull.
> - Inicie o agente SSH
> - `eval $(ssh-agent -s)`
> - Adicione a chave SSH gerada ao agente
> - `ssh-add ~/.ssh/id_rsa`
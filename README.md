![Logo](https://i.ibb.co/fqMmdfV/loho-keytracker.png)

# Keytracker: Registrador de Teclas

Aplicação desenvolvida como trabalho final da disciplina de Linguagem de Programação II do curso de Ciência da Computação. Tem como função registrar as teclas digitadas pelo usuário.

## Objetivos Gerais
Demonstrar a fragilidade da segurança no mundo tecnológico, promover a concientização e prevenção contra possíveis falhas e descuidos deixadas por usuários.

## Objetivos Específicos
A aplicação tem como objetivo extrair todas a teclas digitadas pelo usuário no seu teclado, armazenado-as em um banco de dados online que será de acesso do atacante. As teclas são registradas a partir do momento que o usuário aperta no botão ligar, na tela principal do programa.

## Bibliotecas Utilizadas
* [JAVAFX](https://openjfx.io) - Interface Gráfica
* [JNativeHook](https://github.com/kwhat/jnativehook) - Captura do teclado
* [MySQLConnector](https://dev.mysql.com/downloads/connector/j) - Conexão com o banco de dados
* [FXTrayIcon](https://github.com/dustinkredmond/FXTrayIcon) - Executar a aplicação em segundo plano

## Stack Utilizada

* **Figma** - Prototipação
* **JAVA** - Linguagem de programação
* **SceneBuilder** - Criação da interface gráfica JAVAFX
* **NetBeans** - IDE
* **MySQL** - Banco de dados
* **Railway** - Gerenciador do banco de dados
## Instalação

É necessário adicionar as bibliotecas citadas no tópico `Bibliotecas Utilizadas`. Também se deve instalar o [JAVAFX](https://openjfx.io) no Netbeans ou na IDE que será usada.

### Configurações da IDE

#### 1° Importe o projeto para o Netbeans
#### 2° Importe a biblioteca JAVAFX para o seu projeto

```
  Clique no projeto com o botão direito -> Properties -> Libraries -> importe a biblioteca clicando no sinal + do Classpath
```
```
Adicione as demais bibliotecas citadas clicando em Add JAR/Folder
```
```
Ainda na opção Libraries vá na opção Run e adicione a biblioteca JAVAFX ao ModulePath
```

### Configurações do banco de dados
#### 1° Criar o banco a partir do arquivo
```
Dentro da pasta dataBase do projeto abra o arquivo e copie as query's para seu gerenciador de banco de dados de sua preferência
```
Nesse caso sugiro o [Railway](https://railway.app/). Gerenciador de banco de dados online e de fácil utilização.
```
No Railway, logue com o GitHub e crie uma data base MySQL, execute as query's
```
```
Na aba de connection copia os dados e substitua nas strings da classe DAO, conforme já está no código
```

#### Após concluídos os passos acima, poderá executar a aplicação.
### O uso da aplicação é estritamente para fins educacionais. Seu uso de forma indevida a fim de prejudicar o próximo anula qualquer responsabilidade por parte do desenvolvedor.

## Autores

- [@mauricioprb](https://www.github.com/mauricioprb)

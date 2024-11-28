# **MVC - Model View Controller**

## **Descrição**
Padrão de arquitetura de software que divide as responsabilidades em partes principais.

---

## **Estrutura do MVC**

### **1. Model**
Representa **APENAS** os dados e sua estrutura, sendo um reflexo da tabela no Banco de Dados.

#### Subcomponentes:
- **Repository**:  
  Centraliza a lógica de acesso ao Banco de Dados, possuindo métodos específicos para consultas e operações.  

- **ServiceLayer**:  
  Onde as regras de negócio são implementadas.  
  - Exemplo:  
    Em vez de colocar no Model uma lógica como "um usuário só pode fazer login se estiver ativo", essa regra é implementada no serviço.  

### **2. View**
Responsável por exibir informações para o usuário e capturar intenções.

### **3. Controller**
Atua como orquestrador, recebendo as requests e chamando os métodos do **ServiceLayer**.  
- **Nota:** Não possui lógica de negócio significativa.

---

## **Annotations**

### **`USER.java`**
- **@Document()**:  
  Marca a classe como um documento que será armazenado em uma coleção do MongoDB.  

- **@Id**:  
  Indica que o atributo anotado é o identificador único da entidade no Banco de Dados.  

- **@JsonFormat**:  
  Utilizada para formatar a serialização e desserialização de um campo durante a conversão entre Java e JSON (utilizada com a biblioteca Jackson no Spring Boot).  

- **@Override**:  
  Indica a sobrescrita de um método pela classe filha.  

### **`USERCONTROLLER.java`**
- **@RestController**:  
  Composição de duas anotações no Spring Boot:  
  - **@Controller**  
  - **@ResponseBody**  
  Marca a classe como uma controladora REST, recebendo requisições HTTP e retornando respostas no formato JSON ou XML.  

- **@RequestMapping**:  
  Mapeia requisições HTTP para métodos específicos dentro de um Controller.  
  - Quando aplicada a uma classe, define a URL base para todos os métodos dessa classe.  

- **@Autowired**:  
  Indica Injeção de Dependência, um padrão de projeto para deixar o código desacoplado.  

#### Métodos Específicos do Mapping:
- **@GetMapping**  
- **@PostMapping**  
- **@PutMapping**  
- **@DeleteMapping**  
  Cada um realiza o mapeamento de requisições HTTP específicas (GET, POST, PUT, DELETE).  

- **@Query**:  
  Permite especificar a query no formato JSON.  
  - Quando o método for chamado, o comando será realizado no MongoDB.  

---

## **Outros Conceitos**

- **Optional<User>**:  
  Objeto container em Java, introduzido no Java 8 como parte do pacote `java.util`.  
  - Criado para facilitar a manipulação de valores nulos no código.  

- **ResponseEntity<?>**:  
  Representa uma resposta HTTP, incluindo Status, Body e Header.  
  - Utilizado para enviar uma resposta personalizada ao usuário que está consumindo a API.  

- **Header**:  
  Os cabeçalhos de uma requisição HTTP são informações adicionais passadas juntamente à requisição.  
  - Estrutura: Conjunto de pares **Chave:Valor**.  

- **Extends**:  
  Exclusivamente para herança entre classes e interfaces.  

- **Implements**:  
  Exclusivamente para implementação de interfaces.  

---

## **Exceptions**

- **RunTimeException**:  
  Pertence ao grupo de exceções não verificadas em Java.  

---

## **Notas e Observações**

1. **Autowired**:  
   Implementa a lógica de Injeção de Dependência.  

2. **Autenticação de Usuários**:  
   Apenas usuários maiores de 18 anos podem ser autenticados.  

3. **Tratamento de Exceção**:  
   Testar se o sistema permite atualizar um registro que não existe.  

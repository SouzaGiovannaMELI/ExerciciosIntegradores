# Student Controller

## Caso de Uso 1: Registrar Estudante

```
@PostMapping("/registerStudent")
public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {
    this.studentService.create(stu);
    return ResponseEntity.ok(null);
}
```

 - Recebe um estudante e valida se ele atende aos requisitos definidos no model
 - Executa o método create do studentService, mandando como parâmetro o estudante
 - (Se tudo der certo) é retornado o status ok;

### Teste 1: Dados do estudante inválidos (< Parametro > não fornecido)

 - Lançar uma exception do tipo: *MethodArgumentNotValidException*

### Teste 2: Dados do estudante inválidos (< Parametro > fora dos padrões exigidos)

- Lançar uma exception do tipo: *MethodArgumentNotValidException*

### Teste 3: Sucesso

 - Retornar código *200*

<hr>

## Caso de Uso 2: Pegar um estudante pelo id

```
@GetMapping("/getStudent/{id}")
public StudentDTO getStudent(@PathVariable Long id) {
    return this.studentService.read(id);
}
```

 - Recebe um id do tipo Long na URL da requisição
 - Executa o método read do studentService passando o id como parâmetro
 - (Se tudo der certo) deve ser retornado o estudante com o id correspondente

### Teste 1: Formato do id incompativel

 - Deve ser lançado um *Bad Request 400*

### Teste 2: Estudante não encontrado

 - Deve ser lançado um *StudentNotFoundException 404*

### Teste 3: Sucesso

 - Deverá ser retornado o *Estudante* e um status *200*

<hr>

## Caso de Uso 3: Atualizar um estudante

```
@PostMapping("/modifyStudent")
public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {
    this.studentService.update(stu);
    return ResponseEntity.ok(null);
}
```

- Recebe um estudante e valida se ele atende aos requisitos definidos no model
- Executa o método create do studentService, mandando como parâmetro o estudante
- (Se tudo der certo) é retornado o status ok;

### Teste 1: Dados do estudante inválidos (< Parametro > não fornecido)

- Lançar uma exception do tipo: *MethodArgumentNotValidException*

### Teste 2: Dados do estudante inválidos (< Parametro > fora dos padrões exigidos)

- Lançar uma exception do tipo: *MethodArgumentNotValidException*

### Teste 3: Sucesso

- Retornar código *200* e validar se os dados retornados são os mesmos que os enviados

<hr>

## Caso de Uso 4: Deletar um estudante

```
@GetMapping("/removeStudent/{id}")
public ResponseEntity<?> removeStudent(@PathVariable Long id) {
    this.studentService.delete(id);
    return ResponseEntity.ok(null);
}
```

 - Recebe um id do tipo long
 - Executa o método delete do studentService
 - (Se tudo der certo) é retornado um status *200*

### Teste 1: Formato do id incompativel

- Deve ser lançado um *Bad Request 400*

### Teste 2: Estudante não encontrado

- Deve ser lançado um *StudentNotFoundException 404*

### Teste 3: Sucesso

- Deverá ser retornado o *Estudante* e um status *200*

<hr>

## Caso de Uso 5: Listar todos os estudantes

```
@GetMapping("/listStudents")
public Set<StudentDTO> listStudents() {
    return this.studentService.getAll();
}
```

 - Será executado o método getAll do studentService
 - Deverá ser retornada uma lista com todos os estudantes

### Teste 1: Sucesso

 - Deverá ser retornado uma *lista de estudantes* e status *200*
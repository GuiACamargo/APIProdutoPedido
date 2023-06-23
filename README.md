# APIProdutoPedido
Estudo de Rest API com Spring Boot

## Info
- API com JWT, se cadastre no sign up e utiliza seu email e senha geradas aleatoriamento no sign in

## Integrantes
- Guilherme Camargo
- Júlia Parizotto

## Endpoints
Link api:

### Autenticação
- Sign in: /auth/signin
`
{
    "email": ,
    "senha":
}
`
- (Senha gerada automaticamente) Sign up: /auth/signup
`
{
    "nome": ,
    "email":
}
`

### Usuário
- GET ALL: /usuarios
- DELETE: /usuarios/{id}
- GET por ID: /usuarios/{id}
- PUT por ID: /usuarios/{id}
`
{
    "nome": ,
    "email": ,
    "senha": 
}
`
- POST: /usuarios
`
{
    "nome": ,
    "email": ,
    "senha":
}
`

### Produto
- GET ALL: /produtos
- DELETE: /produtos/{id}
- GET por ID: /produtos/{id}
- PUT por ID: /produtos/{id}
`
{
    "nome": ,
    "email": ,
    "senha": 
}
`
- POST: /produtos
`
{
    "nome": ,
    "descricao": ,
    "unidadeMedida": ,
    "valorUnitario":
}
`

### Pedido
- GET ALL: /pedidos
- DELETE: /pedidos/{id}
- GET por ID: /pedidos/{id}
- PUT por ID: /pedidos/{id}
`
{
    "data": "YYYY-MM-DDTHH:MM:SS.123Z",
    "produto": {
        "id": ,
        "nome": ,
        "descricao": ,
        "unidadeMedida": ,
        "valorUnitario": 
    },
    "quantidade":
}
`
- POST: /produtos
`
{
    "data": "YYYY-MM-DDTHH:MM:SS.123Z",
    "produto": {
        "id": ,
        "nome": ,
        "descricao": ,
        "unidadeMedida": ,
        "valorUnitario": 
    },
    "quantidade":
}
`

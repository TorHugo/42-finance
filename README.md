
# _**42Finance**_:

## Descrição:
- O ponto principal da plataforma 42Finance, é ajudar nossos usários a terem um melhor controle sobre seus gastos e dívidas. Fazendo assim com que eles possam ter uma estabilidade financeira maior. E em paralelo queremos trazer um módulo de educação financeira, para que eles, saibam não só como gerenciar seus gastos monetários, mas também, consigam entender e de certa forma, queremos "traduzir" questões do mundo financeiro, para que os mesmos, consigam ter uma vida financeira saudavel e independente.  

## Versão:
- v0.0.1-SNAPSHOT 


## _**Stack utilizada**_:
- **_Back-end:_** 
    - **Linguagem**: Java;
    - **Banco de dados**: H2;
    - **Framework**: SpringBoot. 
    
- **_Dependencias utilizadas_**:
    - Spring Data JPA;
    - H2 Database;
    - Spring-web;
    - Validation;
    - Lombok.

## _**Rotas e métodos**_
### _**Category**_:

- **New _Category_**:

```http
  POST /categories
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | Nome da nova categoria. |
| `description` | `String` | Descrição da categoria. |
| `monthlyBudget` | `BigDecimal` | Orçamento destinado a categoria. |

```json
    {
        "name": "Fooding1",
        "description": "Categorie desined fooding.",
        "monthlyBudget": 750.0
    }
```

- **FindById _Category_**:

```http
  GET /categories/{idCategory}
```

| Retorno     |
| :---------- |

```json
    {
        "id": 1,
        "name": "Fodding",
        "description": "Category desined fooding.",
        "monthlyBudget": 700.00,
        "dateInclusion": "2023-04-01T20:35:18",
        "dateUpdate": null,
        "totalSpend": 200.00,
        "lsBalance": [
            {
                "dateInclusion": "2023-04-01T20:35:18",
                "dateUpdate": null,
                "idBalance": 1,
                "description": "Adding salary amount.",
                "balanceValue": 200.00,
                "additionDate": "2023-03-27",
                "typeBalance": "PAYIN",
                "typePayment": "CREDIT_CARD"
            }
        ]
    }
```

### _**Balance**_:

- **New _Balance_**:

```http
  POST /balances
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `idCategory` | `Long` | Id referente a categoria de destino. |
| `description` | `String` | Descrição do balanço adicionado. |
| `balanceValue` | `BigDecimal` | Valor adicionado. |
| `additionDate` | `LocalDate` | Data do recebido (não necessáriamente será a data em que for adicionado). |
| `typeBalance` | `String` | Tipo do balanço (Entrada ou Saída). |
| `typePayment` | `String` | Tipo monetário (débito, credito, pix, etc) do valor adicionado. |

```json
    {
        "idCategory": 1,
        "description": "Adding salary amount.",
        "balanceValue": 7150.0,
        "additionDate": "2023-02-18",
        "typeBalance": "PAYIN",
        "typePayment": "CREDIT_CARD"
    }
```

- **FindAll _Balances_**:

```http
  GET /balances
```

| Retorno     |
| :---------- |

```json
    {
        "totalEntry": 2900.00,
        "totalExit": 2500.00,
        "lsBalance": [
                {
                    "dateInclusion": "2023-04-01T20:35:18",
                    "dateUpdate": null,
                    "idBalance": 1,
                    "description": "Adding salary amount.",
                    "balanceValue": 2500.00,
                    "additionDate": "2023-03-27",
                    "idCategory": 1,
                    "typeBalance": "PAYOUT",
                    "typePayment": "BANK_TRANSFER"
                },
                {
                    "dateInclusion": "2023-04-01T20:35:18",
                    "dateUpdate": null,
                    "idBalance": 2,
                    "description": "Adding salary amount.",
                    "balanceValue": 2900.00,
                    "additionDate": "2023-03-27",
                    "idCategory": 3,
                    "typeBalance": "PAYIN",
                    "typePayment": "PIX"
                }
            ]
    }
```

### _**Debts**_:

- **New _Debt_**:

```http
  POST /debts
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `Long` | Breve nome da dívida (Ex: "Conta de água"). |
| `debtAmount` | `BigDecimal` | Valor da divida. |
| `monthInterest` | `BigDecimal` | Valor do juros por mês. |
| `dateDue` | `LocalDate` | Data de vencimento. |

```json
    {
        "name": "Pagamento de conta de água",
        "debtAmount": 250.0,
        "monthInterest": 1.0,
        "dateDue": "2023-03-30"
    }
```

- **FindAll _Debts_**:

```http
  GET /debts
```

| Retorno     |
| :---------- |

```json
    [
        {
            "id": 1,
            "name": "Pagamento conta de água",
            "debtAmount": 164.00,
            "monthInterest": 1.0,
            "dateDue": "2023-03-27",
            "dateInclusion": "2023-04-01T20:35:18",
            "dateUpdate": null
        },
        {
            "id": 2,
            "name": "Pagamento conta de luz",
            "debtAmount": 300.00,
            "monthInterest": 1.0,
            "dateDue": "2023-03-28",
            "dateInclusion": "2023-04-01T20:35:18",
            "dateUpdate": null
        }
    ]
```

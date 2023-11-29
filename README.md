# Тестовое задание Unibell
### Backend на Spring Boot

### API reference

**1) Добавление нового клиента**
````
POST /api/client
{
    "name": string, required
    "phones": array of strings
    "emails": array of strings
}
````
Пример:
````
POST /api/client
{
    "name": "Большая компания",
    "phones": [
        "+74956541654",
        "+79534546456"
    ],
    "emails": [
        "sale@company.com"
    ]
}
````
Ответ (полная информация о новосозданном клиенте):
````
{
    "id": 1,
    "name": "Большая компания",
    "phones": [
        "+74956541654",
        "+79534546456"
    ],
    "emails": [
        "sale@company.com"
    ]
}

````
**2) Добавление нового контакта клиента (телефон или email)**
````
POST /api/client/{id}/contact
{
    "type": required, "phone" or "email"
    "data": required
}
id: ИД клиента для которого добавляем контакт

````
Пример:
````
POST /api/client/1/contact
{
    "type": "email",
    "data": "vacancy@company.com"
}
````
Ответ (полная информация о новосозданном контакте):
````
{
    "id": 4,
    "type": "email",
    "data": "vacancy@company.com"
}

````
**3) Получение списка клиентов**
````
GET /api/client
````
Пример ответа (список клиентов):
````
{
    "items": [
        {
            "id": 1,
            "name": "Большая компания"
        },
        {
            "id": 2,
            "name": "Средняя компания"
        }
    ]
}

````
**4) Получение информации по заданному клиенту (по id)**
````
GET /api/client/{id}
id: ИД клиента для которого запрашиваем информацию
````
Пример:
````
GET /api/client/1
````
Ответ (полная информация о клиенте):
````
{
    "id": 1,
    "name": "Большая компания",
    "phones": [
        "+74956541654",
        "+79534546456"
    ],
    "emails": [
        "sale@company.com",
        "vacancy@company.com"
    ]
}

````
**5) Получение списка контактов заданного клиента**
````
GET /api/client/{id}/contact
id: ИД клиента для которого запрашиваем контакты
````
Пример:
````
GET /api/client/1/contact
````
Ответ (список контактов):
````
{
    "items": [
        {
            "id": 1,
            "type": "phone",
            "data": "+74956541654"
        },
        {
            "id": 2,
            "type": "phone",
            "data": "+79534546456"
        },
        {
            "id": 3,
            "type": "email",
            "data": "sale@company.com"
        },
        {
            "id": 4,
            "type": "email",
            "data": "vacancy@company.com"
        }
    ]
}

````
**6) Получение списка контактов заданного типа заданного клиента**
````
GET /api/client/{id}/contact/{type}
id: ИД клиента для которого запрашиваем контакты
type: тип контактов, "phone" или "email"
````
Пример:
````
GET /api/client/1/contact/phone
````
Ответ (список контактов):
````
{
    "items": [
        {
            "id": 1,
            "type": "phone",
            "data": "+74956541654"
        },
        {
            "id": 2,
            "type": "phone",
            "data": "+79534546456"
        }
    ]
}

````

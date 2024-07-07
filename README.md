# CRUD-application
Этот проект представляет собой CRUD приложение для управления товарами на складе.

## Запуск проекта

Для запуска проекта выполните следующие шаги:

1. **Клонирование репозитория:**

    Клонируйте репозиторий:
   ```bash
   git clone -b develop https://github.com/Synberg/CRUD-application.git
   ```

2. **Сборка проекта с помощью Maven:**

    Убедитесь, что у вас установлен Maven, затем выполните:
    ```bash
    mvn clean install -DskipTests
    ```
3. **Запуск приложения с помощью Docker Compose**

    Установите Docker, затем выполните:
    ```bash
    docker-compose up
    ```

## Получение всех товаров

Метод: GET

URL: http://localhost:8080/api/products

## Получение товара по идентификатору

Метод: GET

URL: http://localhost:8080/api/products/{id}

## Создание нового товара:

Метод: POST

URL: http://localhost:8080/api/products

Пример тела запроса (JSON):
```bash
{
  "name": "Новый товар",
  "article": "ART001",
  "description": "Описание нового товара",
  "category": "Категория",
  "price": 999.99,
  "quantity": 10
}
```

## Обновление существующего товара

Метод: PUT

URL: http://localhost:8080/api/products/{id}

## Удаление товара

Метод: DELETE

URL: http://localhost:8080/api/products/{id}

## Дополнительные требования
1. Подключен Swagger: http://localhost:8080/swagger-ui/index.html
2. В качестве первичного ключа использован UUID
3. Реализована валидация полей запросов (на null, пустоту и т.д.)
4. В проект помещена коллекция Postman с запросами
5. Написан dockerfile для создания образа приложения
6. Написаны Javadocs и инструкция по запуску приложения

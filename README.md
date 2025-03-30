## VK Bot

Бот цитирует присланный ему текст

Для его работы необходимо прописать следующие проперти в application.properties

* VK_API_ENDPOINT - эндпоинт вк апи
* VK_API_VERSION - версия ВК АПИ

И cледующие проперти в docker-compose.yml 

* VK_CONFIRMATION_CODE - строка, которую должен вернуть сервер
* VK_SECRET - секретый ключ Callback API
* VK_ACCESS_TOKEN - ключ доступа сообщества
* NGROK_AUTHTOKEN - ключ доступа ngrok

Следующая команда запускает контейнеры с приложением бота и ngrok 
```
docker-compose up --build  
```


# МС3 сервис
Принимает сообщения из apache kafka, добавляет третью дату и время и отсылает post запросом на MC1

## Запуск
Перед запуском убедитесь, что запущены все контейнеры из группы mctwo. Если нет, сначала запустите docker-compose второго микросервиса.

Для зупуска
- docker-compose up
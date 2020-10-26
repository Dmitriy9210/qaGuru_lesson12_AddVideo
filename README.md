# tests.TestsAlfaBank
Проект реализован на selenid + junit5 + allure

Тестирование хедера главной страницы "https://alfabank.ru/"

Запуск тестов происходит из командной строки.

Команды для запуска тестов:
* gradle clean alfaTest - запуск всех тестов в классе
* gradle clean searchTest - запуск тестов с тегом "search"
* gradle clean clickTest - запуск тестов с тегом "click"


Есть возможность просмотр allure отчета:
 - со скринами ошибок
 - с page sourse страниц
 - с логами ошибок
 
 Запуск Allure отчета:
1) Выполнить загрузку Allure - gradle downloadAllure
2) Выполнить команду для формирования отчета - gradle allureServe 

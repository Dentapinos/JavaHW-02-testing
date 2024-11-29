
# Hi, I'm Dentapinos! 👋


# Домашнее задание №2 - О тестировании

Создал три обьекта Club, Dancer, Security. Club имеет два метода letPass - который дает разрешение на вход, и letOut - дает разрешение на выход если нет задолженности у обьекта Dancer. Dancer - является обьектом посетителя, имеет поле id, по умолчанию 0, но при разрешении входа присваивается порядковый номер входа как id. Security - имеет два метода, isAllowedPass - делает проверку на день недели, дресскод, вместительность в зале, в определенные дни вместительность выше на 20 vip-мест. Метод isAllowedOut - проверяет есть ли задолженность у танцора, и в случаее ее отсутствия дает разрешение на выход из клуба.



## Тесты

Для тестирования я применил библиотеку Mockito и AssertJ. Тестировал класс Club. C Помощью возможностей Mockito заглушил классы Dancer и Security. Добавил описание на каждый тест с помощью аннотации @DisplayName. Тест shouldAllowLetPassForDancer и shouldBanLetPassForDancer тестирует метод letPass, и проверяет удачный и не удачный вход в клуб. Тест shouldAllowLetOutForDancer и shouldBanLetOutForDancer тестируют удачный и не удачный выход из клуба. mustCallMethodFromTheSecurityClassOnce этот тест проверяет а единажды ли вызван метод isAllowedOut из класса Security. Тест shouldThrowExceptedExceptionWhenDependencyReturnNullInstatedOfDancer проверяет выбрасывание исключения DancerNotFoundException

## Lessons Learned
Я научился тестировать приложение с помощью фреймворка Mockito

## Authors

- [@Dentapinos](https://github.com/Dentapinos)


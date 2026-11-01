📱 Mobile Tests (Wikipedia)

Репозиторий содержит тесты для мобильного приложения Wikipedia. Проект вынесен отдельно от [основного репозитория Aviasales](https://github.com/H1ghOctane/AVIASALESDEGREE), так как использует другой стек (Appium) и тестирует стороннее приложение для демонстрации навыков мобильной автоматизации.

✅ Стек
- Java 17
- Gradle
- JUnit 5
- Selenide (Appium)
- BrowserStack
- Owner
- Allure Report

✅ Тесты

В пакете `mobile.tests` реализованы проверки:
1. **Поиск статьи:** открытие поиска, ввод запроса ("Dinosaur"), проверка наличия результатов.
2. **Открытие статьи:** клик по первому результату, проверка, что заголовок статьи отображается.

Тесты параметризованы для запуска на двух платформах:
- Android (тег `@Tag("android")`)
- iOS (тег `@Tag("ios")`)

📸 Визуализация тестов

https://jenkins.qa.guru/job/MOBILE_H1GHT0CTANE/3/allure/
![Jenkins Build Success]()
![Android "SearchIphoneTest" test]

<video controls width="100%">
  <source src="https://github.com/H1ghOctane/MOBILEREST/issues/2" type="video/mp4">
</video>

<video src="https://github.com/user-attachments/assets/MOBILEREST/issues/2" controls="controls" width="100%"></video>

<video src="https://github.com/user-attachments/assets/H1ghOctane/MOBILEREST/issues/2" controls="controls" width="100%"></video>

[![Посмотреть видео работы теста](https://img.shields.io/badge/▶_Смотреть_видео-Android-green?style=for-the-badge&logo=android)](https://github.com/H1ghOctane/MOBILEREST/issues/2)

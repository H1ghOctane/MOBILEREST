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

📁 Структура
```text
src/test/java
├── mobile
│   ├── config      // BrowserstackConfig, ConfigManager
│   ├── drivers     // AndroidBrowserstackDriver, IosBrowserstackDriver
│   ├── helpers     // AllureAttachments, Browserstack, Screenshot
│   └── tests       // SearchAndroidTest, SearchIphoneTest
└── resources
    └── config      // browserstack.properties

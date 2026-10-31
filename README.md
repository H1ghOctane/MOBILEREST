 Mobile Tests (Wikipedia)
<p align="center">
  <img src="https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80" alt="Mobile Testing" width="100%" style="border-radius: 10px;"/>
</p>
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

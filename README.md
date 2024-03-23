E2E тест-сценарий (позитивный)

**Тестовые данные**:
тестовый юзернейм = standard_user
тестовый пароль = secret_sauce

**Шаги**:
1. Открыть https://www.saucedemo.com 
2. Ввести тестовый юзернейм в поле Username 
3. Ввести тестовый пароль в поле Password
4. Нажать кнопку Login 
5. Нажать кнопку AddCard у товара из списка
6. Перейти в Корзину
7. Нажать кнопку Checkout
8. Ввести корректные данные в поле First Name (e.g. John)
8. Ввести корректные данные в поле Last Name (e.g. Doe)
8. Ввести корректные данные в поле Zip/Postal Code(e.g. 123432)
9. Нажать кнопку Continue
10. Нажать кнопку Finish


**Ожидаемый результат:**

Отображаются следующие элементы:

Тайтл страницы:
Checkout: Complete!

Текст на страницы (хэдер):
Thank you for your order!

Сообщение на странице:
Your order has been dispatched, and will arrive just as fast as the pony can get there!

Кнопка: Back Home




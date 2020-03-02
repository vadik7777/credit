**Практическое задание для соискателя**

Реализовать веб-приложение &quot;Кредитный калькулятор&quot;, который в зависимости от параметров введенных пользователем, а также заданных параметров кредита, рассчитывает аннуитетный график погашения кредита в виде таблицы:

Номер платежа - Месяц/Год  - Платеж по основному долгу -  Платеж по процентам - Остаток основного долга - Общая сумма платежа

Вводимые пользователем данные:

- Сумма кредита - допустимые значения от 100 000 до 5 000 000
- Срок кредита в месяцах - от 12 до 60

Параметры кредита (отображаются клиенту, но недоступны для изменения):

- годовая процентная ставка в % - от 12.9% до 23.9%

Формулы для расчета

Рассчитать месячный аннуитетный платеж можно по следующей формуле:

x=S*(P+ P/((1+P)^N-1))=S P/(1-〖(1+P)〗^(-N) )  где

x – месячный платёж, S – первоначальная сумма кредита, P – (1/12) процентной ставки в абсолютной величине, т.е. при 14.9% годовых ставка будет 0.149/12, N – количество месяцев.

Для расчета процентной составляющей аннуитетного платежа, нужно остаток кредита на указанный период умножить на годовую процентную ставку и всё это поделить на 12 (количество месяцев в году).

, где pn – начисленные проценты, Sn – остаток задолженности на период, P - годовая процентная ставка по кредиту

В первый месяц остаток задолженности = сумме кредита.

Чтобы определить часть, идущую на погашение долга, необходимо из месячного платежа вычесть начисленные проценты.

s = x – pn, где s – часть выплаты, идущая на погашение долга, x – месячный платёж,  ![](data:image/*;base64,/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAPABMDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD1HxNr93oP9nG20z+0Ptl0tt5McpWYsefkXYVOFWRiXZFATrzVvRtTm1EXkN1bJb3llP8AZ50ilMse4xpICrlVJG2ReqjnI5ABOTqenanrPi63CtqOmWOnwO0N7CbZ1nmfaDhZA5Uqu4BtmTvcZUffr+MLtvCnhi1/sid7N45y4IjWYSKiSTzCTedzlkjlOQwZnK5cZZqAOxorM8OXM154Y0m6uLpLuaazhkkuI1KrKxQEuAQpAJOcYHXoOlFAH//Z)— начисленные проценты, на момент n-ой выплаты

В расчетах необходимо использовать округление к ближайшему целому до двух знаков после запятой.

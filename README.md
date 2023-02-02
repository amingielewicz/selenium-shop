## Scenariusze testowe: 

### 1. Weryfikacja tytułu strony z logowaniem do konta.

#### Warunki wstępne: 
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/). 
- Przeglądarka Chrome, w trybie Incognito.

| **Opis kroku**                                                                      | **Oczekiwany efekt**                                                                                       |
|---------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **MOJE KONTO**. <br/>Zweryfikuj tytuł aktualnej strony. | Znajdujesz się na ekranie logowania. <br/>Tytuł strony to: Moje konto – Selenium Shop Automatyzacja Testów. |

### 2. Weryfikacja poprawności zalogowania (sprawdzenie czy po zalogowaniu uzyskaliśmy dostęp do właściwego konta).

#### Warunki wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/). 
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                                                    | Oczekiwany efekt                                                                                           |
|-----------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **MOJE KONTO**. <br/>Zweryfikuj tytuł aktualnej strony.      | Znajdujesz się na ekranie logowania. <br/>Tytuł strony to: Moje konto – Selenium Shop Automatyzacja Testów. |
| Do pola Login wprowadź wartość: _UserTest3_.                                                  | Wprowadzona wartość w polu Login: _UserTest3_.                                                             |
| Do pola Hasło wprowadź wartość: _HasloTestowe3_                                               | Wprowadzona wartość w polu Hasło: _HasloTestowe3_.                                                          |                                                        
| Kliknij przycisk ZALOGUJ SIĘ. Zweryfikuj czy zostałeś przekierowany na ekran: **MOJE KONTO**. | Zostałeś zalogowany, znajdujesz się na ekranie **MOJE KONTO**.                                                |                                             
| Zweryfikuj czy nazwa konta do którego zostałeś zalogowany to: _Jan Testowy3_.                 | Nazwa konta to: _Jan Testowy3_.                                                                             |                                        
  
### 3. Nowy, zalogowany, użytkownik – weryfikacja braku konfiguracji adresu dostawy.

#### Warunki wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/)
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                                                                                                                                               | Oczekiwany efekt                                                                                                             |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **MOJE KONTO**. <br/>Zweryfikuj tytuł aktualnej strony.                                                                                                 | Znajdujesz się na ekranie logowania. <br/>Tytuł strony to: _Moje konto – Selenium Shop Automatyzacja Testów_.                |
| Do pola Login wprowadź wartość: _UserTest3_.                                                                                                                                             | Wprowadzona wartość w polu Login: _UserTest3_.                                                                               |
| Do pola Hasło wprowadź wartość: _HasloTestowe3_.                                                                                                                                         | Wprowadzona wartość w polu Hasło: _HasloTestowe3_.                                                                           |                                                        
| Kliknij przycisk **ZALOGUJ SIĘ**. <br/>Zweryfikuj czy zostałeś przekierowany na ekran: **MOJE KONTO**.                                                                                   | Zostałeś zalogowany, znajdujesz się na ekranie **MOJE KONTO**.                                                               |                                             
| Z menu bocznego wybierz pozycję Adresy. <br/>Zweryfikuj czy w sekcji Adres do wysyłki widoczny jest komunikat: _Nie ustawiłeś jeszcze tego adresu, który oznacza brak dodanych adresów_. | W sekcji Adres do wysyłki, brak jest dodanych adresów. <br/>Wyświetlony jest komunikat: _Nie ustawiłeś jeszcze tego adresu_. |

### 4. Nowy, zalogowany użytkownik – weryfikacja poprawności dodania adresu dostawy.

### Wymagania wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/)
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                                                                                                                                                                                                                     | Oczekiwany efekt                                                                                                                                                                                |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **MOJE KONTO**. <br/>Zweryfikuj tytuł aktualnej strony.                                                                                                                                                                       | Znajdujesz się na ekranie logowania. <br/>Tytuł strony to: _Moje konto – Selenium Shop Automatyzacja Testów_.                                                                                          |
| Do pola Login wprowadź wartość: _UserTest3_.                                                                                                                                                                                                                   | Wprowadzona wartość w polu Login: _UserTest3_.                                                                                                                                                  |
| Do pola Hasło wprowadź wartość: _HasloTestowe3_.                                                                                                                                                                                                               | Wprowadzona wartość w polu Hasło: _HasloTestowe3_.                                                                                                                                              |                                                        
| Kliknij przycisk **ZALOGUJ SIĘ**. Zweryfikuj czy zostałeś przekierowany na ekran: **MOJE KONTO**.                                                                                                                                                              | Zostałeś zalogowany, znajdujesz się na ekranie **MOJE KONTO**.                                                                                                                                  |                                             
| Z menu bocznego wybierz pozycję Adresy. <br/>Z sekcji Adres do wysyłki kliknij opcję Dodaj.                                                                                                                                                                    | Znajdujesz się na ekranie dodawania Adresu wysyłki.                                                                                                                                             |
| Wprowadź wartość do pól: <br/> **Imię = Jan**; <br/> **Nazwisko = Testowy** <br/> **Region = Polska** <br/> **Ulica = Słoneczna 7** <br/> **Kod pocztowy = 00-001** <br/> **Miasto = Warszawa** <br/> I zatwierdź operację klikając przycisk **ZAPISZ ADRES**. | Adres został zapisany. <br/>Znajdujesz się na stronie Adresy. <br/>W sekcji Adres do wysyłki widoczny wprowadzony adres: <br/> **Jan Testowy2** <br/> **Słoneczna 7** <br/> **00-001 Warszawa** |

### 5. Nowy, zalogowany użytkownik – weryfikacja braku przypisanych do konta zamówień.

### Wymagania wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/)
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                                                                                                                                        | Oczekiwany efekt                                                                                              |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **MOJE KONTO**. <br/>Zweryfikuj tytuł aktualnej strony.                                                                                          | Znajdujesz się na ekranie logowania. <br/>Tytuł strony to: _Moje konto – Selenium Shop Automatyzacja Testów_. |
| Do pola Login wprowadź wartość: _UserTest3_.                                                                                                                                      | Wprowadzona wartość w polu Login: _UserTest3_.                                                                |
| Do pola Hasło wprowadź wartość: _HasloTestowe3_.                                                                                                                                  | Wprowadzona wartość w polu Hasło: _HasloTestowe3._                                                            |                                                        
| Kliknij przycisk **ZALOGUJ SIĘ**. Zweryfikuj czy zostałeś przekierowany na ekran: **MOJE KONTO**.                                                                                 | Zostałeś zalogowany, znajdujesz się na ekranie **MOJE KONTO**.                                                |                                             
| Z menu bocznego wybierz pozycję Zamówienia.                                                                                                                                       | Znajdujesz się na ekranie złożonych zamówień.                                                                 |
| Zweryfikuj czy na stronie jest widoczny komunikat: "_Żadne zamówienia nie zostały jeszcze złożone_", który świadczy o tym, że do konta nie są przypisane jeszcze żadne zamówienia | Na stronie widoczny komunikat: "_Żadne zamówienia nie zostały jeszcze złożone_"                               |


### 6. Lista Produktowa – weryfikacja liczby wyświetlanych produktów.

### Wymagania wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/)
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                      | Oczekiwany efekt                                |
|-----------------------------------------------------------------|-------------------------------------------------|
| Z głównego menu wybierz pozycję: **SKLEP**.                     | Znajdujesz się na ekranie listy produktów.      |
| Zweryfikuj czy na liście produktów jest dokładnie 12 produktów. | Lista produktów zawiera dokładnie 12 produktów. |

### 7. Lista Produktowa – weryfikacja operacji sortowania produktów.

### Wymagania wstępne:
- Przejdź na stronę: [www.selenium-shop.pl](http://www.selenium-shop.pl/)
- Przeglądarka Chrome, w trybie Incognito.

| Opis kroku                                                                                                                                             | Oczekiwany efekt                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|--------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Z głównego menu wybierz pozycję: **SKLEP**.                                                                                                            | Znajdujesz się na ekranie listy produktów.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| Z listy służącej do sortowania produktów, wybierz pozycję: Sortuj wg ceny: od najniższej. <br/> Zweryfikuj czy produkty zostały właściwie posortowane. | Produkty zostały posortowane od najniższej ceny do najwyższej. <br/> Poprawna kolejność: <br/>**- Piłka nożna KIPSTA F100** <br/> **- Koszulka Newcastle FC United** <br/> **- Koszulka West Ham United** <br/> **- Piłka nożna Adidas Replika Liga Mistrzów** <br/> **- Piłka nożna Adidas Euro 2020** <br/> **- Koszulka Tottenham Hotspur F.C.** <br/> **- Koszulka Arsenal London** <br/> **- Koszulka Chelsea London** <br/> **- Koszulka Manchester United** <br/> **- Koszulka Manchester FC City** <br/> **- Koszulka Liverpool FC** <br/> **- Koszulka Leicester FC City** |

___________________________________________________________________________________________
___________________________________________________________________________________________

## Projekt
### Page 1
HomePage.java
- Przekierowanie do **MOJE KONTO**
- Przekierowanie do **SKLEP** 
### Page 2
LoginPage.java
- Wypełnienie pól login oraz hasło.
- Kliknięcie w przycisk zaloguj.

### Page 3
LoginAccount.java
- Pobranie danych zalogowanego profilu.

### Page 4
AccountPage.java
- Pobranie nazwy konta.
- Przejście na kolejne PageObject -> zamówienia.
- Przejście na kolejne PageObject -> adresy.

### Page 5
AddressPage.java
- Przejście na kolejne PageObject -> dodanie/edytowanie adresu dostawy.
- Pobranie i zwrucenie komunikatu dotyczącego istnienia adresu dostawy.

### Page 6
OrderConfirmedPage.java
- Pobranie i zwrócenie komunikatu o liczbie złożonych zamówień.

### Page 7
DeliveryAddresDetailsPage.java
- Wypisanie wartości tekstowej w pole Imię 
- Wypisanie wartości tekstowej w pole Nazwisko 
- Wypisanie wartości tekstowej w pole Region 
- Wpisanie wartości tekstowej w pole Ulica
- Wpisanie wartości tekstowej w pole Kod pocztowy
- Wpisanie wartości tekstowej w pole Miasto 
- Kliknięcie przycisku: Zapisz adres 
- Metoda wykonująca pełną akcję uzupełnienia formularza adresy dostawy. Metoda zwraca stronę AddressPage.

### Page 8
ProductListPage.java 
- Pobranie i zwrócenie ilości produktów 
- Wybranie z listy sortującej pozycji: Sortuj wg ceny: od najniższej
- Sortowanie listy po cenie od najniższej
- Pobranie przesortowanej listy produktów 
- Wypianie produktów do konsoli

____________________________________________________________________________

### Test 1
LoginShopTest
Test weryfikujący czy dane zalogowane profilu są poprawne.
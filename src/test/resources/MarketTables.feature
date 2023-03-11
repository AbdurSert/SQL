@malzemeler

Feature: Market database'indeki tablolarin dogrulanmasi

  Background:
    Given Kullanici database'e erisim saglar

  Scenario: Toplam urun sayisinin bulunmasi

    When Kullanici mlzemeler tablosuna gider
    Then Kullanici tablodaki toplam urun sayisni dogrular

  Scenario: Fiyati en yuksek urunun bulunmasi

    When Kullanici mlzemeler tablosuna gider
    Then KUllanici tablodan fiyati en yuksek urunu bulur ve dogrular

  Scenario: Tablodan bir urunun isminin degistirilmesi

    When Kullanici mlzemeler tablosuna gider
    Then Kullanici urulerden birinin ismini degistirip dogrular

  Scenario: Tablodaki urunlerin fiyatinin ortalamsinin alinmasi

    When Kullanici mlzemeler tablosuna gider
    Then Kullanici urunlerin toplam fiyatinin ortalamsini bulup dogrular

  Scenario: Tablodaki urunlerin farkli sekillerde manipule edilmsei

    When Kullanici mlzemeler tablosuna gider
    And Kullanici urunlerin basliklarini yazdirir
    And Kullanici urun isimlerinin harflerini hepsi buyuk olacak sekilde yazdirir
    And Kullanici urun isimlerinin harflerini hepsi kucuk olacak sekilde yazdirir
    And Kullanici urun isimlerinin ilk harfleri buyuk olacak sekilde yazdirir
    And Kullanici fiyati 10 dan kucuk olanlari isme ve fiyata gore azalacak sekilde siralar, yazdirir
    Then Kullanici tabloyu kapatir






# ImdbCom-UI-Test

Selenium, allure ve Log4j framework kullanarak birkaç senaryo üzerinden UI Test projesi oluşturdum. Test sonuçlarının raporlanması için Log4j, monitoring edilmesi için de allure yapısını kullandım. Bu proje Web Sitesinin(IMDB) girilen parametrelere film arama kontrollerinin yapıldığı ve bunların yönetilmesini sağlayan monitoring logging yardımıyla çok amaçlı olarak isteğe göre değiştirilebilir bir projedir.

## Kullanılan Teknolojiler

- Java (Projenin yazılmış olduğu kodlama dilidir);
- TestNG(Test Caselerin yazılması ve çıktıların kontrollerinde kullanılan Test Yazım Aracıdır);
- Selenium (Web Sitesini test etmek için kullanılan Test Otomasyon Aracıdır);
- Allure (Test Sonuclarının monitorize edilmesini sağlar);
- Log4J (Hata sonuçlarının loglanmasını sağlar);
- Page Object Pattern (Projede kullanılan mimari yapıdır).

## Proje Yapısının Açıklanması

Projede aşşağıda açıkladığım yapıyı kullandım;

![image](https://user-images.githubusercontent.com/56224909/155900864-58b3616a-5bfd-4b13-8a95-5d39b64ea4b7.png)

+ **Base:** BaseClass, BasePage ve Constants sınıflarının bulunduğu klasör.
  + **BaseClass** Bu sınıf içerisinde driverı ayağa kaldırma, ilk url girme ve driver sonlandırma işlemleri yapıldı.
  + **BasePage** Bu sınıf driverları ortak bir sınıfa bağlıyor.
  + **Constants** Bu sınıf içerisinde projede kullanılan sabit değişkenler tanımlandı.

![image](https://user-images.githubusercontent.com/56224909/192666028-3f666184-b243-467b-a4be-332781913c0a.png)


+ **Helpers** Sistemde birden fazla yerde kullanılacağını düşündüğüm metodları bu klasör altında topladım. Böylelikle kod tekrarını önleyip okunaklığı arttırabileceğini düşündüm. Helpers klasörü altında; ActionClass, CustomElementWaits, DataHelpers, Listeners ve Log sınıfları bulunur.
  + **ActionClass:** Sayfa aksiyonlarının artması durumunda(moveTo gibi) işimizi kolaylaştırabilecek bir yapıdır. Şuanki tek amacı elementleri görünür olana dek sayfayı harekeket ettirmektir.
  + **CustomElementWaits:** Sayfa Yüklenirken geç gelen elementleri beklememizi kolaylaştıran bir sınıftır(clickable, visibility ve findall gibi).
  + **DataHelpers:** Listelerden random bir şekilde eleman çekmemize yarayan bir sınıftır.
  + **Listeners:** Projede bulunan caseleri dinleyen bir yapıdır.
  + **Log:** Loglama yapmamızı sağlayan bir yapıdır.
  
![image](https://user-images.githubusercontent.com/56224909/192666169-82c5b15e-7164-4bee-97a0-8507f82cb72f.png)
+ **HttpRequest** HttpRequest klasörünün yaratılma sebebi http işlemlerini tek bir klasör altına toplamaktır.
  + **HttpRequest:** HttpRequest sınıfında sayfa üzerinde bulunan fotoğraf linklerini kontrol eden bir fonksiyon bulunmaktadır.
  
![image](https://user-images.githubusercontent.com/56224909/192666547-de5b4a78-9cd3-461e-812a-e74444d2690c.png)

+ **Model** Model klasörünün yaratılma sebebi projede bulunan modelleri tek bir yapı altında toplamaktır.
  + **Movie** Movie sınıfının görevi ImdbCom üzerinde aratılacak filmin model yapısını oluşturmaktır.
  
![image](https://user-images.githubusercontent.com/56224909/192666770-88654674-87d2-4787-aba8-b2ed52eb7f45.png)

+ **Pages:** Pages klasörünün yaratılma sebebi Pape Object Pattern kalıbını uygulamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde; IMDB Ana sayfası, Film Sayfası, Oscar Alan Filmler Sayfası, Film Fotoğrafları Sınıfı ve Arama Sonucu Çıkan Filmler Sınıfı bulunur.
  + **HomePage** İlk karşılaşılan sayfadır. IMDB Ana Sayfasında ki menu işlemleri için kullanılır.
  + **MoviePage** İstenilen filmin sayfasıdır. Filmin temel bilgilerine bu sayfada ulaşılır.
  + **OscarsPage** Ana Sayfada menu üzerinden "Oscars" butonuna tıklandığında karşılaşılan sayfasıdır. Oscar almış filmler listelenir.
  + **PhotosPage** Film Sayfasında fotoğraflar butonuna tıklandığında karşılaşılan sayfadır. Filmin tüm fotoğraflarının bulunduğu sayfadır. Fotoğrafların yüklendiği kontrolü bu sayfada yapılır.
  + **SearchResultsPage** IMDB Ana Sayfasında arama yapıldıktan sonra gelen sayfadır. Parametre sonucu çıkan filmler bu sayfada listelenir.

![image](https://user-images.githubusercontent.com/56224909/155901930-a4f6ff9b-96be-4f7b-b245-73a914a10fe4.png)

+ **Retry** Bu klasör içerisinde RetryAnalyzer sınıfı bulunmaktadır. Bu sınıf testler sırasında hata alan testleri bizim verdiğimiz parametrele göre yeniden çalıştırır.

![image](https://user-images.githubusercontent.com/56224909/192667870-30af9a83-10c5-4e39-a11d-0abf1528be4f.png)

+ **testCases** Test Caselerimizin bulunduğu klasördür.
  **ImdbComUITestCases** İçerisinde Imdb UI Sayfalarında gerçekleşecek test caseler bulunur.
  
![image](https://user-images.githubusercontent.com/56224909/155902026-ba430ae3-d50f-4cae-be15-ad3b1a5be437.png)

+ **resources** Properties dosyları ve testng.xml dosyları bulunur.
  + **allure.properties** allure kayıtlarını yönlendiren sınıftır.
  + **log4j.properties** log4j kullanarak log dosyası oluşturma standartlarını ayarladığımız sınıftır.
  + **testng.xml** testlerin koşumunu sağlayan bir xml dosyası.

## Projenin Ayağa Kaldırılması

1. İlk olarak projede bulunan constants sınıfı içerisinde değişiklik yapılmalıdır. Değişken değerleri değiştirilmeliki proje de kendi login işlemlerinizigerçekleştirebilesiniz. log4j.properties ve allure.properties dosyalarında kendi pathlerinizi ayarlayabilirsiniz.
2. BaseClass içerisinde driver kaldırma sırasında bilgisayarınızda ki driver pathlerini vermemiz gerekir.
3. Allure monitoring kullanmak isterseniz de bilgisayarınızda allure'nin yüklü olması gerekiyor.

## Allure Monitoring Kullanımı

Allure yapısı caseler her tamamlandıktan sonra belirtilen path e kaydediliyor. Bunları görüntülemek için komut satırını açıp "allure serve [config dosyasında ayarladığınız path]\allure-results" girerseniz browserda açılan pencere üzerinde detaylı inceleme yapabilirsiniz.

![image](https://user-images.githubusercontent.com/56224909/192668008-4d5931e3-2c72-4e7b-92cc-2d5a8c48a783.png)

## Örnek Ekran Çıktıları

- Log Yapısının Örnek çıktısı:

![image](https://user-images.githubusercontent.com/56224909/192668114-e9aa67af-0cf1-445d-b09d-d54c2a9fc183.png)

- Allure Ekran Görüntüsü

![image](https://user-images.githubusercontent.com/56224909/192668191-7d0f0995-6387-48f3-94f5-15471c940186.png)

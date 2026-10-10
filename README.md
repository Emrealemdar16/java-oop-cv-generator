# Java OOP ile PDF Özgeçmiş (CV) Oluşturucu

Bu proje, Nesne Yönelimli Programlama (OOP) prensipleri temel alınarak Java dilinde geliştirilmiş bir otomatik özgeçmiş (CV) oluşturma uygulamasıdır. Konsol üzerinden çalıştırıldığında, bellekte oluşturulan kişi nesnesindeki verileri işleyerek profesyonel tasarıma sahip bir `.pdf` dosyası çıktısı üretir.

## 🛠️ Kullanılan Bileşenler, Nesneler ve Tercih Nedenleri

Proje, sorumlulukların ayrılması (Separation of Concerns) prensibine uygun olarak monolitik bir `main` metodu yerine, yapısal parçalara ve sınıflara bölünmüştür.

### 1. Person Sınıfı ve Nesnesi (Veri Modeli)
* **Ne işe yarar?** Kişiye ait ad, iletişim bilgileri, fotoğraf dosya yolu ve iş deneyimlerini tutar.
* **Neden kullanıldı?** Kapsülleme (Encapsulation) prensibini uygulamak için. Veriler `private` erişim belirleyicisi ile dışarıdan rastgele değiştirilmeye karşı korunmuş, erişimler ve veri atamaları `public` getter/setter metotları ile kontrollü hale getirilmiştir.

### 2. ResumeGenerator Sınıfı ve Nesnesi (İş Yükü - İşlem Sınıfı)
* **Ne işe yarar?** Veri modelini (`Person` nesnesi) alarak, dışarıdan dahil edilen kütüphaneler yardımıyla PDF dosyasını çizen ve diske kaydeden işçi sınıftır.
* **Neden kullanıldı?** Projenin modüler olması için. Dosya yazma (I/O) işlemleri, sayfa kenar boşlukları ve font/renk gibi tasarımsal kütüphane bağımlılıkları tamamen bu sınıfın içine izole edilmiştir.

### 3. Main Sınıfı (Çalıştırıcı)
* **Ne işe yarar?** Programın giriş noktasıdır. Nesnelerin yaşam döngüsünü (Lifecycle) başlatır.
* **Neden kullanıldı?** `new` anahtar kelimesi ile nesneleri bellekte (Heap alanı) örneklendirmek, aralarındaki ilişkiyi kurmak ve iş akışını tetiklemek için kullanılmıştır. İşlem bittiğinde Garbage Collector (Çöp Toplayıcı) nesneleri bellekten temizler.

### 4. iText (Kütüphane / Harici Bileşen)
* **Ne işe yarar?** Kod içerisindeki String verileri ve görsel yollarını okuyarak vektörel PDF sayfalarına dönüştürür.
* **Neden kullanıldı?** Java ekosisteminde belge manipülasyonu için en çok standartlaşmış, kararlı çalışan ve modüler yapıya en uygun kütüphane olduğu için tercih edilmiştir (pom.xml üzerinden Maven ile projeye dahil edilmiştir).

## 🚀 Kurulum ve Çalıştırma

1. Projeyi bilgisayarınıza klonlayın veya indirin.
2. Projenin Maven yapılandırmasını içerdiğinden emin olun (`pom.xml` üzerinden iText kütüphanesi otomatik çekilecektir).
3. `emre.jpeg` isimli profil fotoğrafının proje ana dizininde bulunduğunu doğrulayın.
4. IDE (VS Code, IntelliJ, Eclipse) üzerinden `Main.java` dosyasını çalıştırın.
5. `Huseyin_Emre_Alemdar_CV.pdf` dosyası ana dizine üretilecektir.

---
*Bu proje Kırklareli Üniversitesi Nesne Yönelimli Programlama dersi kapsamında geliştirilmiştir.*

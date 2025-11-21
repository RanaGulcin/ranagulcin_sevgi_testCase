# 🤖 QA Engineer Otomasyon Görevi

## ✨ Proje Özeti
Bu proje, Insider firmasının web sitesi üzerindeki **Kariyer Sayfası (Careers Page)** iş akışını otomatize etmek amacıyla tasarlanmıştır. Görev, belirli bir pozisyonun (Quality Assurance) belirli bir lokasyonda (Istanbul, Turkey) listelenip listelenmediğini kontrol etmeyi ve başvuru formuna yönlendirmeyi içermektedir.

Geliştirme, modern otomasyon standartlarına uygun olarak **Page Object Model (POM)** mimarisi ile gerçekleştirilmiştir.

---

## 🛠️ Kullanılan Teknolojiler ve Frameworkler
Bu otomasyon projesi, yüksek performans ve okunabilirlik sağlamak için aşağıdaki teknoloji yığını kullanılarak geliştirilmiştir:

| Kategori | Teknoloji | Açıklama |
| :--- | :--- | :--- |
| **Programlama Dili** | **Java** | Temel test kodlaması için kullanılmıştır. |
| **Otomasyon Aracı** | **Selenium WebDriver** | Tarayıcı etkileşimleri ve web element kontrolü için standart otomasyon kütüphanesi. |
| **Test Frameworkü** | **TestNG** | Testlerin yürütülmesi, raporlanması ve organizasyonu için kullanılmıştır (BDD framework'leri kullanılmamıştır). |
| **Tasarım Deseni** | **Page Object Model (POM)** |Kodun temiz, yeniden kullanılabilir ve sürdürülebilir olması sağlanmıştır. |
| **Element Bulma** | **Optimize Edilmiş CSS/XPath** | Hızlı ve güvenilir element bulucular kullanılmıştır. |

> 📌 **Not:** Görev gereksinimleri uyarınca **BDD (Behavior-Driven Development)** yaklaşımları (Cucumber, Quantum, Codeception, vb.) kullanılmamıştır.

---

## 🚀 Test Senaryosu
Bu otomasyon testi, Insider web sitesinde bir QA Engineer'ın yapacağı temel kariyer adımlarını doğrular. Testin temel amacı, Quality Assurance pozisyonlarının Istanbul, Turkey lokasyonunda doğru bir şekilde listelenip listelenmediğini kontrol etmektir.

Test Adımları (Görev Tanımına Göre)
Aşağıdaki adımlar, otomasyon kodu içinde sırasıyla uygulanmıştır:

* Ana sayfaya git ve https://useinsider.com/ adresinin açıldığını doğrula.
* Navigasyon çubuğundan "Company" menüsünü seç, ardından "Careers" seçeneğine tıkla.
* Kariyer sayfasının açıldığını ve Locations, Teams, Life at Insider bloklarının görünür olduğunu doğrula.
* https://useinsider.com/careers/quality-assurance/ adresine git, "See all QA jobs" düğmesine tıkla.
* İş listesi sayfasında Konum filtresini "Istanbul, Turkey" olarak ayarla.
* Departman filtresini "Quality Assurance" olarak ayarla.
* Listelenen işlerin varlığını ve içeriğini kontrol et.
* Listelenen tüm işlerin Position (Pozisyon) alanının "Quality Assurance" içerdiğini doğrula.
* Listelenen tüm işlerin Department (Departman) alanının "Quality Assurance" içerdiğini doğrula.
* Listelenen tüm işlerin Location (Konum) alanının "Istanbul, Turkey" içerdiğini doğrula.
* Herhangi bir işin yanındaki "View Role" düğmesine tıkla.
* Bu eylemin kullanıcıyı Lever Application Form sayfasına yönlendirdiğini doğrula.
> 📌 **Not: Her adımda başarısızlık durumunu yakalamak için Assertion mekanizmaları kullanılmıştır.

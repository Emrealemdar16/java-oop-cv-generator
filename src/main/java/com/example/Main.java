package com.example;

public class Main {
    public static void main(String[] args) {
        
        Person myProfile = new Person("Hüseyin Emre Alemdar", "alemdar1600@gmail.com", "05376748825", "emre.jpeg");

        myProfile.addExperience("2024-2026: Backend Yazılım Geliştirici - Garanti BBVA Teknoloji   (Java ve Spring Boot kullanılarak güvenli ödeme altyapılarının ve mikroservis mimarilerinin geliştirilmesi. ");
        myProfile.addExperience("2022-2024: Araç İçi Sistemler Yazılım Mühendisi - Togg   (C ve Java dilleriyle akıllı cihaz ekosistemi için mobilite servislerinin ve arayüz entegrasyonlarının kodlanması.");
        myProfile.addExperience("2020-2022: IoT Yazılım Geliştirme Uzmanı - Bosch Türkiye   (Endüstri 4.0 projeleri kapsamında gömülü sistemler ve Nesnelerin İnterneti (IoT) cihazları için veri analizi çözümleri.");

        ResumeGenerator generator = new ResumeGenerator();
        
        generator.createPdf(myProfile, "Hüseyin_Emre_Alemdar_Ozgecmis.pdf");
    }
}
package com.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String email;
    private String phone;
    private List<String> experiences;
    private String photoPath;

    public Person(String name, String email, String phone, String photoPath) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photoPath = photoPath;
        this.experiences = new ArrayList<>();
    }

    public void addExperience(String experience) {
        this.experiences.add(experience);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public List<String> getExperiences() { return experiences; }
    public String getPhotoPath() { return photoPath; }
}
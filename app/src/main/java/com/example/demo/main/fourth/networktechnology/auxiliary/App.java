package com.example.demo.main.fourth.networktechnology.auxiliary;

/**
 * Author: Eccentric
 * Created on 2024/5/22 17:30.
 * Description: com.example.demo.main.fourth.networktechnology.auxiliary.App
 */
public class App {
    private String id;
    private String name;
    private String version;

    public App() {
    }

    public App(String id, String name, String version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "App{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

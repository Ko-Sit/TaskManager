package com.qulix.sitkinke.trainingtask.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by upsit on 09.06.2017.
 */
public class Employee {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private List<Task> taskList;

    public Employee() {

    }

    public Employee(String surname, String name, String patronymic, String position){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.taskList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                ", patronymic = '" + patronymic + '\'' +
                ", position = " + position +'}';
    }
}
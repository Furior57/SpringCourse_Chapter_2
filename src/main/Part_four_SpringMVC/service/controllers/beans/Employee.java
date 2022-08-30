package main.Part_four_SpringMVC.service.controllers.beans;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    // Настраивается валидация с помощью аннотаций. Сейчас мы хотим указать, что минимальная длина
    // имени не может быть меньше трех символов, делать это мы будем с помощью аннотации @Size
    // передав в нее параметр min равный минимальному числу символов, есть так же параметр max.
    // Так же можно передавать параметр message приминающий строку, в этом параметре мы указываем
    // то сообщение, которое будет выведено при несоблюдении условия. Однако есть особенность,
    // если мы будем использовать русские символы, проверка не сработает, необходимо дополнительно
    // устанавливать локаль. Сейчас нам это не критично, при желании можно разобраться.
    // Теперь нам нужно отобразить это сообщение при несоблюдении условия,
    //  перейдем в ask-emp-details-view2 на 24 строку
    @Size(min = 2, message = "Name must be min 2 symbols!")
    private String name;
    // На этом поле мы установим ограничение, что оно не может быть пустым.
    // Существует аннотация @NotNull, однако если мы будем ее использовать, то никогда не получим
    // ошибку, даже если оставляем поле пустым, дело в том что в этом поле будет записан не null,
    // а пустой String с длиной 0. Для того чтобы проверять поле на "пустоту", существует другая
    // аннотация @NotEmpty, она сразу проверяет не null ли наше поле и не пустая ли строка.
    // Внутрь аннотации мы так же можем передать сообщение. Кстати, если сообщения не передавать,
    // то будут выведены дефолтные. Не забываем что в файле представления необходимо прописать
    // <form:errors path="surname"/>, чтобы ошибка выводилась на экран.
    // Однако аннотацию NotEmpty тоже можно обмануть, мы можем поставить там несколько пробелов.
    // При этом символы то есть, но увидеть мы их не сможем.
    // Для этого существует другая аннотация @NotBlank, она проверяет чтобы строка не состояла
    // из одних пробелов, эти аннотации можно комбинировать.
    @NotEmpty(message = "Surname is required field!")
    @NotBlank(message = "Surname is required field!")
    private String surname;

    private int salary;

    private String department;

    private String car;

    private String[] languages;

    private Map<String, String> carsList;

    public Employee() {
        carsList = new HashMap<>();
        carsList.put("BMW", "BMW");
        carsList.put("Audi", "Audi");
        carsList.put("Mercedes-benz", "Mercedes");
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getCarsList() {
        return carsList;
    }

    public void setCarsList(Map<String, String> carList) {
        this.carsList = carList;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}

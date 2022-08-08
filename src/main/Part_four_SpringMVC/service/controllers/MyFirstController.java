package main.Part_four_SpringMVC.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Первое, что мы должны сделать, это указать что наш класс - контролер, делается это аннотацией
// @Controller. Причем указывать что это компонент мы уже не должны, так как аннотация
// @Controller является разновидностью аннотации @Component.
@Controller
public class MyFirstController {
    // Теперь создадим метод с помощью которого будет вызываться наш view. Для начала мы поставим
    // аннотацию @RequestMapping, она указывает при каком адресе должен срабатывать наш метод.
    // Здесь мы указываем, что метод вызывается при любом обращении к нашему http серверу.
    @RequestMapping("/")
    public String showFirstView() {
        // Здесь могла быть наша логика, но мы просто вернем название view-файла который вернем.
        // Вспоминаем, что мы задали префикс и суффикс, теперь нам достаточно указать название файла.
        // Вернемся в Lesson_36 на 31 строку
        return "first-view";
    }

    // Мы определили два метода возвращающие разные view в ответ на разные запросы.
    // Теперь нам необходимо создать соответствующие view.
    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmployeeDetails() {
        return "show-emp-details-view";
    }

}

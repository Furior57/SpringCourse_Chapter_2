package main.Part_four_SpringMVC.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

// Первое, что мы должны сделать, это указать что наш класс - контролер, делается это аннотацией
// @Controller. Причем указывать что это компонент мы уже не должны, так как аннотация
// @Controller является разновидностью аннотации @Component.
@Controller
//@RequestMapping("/employee")
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

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails() {
//        return "show-emp-details-view";
//    }

    // Мы закомментировали метод showEmployeeDetails. Напишем новый.
    // Наша цель изменить то имя которое выводилось в сообщении. Как мы помним оно сохранено
    // в переменной в jsp файле.
//    @RequestMapping("/showDetails")
    // Прежде всего нам необходимо передать два параметра, первым идет интерфейс
    // HttpServletRequest, он отвечает за взаимодействие между сервером и клиентом и
    // облегчает получение данных. Нам он нужен, чтобы получить имя.
    // Второй параметр - интерфейс Model
//    public String showEmployeeDetails(HttpServletRequest request, Model model) {
//        // Получаем имя с помощью метода getParameter(), куда передаем строку с
//        // названием переменной где хранится наше имя.
//        String empName = request.getParameter("employeeName");
//        // Меняем имя
//        empName = "Mr. "+ empName;
//        // Добавляем в наш контейнер атрибут, первый параметр - имя атрибута, второй - значение.
//        // Чтобы использовать эти данные, в jsp файле, там где мы указывали имя параметра,
//        // мы просто укажем имя атрибута, который сюда записали, выглядеть это будет так:
//        // Your name: ${nameAttribute}, спринг сам подскажет все имена параметров.
//        model.addAttribute("nameAttribute", empName);
//
//        return "show-emp-details-view";
//    }
    // Есть и другой способ передавать параметры из jsp файла, для этого используется
    // аннотация @RequestParam, куда мы можем передать имя параметра. Эту аннотацию мы передаем
    // параметром в метод, в скобки аннотации передаем строку с названием переменной
    //  которую передаем, после указываем тип данных и название переменной уже в нашем методе.
        @RequestMapping("/showDetails")
    public String showEmployeeDetails(@RequestParam("employeeName") String empName,
                                      Model model) {
        empName = "Mr. "+empName;
        model.addAttribute("nameAttribute", empName);
        return "show-emp-details-view";
    }

}

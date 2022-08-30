package main.Part_four_SpringMVC.service.controllers;

import main.Part_four_SpringMVC.service.controllers.beans.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

// Здесь мы несколько поменяли сигнатуру контролера, чтобы не удалять первый. По-умолчанию у нас
// будет запускаться view описанный в первом контроллере, чтобы запустить этот нам надо будет
// вручную передать команду /askDetails2, а может быть потом и поправим на автоматический запуск.
@Controller
public class MySecondController {
    // У нас есть класс Employee в который можно записать все данные, которые нас интересуют.
    // Чтобы получить объект этого класса, мы параметром передадим сюда объект Model,
    // в который методом addAttribute() передадим свежесозданного Employee.
    // Здесь пока все, перейдем в ask-emp-details-view2.jsp
    @RequestMapping("/askDetails2")
    public String askEmployeeDetails(Model model) {

        model.addAttribute("employee", new Employee());


        return "ask-emp-details-view2";
    }
    // В первом view мы получили объект Employee и заполнили его поля. Здесь нам необходимо
    // передать этот объект во второй view
    @RequestMapping("/showDetails2")
    // Для этого мы параметром в метод передадим аннотацию @ModelAttribute в которой передадим
    // название атрибута в нашем Model и укажем его тип и имя. Теперь в следующем view
    // show-emp-details-view2.jsp мы можем использовать поля этого объекта Employee.
    // Можем взглянуть как это делается, но там ничего сложного, синтаксис такой же, как
    // и в прошлом примере. В тот момент когда мы обращаемся к этим полям срабатывают геттеры
    public String showEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee
    , BindingResult bindingResult) {
        // В случае возникновения ошибки при валидации, мы хотим вернуть форму, в которой заполняем
        // данные, где уже будет показана ошибка. Для этого мы несколько изменили сигнатуру метода.
        // Мы добавили аннотацию @Valid, которая указывает что данный бин валидируется, а так же
        // добавили аргументом объект BindingResult, обращаясь к нему с помощью метода hasError(),
        // мы проверяем не содержится ли там ошибка валидации, если содержится, возвращаем
        // форму с данными. Важное дополнение, параметр BindingResult должен всегда идти после
        // ModelAttribute, иначе результат валидации может быть неверно считан в том случае
        // если ModelAttribute больше одного. Вернемся в класс Employee на 20 строку
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view2";
        }
        return "show-emp-details-view2";
    }

}

package main.Part_four_SpringMVC;

public class Lesson_36_FirstMVCApplication {

    // Прошлая лекция была больше теоретической, настало время попрактиковаться.

    //  Вспоминаем, что такое MVC. Это шаблон проектирования, согласно которому наше приложение
    // будет делиться на три компоненты: model(данные), view(пользовательское представление),
    // controller(бизнес-логика).

    // В нашем случае это будет реализовываться так:
    // Имеется Front controller(dispatcher servlet) который слушает определенный порт.
    // Когда он получает запрос по этому порту, то переправляет этот запрос контролеру,
    // отвечающему за обработку таких запросов. Контролер(controller) обрабатывает запрос
    // и формирует ответ(view) который передается пользователю. Model мы пока не будем затрагивать.
    // Приступим к реализации.

    // Для начала мы создадим view который будет отображаться в браузере, для этого в
    // пакете view мы создадим файл first-view.jsp, перейдем в него.

    // Итак, мы создали первый контролер, который срабатывает при любом вызове нашего условного
    // сайта. Теперь мы можем запустить Tomcat сервер и все изменения автоматически задеплоятся
    // на него. При каждом изменении нашей программы, нам будет необходимо перезапускать сервер,
    // чтобы все изменения применились.
    // При запуске сервера откроется адрес
    // http://localhost:8080/SpringCourse_Chapter_2_war_exploded/, на этой странице будет тот текст,
    // который мы указали в объекте view. Название немного некрасивое, поменять его можно
    // в той же вкладке deployment, где мы его и добавляли при создании Tomcat сервера.
    // Теперь у нас открывается страница http://localhost:8080/mvc/
}

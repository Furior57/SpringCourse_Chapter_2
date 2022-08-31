package main.Part_four_SpringMVC.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Мы каким то образом умудрились пропустить создание аннотаций. Что ж. Давайте наверстывать.
// Аннотации создаются как классы, но тип у них при этом @interface, в чем нет ничего удивительного,
// ибо при компиляции этот тип, со всеми его методами, приводится к типу интерфейса.
// Все поля и методы внутри аннотаций неявно имеют модификаторы доступа public abstract.
// При создании аннотации тоже могут помечаться аннотациями. Пройдемся по ним.
// @Target(ElementType.FIELD) - здесь мы указали что данная аннотация может применяться только
// к полям класса.
// @Retention(RetentionPolicy.RUNTIME) - здесь мы указали что аннотация доступна в течении всего
// цикла жизни программы.
// @Constraint(validatedBy = CheckEmailValidator.class) - здесь мы указываем класс, который будет
// обрабатывать нашу аннотацию. В нем и будет заключена бизнес-логика аннотации. Если проще -
// класс CheckEmailValidator будет валидировать нашу аннотацию. Пока не будем обсуждать его,
// перейдем к полям аннотации.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {
    // Все поля аннотации, как мы упомянули выше имеют модификатор доступа public abstract.
    // Однако это не просто поля, это методы, поэтому после названия всегда идут скобки.
    // Любая аннотация обязана содержать поле value, опираясь на это поле мы и будем проводить
    // валидацию. Устанавливаем это поле по умолчанию как xyz.com, именно на эту комбинацию
    // должен будет оканчиваться наш email, однако при использовании аннотации мы всегда
    // можем поставить нужное нам значение.
    public String value() default "xyz.com";
    // Второе поле это message, мы можем так же задать ему дефолтное значение.
    public String message() default "Email must ends xyz.com";
    // Эти два поля обязательны, groups позволяет формировать группы валидации,
    // payload позволяет передавать мета-данные клиенту, в данном случае они нам не нужны, поэтому
    // устанавливаем дефолтное значение как пустые массивы с помощью {}
    // Теперь перейдем в класс CheckEmailValidator
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}

package main.Part_four_SpringMVC.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
// Данный класс имплементирует интерфейс ConstraintValidator, который параметризуется двумя типами,
// первый тип это наша аннотация, второй тот тип данных к которому мы будем применять аннотацию.
public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {
    // Теперь мы должны переопределить два метода, но сначала создадим переменную которая будет
    // содержать то значение, которое мы проверяем
    private String endOfEmail;
    // В этом методе мы определяем то значение которое будем валидировать
    @Override
    public void initialize(CheckEmail checkEmail) {
        // Получаем значение из нашей аннотации, больше нам здесь ничего не нужно
        endOfEmail = checkEmail.value();
    }
    // Здесь будет происходить проверка. Второй параметр в данный момент нам не понадобится,
    // а в первый мы передадим строку из аннотации и проверим ее на соответствие нашему шаблону.
    @Override
    public boolean isValid(String enteredValue,
                           ConstraintValidatorContext constraintValidatorContext) {
        // Логика очень проста, мы проверяем заканчивается ли строка на то, что нам передала
        // аннотация
        return enteredValue.endsWith(endOfEmail);
    }
}

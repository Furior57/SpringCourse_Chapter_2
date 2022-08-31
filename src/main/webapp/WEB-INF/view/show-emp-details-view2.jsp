<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear Employee, you are WELCOME!</h2>
<br>
<br>
<br>
Your name: ${employee.name}
<br>
<br>
Your surname: ${employee.surname}
<br>
<br>
Your salary: ${employee.salary}
<br>
<br>
Your department: ${employee.department}
<br>
<br>
Your car: ${employee.car}
<br>
<br>
Your phone number: ${employee.phoneNumber}
<br>
<br>
Your email: ${employee.email}
<br>
<br>
<%--Здесь новый для нас синтаксис. Тег ul означает немаркированный список(unorderedList),
открывая этот тег мы сообщаем что сейчас передадим несколько объектов, каждый объект
открывается и закрывается тегом li(list item), мы же поспользуемся преимуществами java, а
точнее jstl. В самом верху документа мы указали пространство имен, там указан префикс "с",
этот префикс отвечает за все циклические операции, после префикса, через двоеточие мы
указываем тип операции, у нас forEach, присваиваем имя переменной var="" и передаем ту
коллекцию в которой у нас лежат объекты которые необходимо обработать с помощью параметра
items, обращаем внимание что в items мы передаем ссылку на коллекцию. После мы открываем
тег li и передаем в него название переменной определенной ранее. Теперь при генерации
страницы java сама пробежится по коллекции и подставит необходимые значения туда, куда мы указали.
--%>
Language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>

</ul>
</body>
</html>
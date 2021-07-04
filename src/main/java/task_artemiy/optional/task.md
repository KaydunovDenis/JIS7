### Optional
Создать классы
Обязательные поля firstName, lastName, age для обоих классов.
[+] Дополнительно у Lecturer список Students которых он ведет.

## Lecturer
List<Student> students = new ArrayList<>();

## Student
String firstName;
String lastName;
int age;


[+] Написать сервис которых добавляет студента в список преподавателя.
[+] Написать сервис так, что если добавляется студент с null значением у ЛЮБОГО из полей,
то он не сохраняется и выскакивает исключение об ошибке. 
[-] Так же написать метод которых ищет студента по имени. 
    - Метод должен возвращать Optional. 
    - Если не найден студент -> кастомное(специальное) сообщение об ошибке.
[-] Написать метод, который обновляет информацию о Student и Lecturer. 
    - Написать так, чтобы если добавляются null, то чтобы ничего не обновлялось, 
    // либо устанавливаете значение по дефолту. (как решите)
  
## LecturerService
void addStudent(Student ... students);
Optional getUserByName(){
    return;
  }
  
## LecturerServiceImpl implements LectureService{
  
  void addStudent(Student ... students){
  students.foeEach(.....)
  //TODO not null, else throw exception
  }
  

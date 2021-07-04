### Optional
Создать классы 

## Lecturer
List<Student> userList = new ArrayList<>();

## Student
Обязательные поля firstName, lastName, age для обоих классов. 

String firstName;
String lastName;
int age;

[+] Дополнительно у Lecturer список Students которых он ведет. 

	
[-] Написать сервис которых добавляет студентов в список преподавателя. 

[-] Написать сервис так, что если добавляется студент с null значением у ЛЮБОГО из полей,
то он не сохраняется и выскакивает исключение об ошибке. 
[-] Так же написать метод которых ищет юзера по имени. Метод должен возвращать Optional. Если не найден студент тоже кастомное сообщение об ошибке.
Написать метод который обновляет информацию о Студенте и Преподе. 
НАписать так, чтобы даже если сетаются null значения, либо ничего не сеталось либо устанавливаете значение по дефолту. (как решите)
  
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
  

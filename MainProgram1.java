/**
 * Name: Jeffrey Barker
 * Date: 9/11/2024
 * Description: Program 1, turning python code into java code 
 *              Making a Person and a Student to then output a string for name and an age 
 *              with working functions such as a birthday.
 */

// Person class that defines what a "Person" has 
// and how to add a year to the age (birthday)
class Person {
  private int age;
  private String name;
  protected boolean isStudent;

  public Person(String name, int age) {   // Gives the person an age, name
    this.age = age;                      // and that it isn't a student
    this.name = name;
    this.isStudent = false;
  }
  public void birthday() {    // birthday fuction to add age +1
    this.age++;
  }

  @Override
  public String toString() {   // string function, if a student
    String result = "";        // adds to the result not or a student
    result += this.name + " is " ;
    if(this.isStudent){
      result += "a student ";
    } else {
      result += "not a student ";
    }
    result += "and is " + this.age + " years old";   // then adds the age to the string
    return result;
  }
}

// Student super extending from Person class. Sets the student to true
class Student extends Person {          
  public Student(String name, int age){
    super(name, age);
    this.isStudent = true;
  }
}

// Main class with entry point, calls made functions from Student and Person
// Sets the Student and Person to have a name and age
// Then prints out the original student, then +1 on age, and then the Person
public class Main {
  public static void main(String[] args) {
    Student student = new Student("Bob", 20);
    System.out.println(student);
    student.birthday();
    System.out.println(student);

    Person person = new Person("Rob", 22);
    System.out.println(person);
  }
}

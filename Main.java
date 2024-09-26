/**
* Name: Jeffrey Barker
* Date: 9/16/2024
* Description: Program 2, CSC 220. Program that uses the Person class from Program 1 which also takes 
* in the new People class that allows the "Mysterious" class to be used in a seperate file.
* 
*/


/*
People class, that contains addPerson, findPersonByAge, and findPersonByName that is working in 
collaboration with the Person class from the previous assignment.
 */ 
class People{

  private Person[] group;
  private int index;

  public People() {
    group = new Person[5];  // Allocate array to hold 5 Person objects
    index = 0;  // Initialize index to 0
  }

  /**
   *    * call this when you want to add a person 
   * @param p is the person itself
   * @return false or true depending on the amount of people in te index
   */
  public boolean addPerson(Person p){
    if(index >= 5){
      return false;
    } 
    else {
      group[index] = p;
      index++;
      return true;
    }
  }
  /**
   * Function to find the person by name in the index group
   * @param name the name of the person
   * @return group[i] (name of the person) if the name equals
   * returns null if i not in the index
   */
  public Person findPersonByName(String name){
    for(int i=0; i < index; i++){
      if(group[i].name.equals(name)){
        return group[i];
      }
    }
    return null;
  }
  /**
   * Function for finding a person by their age
   * @param age the age of the person
   * @return group[i] (the age of the person)
   * returns null if i is not in the index
   */
  public Person findPersonByAge(int age){
    for(int i=0; i < index; i++){
      if (group[i].age == age){
        return group[i];
      }
    }
    return null;
  }

}

// Copy over your Person class from assignment 1
class Person {
  public int age;
  public String name;
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
  public String toString() {
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

/** Main class - contains entry point */
// DO NOT MODIFY ANY CODE BELOW
public class Main {
  public static void main(String[] args) {
  // instantiate a new People object
  People people = new People();
  // add some Person objects
  boolean addedAllPeople = true;
  addedAllPeople &= people.addPerson(new Person("Eleanor", 38));
  addedAllPeople &= people.addPerson(new Person("Tahani", 33));
  addedAllPeople &= people.addPerson(new Person("Chidi", 39));
  addedAllPeople &= people.addPerson(new Person("Jason", 31));
  addedAllPeople &= people.addPerson(new Person("Michael", 20000));
  addedAllPeople &= people.addPerson(new Person("Janet", 10000));
  // create pointers to two Persons
  Person p1;
  Person p2;
  // initialize them with the results of our searches
  p1 = people.findPersonByName("Chidi");
  p2 = people.findPersonByAge(10000);
  // check if our results are correct
  Mysterious.checkAnswer(addedAllPeople, p1, p2);
  }
}
  
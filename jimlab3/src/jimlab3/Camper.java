package jimlab3;

//import com.sun.jdi.connect.Connector;

/****************************************************************************
 * Camper class: The camper class is intended to create a comparable class of
 * campers. The data structure includes name, age, and gender and the
 * information is stored in a binary search tree using a queue.
 *
 * @author Jim Griffin
 * @version 1.0
 * @date 11-2-2017
 * @course MCIS-0503 Fall 2017 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public class Camper implements Comparable<Camper> {
    @Override
    public int compareTo(Camper o) {
        return this.name.compareTo(o.getName());
    }

    public String name;
    public int age;
    public String gender;
    public String size;

    //n means name, a means age, and g means gender
    public Camper(String n, int a, String g){
        name = n;
        age= a;
        gender = g;
    }

    //Method for accessing the name of the object.
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {

        return name;
    }

    @Override
    public String toString() {

        return "Camper "+getName()+":"+getAge()+" " + getGender();
    }

    //Method for accessing the size of the object.
    public void setAge(int age) {

        this.age = age;
    }

    public int getAge() {

        return age;
    }

    // Method for accessing the gender
    public void setGender(char gender) {

        this.gender = String.valueOf(gender);
                //String.valueOf(gender);

    }


    public String getGender() {

        return gender;
    }


    public void setsize(int size) {
        this.size = String.valueOf(size);
    }
    public String getsize()
    {
        return size;
    }


}

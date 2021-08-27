package comparable;

class Student implements Comparable<Student>{
    String name;
    int roll;

    Student(String name, int roll){
        this.name = name;
        this.roll = roll;
    }

    public String toString(){
        return "The student " + name + " with the id " + roll + " is recorded";
    }

    @Override
    public int compareTo(Student o) {
        return this.roll - o.roll ;
    }
}

class Staff{
    String name;
    int id;

    Staff(String name, int id){
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString(){
        return "Staff " + name + " is assigned with the id  " + id ;
    }
}

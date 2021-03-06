package entities;

import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


public class Person implements Comparable<Person>, Serializable {

    private final String name;
    private final int height;
    private String helloMessage;
    private final Gender gender;

    /** Расположение в пространстве*/
    private Point point = new Point(0 , 0);

    /** Дата рождения
     *
     *  Без явного указания - задается по умолчанию в момент создания объекта
     */
    private final Date birthDate;
    private final LocalDateTime birthTime;

    public Person(String name, int height, Gender gender, Date birthDate, LocalDateTime birthTime){
        this.name = name;
        this.height = height;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
    }

    public Person(String name, int height, Gender gender){
        this(name, height, gender, new Date(), LocalDateTime.now());
    }

    // TODO: сортированы по размеру
    public int compareTo(Person o) {
        return o.height - height;
    }

    public String getHelloMessage(){
        return helloMessage==null?"Привет-привет!":helloMessage;
    }
    public void setHelloMessage(String helloMessage){
        this.helloMessage = helloMessage;
    }
    public String getSimpleDimension(){
        return String.format("[x = %d ; y = %d]", point.x, point.y);
    }
    public String getSimpleBirthDate(){
        return new SimpleDateFormat("dd.MM.yyyy").format(birthDate);
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Gender getGender() {
        return gender;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Сравнение по имени и дате рождения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

    @Override
    public String toString() {
        return "Class\t\t: '" + getClass().getSimpleName() + "\'\n" +
                "name\t\t: '" + name + "\'\n" +
                "height\t\t: '" + height + "\'\n" +
                "helloMessage: '" + getHelloMessage() + '\'' + "\n" +
                "gender\t\t: '" + gender + "\n" +
                "point\t\t: '" + getSimpleDimension() + "\'\n" +
                "birth date\t: '" + getSimpleBirthDate() + '\'' +
                "\nbirth time\t: '" + getBirthTime() + '\'';
    }

    /**
     * Сериализованный вид объекта в виде строкового CSV
     */
    public String CSVData(){
        return String.format("classOf=%s,height=%d,name=%s,helloMessage=%s,gender=%s,birthDate=%s",
                getClass().getSimpleName(), height,name, helloMessage=getHelloMessage(),gender.name(), getSimpleBirthDate());
    }

    public LocalDateTime getBirthTime() {
        return birthTime;
    }
}

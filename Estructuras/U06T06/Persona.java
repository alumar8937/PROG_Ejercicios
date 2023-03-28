public class Persona {
    String name;
    String surname;
    String nickname;
    int age;
    public Persona(String name, String surname, String nickname, int age ){
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
    public String toString(){
        return name + ' '+'"' + nickname + '"'+' ' + surname;
    }
    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }
}

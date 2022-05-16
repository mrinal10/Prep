package designpattern;


class User {
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    User(UserBuilder userBuilder) {
        firstName = userBuilder.firstName;
        lastName = userBuilder.lastName;
        age = userBuilder.age;
        phone  = userBuilder.phone;
        address = userBuilder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String fName, String lName) {
            firstName = fName;
            lastName = lName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}


public class Builder {

    public static void main(String[] args) {
        User user = new User.UserBuilder("Fname", "Lname")
                .age(10)
                .address("address")
                .phone("phone")
                .build();

        User user1 = new User.UserBuilder("Fname", "Lname")
                .age(10)
                .phone("phone")
                .build();
    }
}

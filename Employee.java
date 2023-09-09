import java.util.Random;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    private static final String[] departments = {"Technical", "Admin", "Human Resource", "Legal"};

    public static String generateEmailAddress(Employee employee, String department, String company) {
        String email = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase() + ".com";
        return email;
    }

    public static String generatePassword() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        String allChars = uppercase + lowercase + numbers + specialChars;
        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        password.append(uppercase.charAt(rand.nextInt(uppercase.length())));
        password.append(lowercase.charAt(rand.nextInt(lowercase.length())));
        password.append(numbers.charAt(rand.nextInt(numbers.length())));
        password.append(specialChars.charAt(rand.nextInt(specialChars.length())));

        for (int i = 4; i < 12; i++) {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        return password.toString();
    }

    public static void showCredentials(Employee employee, String department, String company, String password) {
        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + generateEmailAddress(employee, department, company));
        System.out.println("Password ---> " + password);
    }
}

public class main {
    public static void main(String[] args) {
        String company = "abc";
        Employee newEmployee = new Employee("Prasad", "Roundhal");
        String department = CredentialService.departments[0];
        String password = CredentialService.generatePassword();

        CredentialService.showCredentials(newEmployee, department, company, password);
    }
}


class Patient {
    private String patientId;
    private String name;
    private int age;
    private String medicalHistory;
    public Patient(String patientId, String name, int age, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }
    public String getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    public void printPatientDetails() {
        System.out.println("Patient Id: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Medical History: " + medicalHistory);
    }
}
class User {
    protected String userId;
    protected String name;
    protected String contactInfo;
    public User(String userId, String name, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    public void printUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
    }
}
class Doctor extends User {
    private String specialization;
    public Doctor(String userId, String name, String contactInfo, String specialization) {
        super(userId, name, contactInfo);
        this.specialization = specialization;
    }
    public void prescribeTreatment(Patient patient) {
        System.out.println("Prescribing treatment to " + patient.getName() + " by Dr. " + name + " ,specialization in " + specialization);
    }
}
class Admin extends User {
    public Admin(String userId, String name, String contactInfo) {
        super(userId, name, contactInfo);
    }
    public void manageUserAccounts() {
        System.out.println("Managing user accounts by Admin: " + name);
    }
}
abstract class AppointmentScheduler {
    public abstract void scheduleAppointment(Patient patient, Doctor doctor);
}
class BasicAppointmentScheduler extends AppointmentScheduler {
    @Override
    public void scheduleAppointment(Patient patient, Doctor doctor) {
        System.out.println("Scheduling appointment for " + patient.getName() + " by doctor " + doctor.name);
    }
}
public class Main { 
    public static void main(String[] args) {
        Patient patient = new Patient("P001", "John Campbell", 32, "Cataract issues");
        Doctor doctor = new Doctor("D001", "Rovman Powell", "678678", "Skin Doctor");
        Admin admin = new Admin("A001", "Mokshe Jain", "333444");
        patient.printPatientDetails();
        doctor.printUserInfo();
        admin.printUserInfo();
        doctor.prescribeTreatment(patient);
        admin.manageUserAccounts();
        AppointmentScheduler appointmentScheduler = new BasicAppointmentScheduler();
        appointmentScheduler.scheduleAppointment(patient, doctor);
    }
}
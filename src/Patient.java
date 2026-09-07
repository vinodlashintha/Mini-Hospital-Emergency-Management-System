public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitLinkedList visitHistory; // Singly Linked List for visit history

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList(); // Initialize empty list for this patient
    }

    public void displayPatientDetails() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age +
                           " | Contact: " + contactNumber + " | Condition: " + medicalCondition);
        visitHistory.displayHistory();
    }
}
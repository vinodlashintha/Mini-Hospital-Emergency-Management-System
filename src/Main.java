import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Core Data Structures
        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        // Sample Data Initialization for Demonstration
        Patient p1 = new Patient(101, "Alice", 30, "0771234567", "Fever");
        Patient p2 = new Patient(102, "Bob", 45, "0777654321", "Arm Pain");
        Patient p3 = new Patient(103, "Brown", 22, "0711122334", "Chest Pain");

        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        boolean running = true;

        while (running) {
            System.out.println("\n==================================================");
            System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM   ");
            System.out.println("==================================================");
            System.out.println("1. Patient Records (BST) - Add Patient");
            System.out.println("2. Patient Records (BST) - Search Patient");
            System.out.println("3. Patient Records (BST) - Delete Patient");
            System.out.println("4. Patient Records (BST) - Display All (In-Order)");
            System.out.println("--------------------------------------------------");
            System.out.println("5. Emergency Queue - Enqueue Patient for Treatment");
            System.out.println("6. Emergency Queue - Dequeue Next Patient");
            System.out.println("7. Emergency Queue - Display Waiting Queue");
            System.out.println("--------------------------------------------------");
            System.out.println("8. Treatment History (Stack) - Display Completed Treatments");
            System.out.println("9. Treatment History (Stack) - Pop Recent Treatment");
            System.out.println("--------------------------------------------------");
            System.out.println("10. Patient Visit History (Singly Linked List) - Add Visit");
            System.out.println("11. Patient Visit History (Singly Linked List) - Display Visits");
            System.out.println("--------------------------------------------------");
            System.out.println("0. Exit Application");
            System.out.println("==================================================");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, contact, condition);
                    patientBST.insert(newPatient);
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    Patient found = patientBST.search(searchId);
                    if (found != null) {
                        System.out.println("Patient Found:");
                        found.displayPatientDetails();
                    } else {
                        System.out.println("Patient with ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    patientBST.delete(deleteId);
                    System.out.println("Patient deleted (if record existed).");
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID to Enqueue into Emergency Queue: ");
                    int eqId = Integer.parseInt(scanner.nextLine());
                    Patient eqPatient = patientBST.search(eqId);
                    if (eqPatient != null) {
                        emergencyQueue.enqueue(eqPatient);
                    } else {
                        System.out.println("Patient record not found in BST. Register patient first.");
                    }
                    break;

                case 6:
                    Patient treatedPatient = emergencyQueue.dequeue();
                    if (treatedPatient != null) {
                        System.out.print("Enter Treatment Details Provided: ");
                        String details = scanner.nextLine();
                        System.out.print("Enter Completion Time/Date: ");
                        String time = scanner.nextLine();

                        TreatmentRecord record = new TreatmentRecord(treatedPatient, details, time);
                        treatmentStack.push(record);
                    }
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    treatmentStack.displayStack();
                    break;

                case 9:
                    treatmentStack.pop();
                    break;

                case 10:
                    System.out.print("Enter Patient ID to Add Visit History: ");
                    int vPatId = Integer.parseInt(scanner.nextLine());
                    Patient vPatient = patientBST.search(vPatId);
                    if (vPatient != null) {
                        System.out.print("Enter Visit ID: ");
                        int vId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Visit Date: ");
                        String vDate = scanner.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doc = scanner.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = scanner.nextLine();
                        System.out.print("Enter Treatment: ");
                        String trt = scanner.nextLine();

                        vPatient.visitHistory.addVisit(vId, vDate, doc, diag, trt);
                    } else {
                        System.out.println("Patient not found!");
                    }
                    break;

                case 11:
                    System.out.print("Enter Patient ID to View Visit History: ");
                    int vSearchId = Integer.parseInt(scanner.nextLine());
                    Patient vSearchPatient = patientBST.search(vSearchId);
                    if (vSearchPatient != null) {
                        vSearchPatient.displayPatientDetails();
                    } else {
                        System.out.println("Patient not found!");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting System. Good luck with your assignment submission!");
                    break;

                default:
                    System.out.println("Invalid option! Please select between 0 and 11.");
            }
        }

        scanner.close();
    }
}
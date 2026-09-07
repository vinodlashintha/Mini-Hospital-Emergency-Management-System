public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // 1.Add patient to the back of the waiting queue
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.name + " (ID: " + patient.patientId + ") added to emergency queue.");
    }

    // 2.Remove and return the next patient for treatment
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency Queue is empty! No patients waiting for treatment.");
            return null;
        }
        Patient patientToTreat = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("Patient " + patientToTreat.name + " (ID: " + patientToTreat.patientId + ") called for treatment.");
        return patientToTreat;
    }

    // 3. Display all patients currently waiting in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency Queue is currently empty.");
            return;
        }
        System.out.println("\n--- Emergency Waiting Queue (FIFO) ---");
        QueueNode temp = front;
        int position = 1;
        while (temp != null) {
            System.out.print("Position " + position + " -> ");
            temp.patient.displayPatientDetails();
            temp = temp.next;
            position++;
        }
    }

    // Helper method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}
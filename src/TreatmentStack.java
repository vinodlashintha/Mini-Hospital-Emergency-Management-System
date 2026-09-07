public class TreatmentStack {
    private StackNode top;

    public TreatmentStack() {
        this.top = null;
    }

    // 1. Add completed treatment record to top of stack
    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record for " + record.patient.name + " pushed to history stack.");
    }

    // 2. Remove most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment History Stack is empty!");
            return null;
        }
        TreatmentRecord poppedRecord = top.record;
        top = top.next;
        System.out.println("Popped most recent record: " + poppedRecord.patient.name);
        return poppedRecord;
    }

    // 3. Display treatment records
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment history records available.");
            return;
        }

        System.out.println("\n--- Treatment History Stack (LIFO: Most Recent First) ---");
        StackNode temp = top;
        while (temp != null) {
            temp.record.displayRecord();
            temp = temp.next;
        }
    }

    // Helper method to check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
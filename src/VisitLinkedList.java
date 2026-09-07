public class VisitLinkedList {
    private VisitNode head;

    public VisitLinkedList() {
        this.head = null;
    }

    // 1. Add a new visit to the patient's history
    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newVisit = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        
        if (head == null) {
            head = newVisit;
        } else {
            VisitNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("Visit record #" + visitId + " added successfully.");
    }

    // 2. Remove a visit by Visit ID
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history s empty.");
            return false;
        }

        // If the head node itself holds the visit ID to be deleted
        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit record #" + visitId + " removed successfully.");
            return true;
        }

        VisitNode current = head;
        VisitNode previous = null;

        while (current != null && current.visitId != visitId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Visit record #" + visitId + " not found.");
            return false;
        }

        previous.next = current.next;
        System.out.println("Visit record #" + visitId + " removed successfully.");
        return true;
    }

    // 3. Search for a visit by Visit ID
    public VisitNode searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visitId == visitId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 4. Display patient's full visit history
    public void displayHistory() {
        if (head == null) {
            System.out.println("   No visit history recorded for this patient.");
            return;
        }

        System.out.println("   --- Patint Visit History ---");
        VisitNode temp = head;
        while (temp != null) {
            temp.displayVisitInfo();
            temp = temp.next;
        }
    }
}
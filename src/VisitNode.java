public class VisitNode {
    int visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;
    VisitNode next; 

    public VisitNode(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }

    public void displayVisitInfo() {
        System.out.println("   [Visit ID: " + visitId + " | Date: " + visitDate + 
                           " | Doctor: " + doctorName + " | Diagnosis: " + diagnosis + 
                           " | Treatment: " + treatment + "]");
    }
}
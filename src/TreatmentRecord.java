public class TreatmentRecord {
    Patient patient;
    String treatmentDetails;
    String completionTime;

    public TreatmentRecord(Patient patient, String treatmentDetails, String completionTime) {
        this.patient = patient;
        this.treatmentDetails = treatmentDetails;
        this.completionTime = completionTime;
    }

    public void displayRecord() {
        System.out.println("   [Completed At: " + completionTime + " | Patient ID: " + patient.patientId +
                           " | Name: " + patient.name + " | Treatment: " + treatmentDetails + "]");
    }
}
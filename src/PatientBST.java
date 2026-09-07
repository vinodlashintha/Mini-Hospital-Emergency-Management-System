public class PatientBST {
    private BSTNode root;

    public PatientBST() {
        this.root = null;
    }

    // 1. Insert a new patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
        System.out.println("Patient ID " + patient.patientId + " added to BST.");
    }

    private BSTNode insertRecursive(BSTNode current, Patient patient) {
        if (current == null) {
            return new BSTNode(patient);
        }

        if (patient.patientId < current.patient.patientId) {
            current.left = insertRecursive(current.left, patient);
        } else if (patient.patientId > current.patient.patientId) {
            current.right = insertRecursive(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.patientId + " already exists!");
        }

        return current;
    }

    // 2. Search for a patient by Patient ID
    public Patient search(int patientId) {
        return searchRecursive(root, patientId);
    }

    private Patient searchRecursive(BSTNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId == current.patient.patientId) {
            return current.patient;
        }

        if (patientId < current.patient.patientId) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    // 3. Delete a patient by Patient ID
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private BSTNode deleteRecursive(BSTNode current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }

        if (patientId < current.patient.patientId) {
            current.left = deleteRecursive(current.left, patientId);
        } else if (patientId > current.patient.patientId) {
            current.right = deleteRecursive(current.right, patientId);
        } else {
            // Node found!
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Node with two children: Get in-order successor
            BSTNode smallest = findMin(current.right);
            current.patient = smallest.patient;
            current.right = deleteRecursive(current.right, smallest.patient.patientId);
        }
        return current;
    }

    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 4. In-order traversal
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records in BST.");
            return;
        }
        System.out.println("\n--- Patient Records (Sorted by ID) ---");
        inOrderRecursive(root);
    }

    private void inOrderRecursive(BSTNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            node.patient.displayPatientDetails();
            inOrderRecursive(node.right);
        }
    }
}
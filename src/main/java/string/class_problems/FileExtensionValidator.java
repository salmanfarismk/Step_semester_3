package string.class_problems;

/**
 * Problem 3: File Extension Validator
 * Scenario: Assignment-Upload Portal
 * 
 * Extracts file extension using lastIndexOf() and substring(),
 * then validates against an accepted whitelist (pdf, docx, zip).
 */
public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    /**
     * Extracts and validates the file extension against accepted file types.
     *
     * @param filename The name of the uploaded file
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Upload Portal: Extension Validator ===");

        String file1 = "Assignment1.PDF";
        System.out.println("Input: \"" + file1 + "\" -> Output: " + validateFileExtension(file1));

        String file2 = "notes.txt";
        System.out.println("Input: \"" + file2 + "\" -> Output: " + validateFileExtension(file2));

        String file3 = "project_archive.zip";
        System.out.println("Input: \"" + file3 + "\" -> Output: " + validateFileExtension(file3));
    }
}

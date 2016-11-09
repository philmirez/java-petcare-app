import javax.swing.JOptionPane;

public class Utility {
    private static final String[] FIRST_NAME_MESSAGES = {"Please enter your first name.", "Please enter a valid name.", "Please enter a non-blank name."};
    private static final String[] LAST_NAME_MESSAGES = {"Please enter your last name.", "Please enter a valid name.", "Please enter a non-blank name."};
    private static final String[] EMAIL_MESSAGES = {};
    private static final String[] PHONE_NUMBER_MESSAGES = {};
    /**
     * A basic string input method that allows the user to enter input based on the prompt, passed in via
     * the 'messages' array. The first element of the 'messages' array is the initial prompt, the second
     * element is the exception prompt, and the subseuquent elements can be used (and this basic model
     * changed) to incorporate other error/invalid messages for input.
     */
    public static String getStringInput(String[] messages) {
        String input = "";
        do {
            try {
                input = JOptionPane.showInputDialog(messages[0]);
                if (isEmpty(input)) {
                    JOptionPane.showMessageDialog(null, messages[2]);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, messages[1]);
            }
        } while (isEmpty(input));
        return input;
    }

    private static boolean isEmpty(String string) {
        if (string.equals("")) {
            return true;
        }
        return false;
    }
}
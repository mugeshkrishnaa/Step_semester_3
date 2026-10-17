public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        String ref = raw.trim();

        if (ref.length() < 3) {
            return ref;
        }

        return ref.substring(0, 3).toUpperCase()
                + ref.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String formattedDate = date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bank).append("] DATE: ")
                .append(formattedDate).append(" | SEQ: ")
                .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        String ref = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref));

        String invalid = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(invalid));
    }
}

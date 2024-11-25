import java.util.*;

public class Form_Groupify {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("AM");
        String AM = myObj.nextLine();

        System.out.println("Όνομα");
        String name = myObj.nextLine();

        System.out.println("Επώνυμο");
        String surname = myObj.nextLine();

        System.out.println("E-mail");
        String email = myObj.nextLine();

        System.out.println("Κωδικός Μαθήματος");
        int code = myObj.nextInt();

        //Εδω αρχίζουν οι ερωτήσεις χαρακτήρα
        System.out.println("1. Μπορώ να προσαρμοστώ εύκολα σε διαφορετικούς ρόλους μέσα στην ομάδα");
        // 1 εως 5
        //??
        System.out.println("2. Είμαι ανοιχτός/η στο να δεχτώ κριτική από τα μέλη της ομάδας μου");
        //
        System.out.println("3. Βάζω το ομαδικό συμφέρον πάνω από το προσωπικό");
        // 1 2 3 4 5
        System.out.println("4. Επικεντρώνομαι στο να βρίσκω ψύχραιμα λύσεις όταν προκύπτουν προβλήματα στην ομάδα ");

        System.out.println("5. Είμαι πρόθυμος να βοηθήσω με τις γνώσεις και τις δεξιότητες μου, μέλη της ομάδας στο δικό τους κομμάτι");

        System.out.println("6. Ενθαρρύνω την πολυφωνία και την ανταλλαγή διαφορετικών ιδεών στην ομάδα");

        System.out.println("7. Νιώθω άνετα να εκφράσω τη διαφωνία μου όταν είναι απαραίτητο");

        System.out.println("8. Προσαρμόζομαι εύκολα σε αλλαγές στα σχέδια που μπορεί να προκύψουν κατά τη διάρκεια της εργασίας");

        System.out.println("9. Πόσα από τα παρακάτω χαρακτηριστικά προσωπικότητας θεωρείτε ότι διαθέτετε: ομαδικότητα, συνέπεια, ηγετική ικανότητα, οργάνωση, διάθεση για ενασχόληση");
        System.out.println("1 = 1, 2 = 2, 3 = 3, 4 = 4, 5 = 5");

        System.out.println("10. Γενικά είστε ικανοποιημένος/η με την απόδοσή σας ;" +
         "1 = Καθόλου Ικανοποιημένος/η, 2 = Σχεδόν Ποτέ, 3 = Ουδέτερος/η, 4 = Σχετικά ικανοποιημένος/η, 5 = Απολύτως ικανοποιημένος/η");

    }
}


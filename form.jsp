<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="el">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Φόρμα Ερωτήσεων</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: rgb(231, 218, 233);
        }
        .form-container {
            max-width: 800px;
            margin: auto;
        }
        .question {
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .question label {
            font-weight: bold;
            display: block;
            margin-bottom: 10px;
        }
        .answers {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .answers label {
            margin-right: 10px;
        }
        button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #ae0fdae0;
            color: black;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #ae0fdae0;
        }
        .description {
            background-color: #ae0fdae0; 
            color: black; 
            padding: 10px;
            border-radius: 5px;
            font-size: 16px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Φόρμα Ερωτήσεων</h1>
        <p class="description">Κλίμακα μέτρησης: 1=Καθόλου 5=Πάρα πολύ</p>
        <h4>Στοιχεία Φοιτητή</h4>
        
        <form action="Submit.jsp" method="post">
            <!-- Εισαγωγή στοιχείων χρήστη -->
            <div class="question">
                <label for="am">Αριθμός Μητρώου (AM):</label>
                <input type="text" id="am" name="am" required>
            </div>
            <div class="question">
                <label for="name">Όνομα:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="question">
                <label for="surname">Επώνυμο:</label>
                <input type="text" id="surname" name="surname" required>
            </div>
            <div class="question">
                <label for="email">E-mail:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <h4>Ερωτήσεις Χαρακτήρα</h4>

            <!-- Ερωτήσεις -->
            <div class="question">
                <label>1. Μπορώ να προσαρμοστώ εύκολα σε διαφορετικούς ρόλους μέσα στην ομάδα;</label>
                <div class="answers">
                    <input type="radio" id="q1_1" name="question1" value="1" required>
                    <label for="q1_1">1</label>
                    <input type="radio" id="q1_2" name="question1" value="2">
                    <label for="q1_2">2</label>
                    <input type="radio" id="q1_3" name="question1" value="3">
                    <label for="q1_3">3</label>
                    <input type="radio" id="q1_4" name="question1" value="4">
                    <label for="q1_4">4</label>
                    <input type="radio" id="q1_5" name="question1" value="5">
                    <label for="q1_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>2. Είμαι ανοιχτός/η στο να δεχτώ κριτική από τα μέλη της ομάδας μου;</label>
                <div class="answers">
                    <input type="radio" id="q2_1" name="question2" value="1" required>
                    <label for="q2_1">1</label>
                    <input type="radio" id="q2_2" name="question2" value="2">
                    <label for="q2_2">2</label>
                    <input type="radio" id="q2_3" name="question2" value="3">
                    <label for="q2_3">3</label>
                    <input type="radio" id="q2_4" name="question2" value="4">
                    <label for="q2_4">4</label>
                    <input type="radio" id="q2_5" name="question2" value="5">
                    <label for="q2_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>3. Βάζω το ομαδικό συμφέρον πάνω από το προσωπικό;</label>
                <div class="answers">
                    <input type="radio" id="q3_1" name="question3" value="1" required>
                    <label for="q3_1">1</label>
                    <input type="radio" id="q3_2" name="question3" value="2">
                    <label for="q3_2">2</label>
                    <input type="radio" id="q3_3" name="question3" value="3">
                    <label for="q3_3">3</label>
                    <input type="radio" id="q3_4" name="question3" value="4">
                    <label for="q3_4">4</label>
                    <input type="radio" id="q3_5" name="question3" value="5">
                    <label for="q3_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>4. Επικεντρώνομαι στο να βρίσκω ψύχραιμα λύσεις όταν προκύπτουν προβλήματα στην ομάδα;</label>
                <div class="answers">
                    <input type="radio" id="q4_1" name="question4" value="1" required>
                    <label for="q4_1">1</label>
                    <input type="radio" id="q4_2" name="question4" value="2">
                    <label for="q4_2">2</label>
                    <input type="radio" id="q4_3" name="question4" value="3">
                    <label for="q4_3">3</label>
                    <input type="radio" id="q4_4" name="question4" value="4">
                    <label for="q4_4">4</label>
                    <input type="radio" id="q4_5" name="question4" value="5">
                    <label for="q4_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>5. Είμαι πρόθυμος να βοηθήσω με τις γνώσεις και τις δεξιότητες μου, μέλη της ομάδας στο δικό τους κομμάτι;</label>
                <div class="answers">
                    <input type="radio" id="q5_1" name="question5" value="1" required>
                    <label for="q5_1">1</label>
                    <input type="radio" id="q5_2" name="question5" value="2">
                    <label for="q5_2">2</label>
                    <input type="radio" id="q5_3" name="question5" value="3">
                    <label for="q5_3">3</label>
                    <input type="radio" id="q5_4" name="question5" value="4">
                    <label for="q5_4">4</label>
                    <input type="radio" id="q5_5" name="question5" value="5">
                    <label for="q5_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>6. Ενθαρρύνω την πολυφωνία και την ανταλλαγή διαφορετικών ιδεών στην ομάδα;</label>
                <div class="answers">
                    <input type="radio" id="q6_1" name="question6" value="1" required>
                    <label for="q6_1">1</label>
                    <input type="radio" id="q6_2" name="question6" value="2">
                    <label for="q6_2">2</label>
                    <input type="radio" id="q6_3" name="question6" value="3">
                    <label for="q6_3">3</label>
                    <input type="radio" id="q6_4" name="question6" value="4">
                    <label for="q6_4">4</label>
                    <input type="radio" id="q6_5" name="question6" value="5">
                    <label for="q6_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>7. Νιώθω άνετα να εκφράσω τη διαφωνία μου όταν είναι απαραίτητο;</label>
                <div class="answers">
                    <input type="radio" id="q7_1" name="question7" value="1" required>
                    <label for="q7_1">1</label>
                    <input type="radio" id="q7_2" name="question7" value="2">
                    <label for="q7_2">2</label>
                    <input type="radio" id="q7_3" name="question7" value="3">
                    <label for="q7_3">3</label>
                    <input type="radio" id="q7_4" name="question7" value="4">
                    <label for="q7_4">4</label>
                    <input type="radio" id="q7_5" name="question7" value="5">
                    <label for="q7_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>8. Προσαρμόζομαι εύκολα σε αλλαγές στα σχέδια που μπορεί να προκύψουν κατά τη διάρκεια της εργασίας;</label>
                <div class="answers">
                    <input type="radio" id="q8_1" name="question8" value="1" required>
                    <label for="q8_1">1</label>
                    <input type="radio" id="q8_2" name="question8" value="2">
                    <label for="q8_2">2</label>
                    <input type="radio" id="q8_3" name="question8" value="3">
                    <label for="q8_3">3</label>
                    <input type="radio" id="q8_4" name="question8" value="4">
                    <label for="q8_4">4</label>
                    <input type="radio" id="q8_5" name="question8" value="5">
                    <label for="q8_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>9. Πόσα από τα παρακάτω χαρακτηριστικά προσωπικότητας θεωρείτε ότι διαθέτετε: ομαδικότητα, συνέπεια, ηγετική ικανότητα, οργάνωση, διάθεση για ενασχόληση;</label>
                <div class="answers">
                    <input type="radio" id="q9_1" name="question9" value="1" required>
                    <label for="q9_1">1</label>
                    <input type="radio" id="q9_2" name="question9" value="2">
                    <label for="q9_2">2</label>
                    <input type="radio" id="q9_3" name="question9" value="3">
                    <label for="q9_3">3</label>
                    <input type="radio" id="q9_4" name="question9" value="4">
                    <label for="q9_4">4</label>
                    <input type="radio" id="q9_5" name="question9" value="5">
                    <label for="q9_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>10. Γενικά είστε ικανοποιημένος/η με την απόδοσή σας;</label>
                <div class="answers">
                    <input type="radio" id="q10_1" name="question10" value="1" required>
                    <label for="q10_1">1</label>
                    <input type="radio" id="q10_2" name="question10" value="2">
                    <label for="q10_2">2</label>
                    <input type="radio" id="q10_3" name="question10" value="3">
                    <label for="q10_3">3</label>
                    <input type="radio" id="q10_4" name="question10" value="4">
                    <label for="q10_4">4</label>
                    <input type="radio" id="q10_5" name="question10" value="5">
                    <label for="q10_5">5</label>
                </div>
            </div>

            <h4>Πρακτικές Ερωτήσεις</h4>

            <div class="question">
                <label>11. Συμμετέχω ενεργά στη λήψη αποφάσεων της ομάδας;</label>
                <div class="answers">
                    <input type="radio" id="q11_1" name="question11" value="1" required>
                    <label for="q11_1">1</label>
                    <input type="radio" id="q11_2" name="question11" value="2">
                    <label for="q11_2">2</label>
                    <input type="radio" id="q11_3" name="question11" value="3">
                    <label for="q11_3">3</label>
                    <input type="radio" id="q11_4" name="question11" value="4">
                    <label for="q11_4">4</label>
                    <input type="radio" id="q11_5" name="question11" value="5">
                    <label for="q11_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>12. Ξέρω να χρησιμοποιώ ψηφιακά εργαλεία συνεργασίας (πχ. git, GitHub κλπ;</label>
                <div class="answers">
                    <input type="radio" id="q12_1" name="question12" value="1" required>
                    <label for="q12_1">1</label>
                    <input type="radio" id="q12_2" name="question12" value="2">
                    <label for="q12_2">2</label>
                    <input type="radio" id="q12_3" name="question12" value="3">
                    <label for="q12_3">3</label>
                    <input type="radio" id="q12_4" name="question12" value="4">
                    <label for="q12_4">4</label>
                    <input type="radio" id="q12_5" name="question12" value="5">
                    <label for="q12_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>13. Ακολουθώ το χρονοδιάγραμμα που έχει θέσει η ομάδα;</label>
                <div class="answers">
                    <input type="radio" id="q13_1" name="question13" value="1" required>
                    <label for="q13_1">1</label>
                    <input type="radio" id="q13_2" name="question13" value="2">
                    <label for="q13_2">2</label>
                    <input type="radio" id="q13_3" name="question13" value="3">
                    <label for="q13_3">3</label>
                    <input type="radio" id="q13_4" name="question13" value="4">
                    <label for="q13_4">4</label>
                    <input type="radio" id="q13_5" name="question13" value="5">
                    <label for="q13_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>14. Συμμετέχω ενεργά στις συναντήσεις και στις συνομιλίες της ομάδας;</label>
                <div class="answers">
                    <input type="radio" id="q14_1" name="question14" value="1" required>
                    <label for="q14_1">1</label>
                    <input type="radio" id="q14_2" name="question14" value="2">
                    <label for="q14_2">2</label>
                    <input type="radio" id="q14_3" name="question14" value="3">
                    <label for="q14_3">3</label>
                    <input type="radio" id="q14_4" name="question14" value="4">
                    <label for="q14_4">4</label>
                    <input type="radio" id="q14_5" name="question14" value="5">
                    <label for="q14_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>15. Πόσο θα βαθμολογούσατε τις επικοινωνιακές σας ικανότητες με διάφορους τύπους συναδέλφων σε θέματα προσέγγισης της εργασίας;</label>
                <div class="answers">
                    <input type="radio" id="q15_1" name="question15" value="1" required>
                    <label for="q15_1">1</label>
                    <input type="radio" id="q15_2" name="question15" value="2">
                    <label for="q15_2">2</label>
                    <input type="radio" id="q15_3" name="question15" value="3">
                    <label for="q15_3">3</label>
                    <input type="radio" id="q15_4" name="question15" value="4">
                    <label for="q15_4">4</label>
                    <input type="radio" id="q15_5" name="question15" value="5">
                    <label for="q15_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>16. Κατά πόσο θα βαθμολογούσατε το ενδιαφέρον σας για το θέμα της εργασίας και το αντικείμενο του εν λόγω μαθήματος;</label>
                <div class="answers">
                    <input type="radio" id="q16_1" name="question16" value="1" required>
                    <label for="q16_1">1</label>
                    <input type="radio" id="q16_2" name="question16" value="2">
                    <label for="q16_2">2</label>
                    <input type="radio" id="q16_3" name="question16" value="3">
                    <label for="q16_3">3</label>
                    <input type="radio" id="q16_4" name="question16" value="4">
                    <label for="q16_4">4</label>
                    <input type="radio" id="q16_5" name="question16" value="5">
                    <label for="q16_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>17. Παρακολουθείτε και αν ναι πόσο συχνά τις διαλέξεις του μαθήματος;</label>
                <div class="answers">
                    <input type="radio" id="q17_1" name="question17" value="1" required>
                    <label for="q17_1">1</label>
                    <input type="radio" id="q17_2" name="question17" value="2">
                    <label for="q17_2">2</label>
                    <input type="radio" id="q17_3" name="question17" value="3">
                    <label for="q17_3">3</label>
                    <input type="radio" id="q17_4" name="question17" value="4">
                    <label for="q17_4">4</label>
                    <input type="radio" id="q17_5" name="question17" value="5">
                    <label for="q17_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>18. Πώς βαθμολογείτε τις γνώσεις σας με βάση το μάθημα και τους βαθμούς που έχετε λάβει σε αντίστοιχα μαθήματα;</label>
                <div class="answers">
                    <input type="radio" id="q18_1" name="question18" value="1" required>
                    <label for="q18_1">1</label>
                    <input type="radio" id="q18_2" name="question18" value="2">
                    <label for="q18_2">2</label>
                    <input type="radio" id="q18_3" name="question18" value="3">
                    <label for="q18_3">3</label>
                    <input type="radio" id="q18_4" name="question18" value="4">
                    <label for="q18_4">4</label>
                    <input type="radio" id="q18_5" name="question18" value="5">
                    <label for="q18_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>19. Πώς βαθμολογείτε τον εαυτό σας σε όρους διαχείρισης χρόνου, με βάση τον χρόνο παράδοσής σας σε προηγούμενες εργασίες;</label>
                <div class="answers">
                    <input type="radio" id="q19_1" name="question19" value="1" required>
                    <label for="q19_1">1</label>
                    <input type="radio" id="q19_2" name="question19" value="2">
                    <label for="q19_2">2</label>
                    <input type="radio" id="q19_3" name="question19" value="3">
                    <label for="q19_3">3</label>
                    <input type="radio" id="q19_4" name="question19" value="4">
                    <label for="q19_4">4</label>
                    <input type="radio" id="q19_5" name="question19" value="5">
                    <label for="q19_5">5</label>
                </div>
            </div>
            <div class="question">
                <label>20. Πώς βαθμολογείτε τον εαυτό σας σε όρους συνέπειας χρόνου, με βάση τη συμμετοχή σας σε προηγούμενες εργασίες;</label>
                <div class="answers">
                    <input type="radio" id="q20_1" name="question20" value="1" required>
                    <label for="q20_1">1</label>
                    <input type="radio" id="q20_2" name="question20" value="2">
                    <label for="q20_2">2</label>
                    <input type="radio" id="q20_3" name="question20" value="3">
                    <label for="q20_3">3</label>
                    <input type="radio" id="q20_4" name="question20" value="4">
                    <label for="q20_4">4</label>
                    <input type="radio" id="q20_5" name="question20" value="5">
                    <label for="q20_5">5</label>
                </div>
            </div>
            <button type="submit">Υποβολή</button>
        </form>
    </div>
</body>
</html>
            

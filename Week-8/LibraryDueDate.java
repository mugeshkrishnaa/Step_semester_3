import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getDays();

    void printDueDate() {
        LocalDate date = LocalDate.of(2023, 10, 26);
        System.out.println(title + ": " + date.plusDays(getDays()));
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("1984"),
            new DVD("The Matrix"),
            new Magazine("Forbes Issue 500")
        };

        for (LibraryItem item : items) {
            item.printDueDate();
        }
    }
}

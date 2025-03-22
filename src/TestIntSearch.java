import java.util.Scanner;
public class TestIntSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int table = 0;
        while(true) {
            System.out.println("\n----------------------MAIN MENU-------------------\n" +
                    "1. Create, populate, and display array Values[]\n" +
                    "2. Read output table size\n" +
                    "3. Run interpolation search and display outputs\n" +
                    "4. Exit program\n\n" +
                    "Enter option number:");
            switch(sc.nextInt()) {
                case 1:
                    TestInterpolationSearch.RandomDistinct();
                    break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Enter output table size:");
                        table = sc.nextInt();
                        break;
                        case 3:
                            TestInterpolationSearch.RunIntSearch(table);
                            break;
                            case 4:
                                System.exit(0);
                                break;
            }
        }
    }
}

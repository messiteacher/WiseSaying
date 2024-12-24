import java.util.*;
import java.util.Scanner;

public class App {

    private int lastId = 0;
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void run() {

        add("나의 멋진 우주여 안녕", "윤하");
        add("Dearest, darling, my universe", "아이유");

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {

                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if (command.equals("등록")) {
                writeWiseSaying();
            } else if(command.equals("목록")) {
                printWiseSayingList();
            } else if(command.startsWith("삭제?id=")) {

                String strId = command.substring(6);
                int id = Integer.parseInt(strId);

                deleteWiseSaying(id);
                System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
            }
        }
    }

    private void deleteWiseSaying(int targetId) {

        for (WiseSaying wiseSaying : wiseSayingList) {

            if (wiseSaying.getId() == targetId) {
                wiseSayingList.remove(wiseSaying);
                break;
            }
        }
    }

    private void printWiseSayingList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<WiseSaying> reversedList = new ArrayList<>(wiseSayingList);
        Collections.reverse(reversedList);

        for (WiseSaying wiseSaying : reversedList) {

            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    private void writeWiseSaying() {

        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        add(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
    }

    public void add(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList.add(wiseSaying);
    }
}

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

            } else if (command.startsWith("수정?id=")) {

                String strId = command.substring(6);
                int id = Integer.parseInt(strId);

                updateWiseSaying(id);
            }
        }
    }

    private WiseSaying findWiseSaying(int targetId) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                return wiseSaying;
            }
        }

        return null; // 자바에서 null은 객체가 없음을 의미
    }

    private void updateWiseSaying(int targetId) {

        WiseSaying wiseSaying = findWiseSaying(targetId);

        if (wiseSaying == null) {

            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return ;
        }

        System.out.println("명언(기존) : %s".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String newContent = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine();

        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(targetId));
    }

    private void deleteWiseSaying(int targetId) {

        WiseSaying wiseSaying = findWiseSaying(targetId);

        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
        }

        wiseSayingList.remove(wiseSaying);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
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

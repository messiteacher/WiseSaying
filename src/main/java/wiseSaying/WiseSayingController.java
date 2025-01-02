package wiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WiseSayingController {

    private int lastId = 0;
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public WiseSaying findWiseSaying(int targetId) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                return wiseSaying;
            }
        }

        return null; // 자바에서 null은 객체가 없음을 의미
    }

    public void updateWiseSaying(int targetId) {

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

    public void deleteWiseSaying(int targetId) {

        WiseSaying wiseSaying = findWiseSaying(targetId);

        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return ;
        }

        wiseSayingList.remove(wiseSaying);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
    }

    public void printWiseSayingList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<WiseSaying> reversedList = new ArrayList<>(wiseSayingList);
        Collections.reverse(reversedList);

        for (WiseSaying wiseSaying : reversedList) {

            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    public void writeWiseSaying() {

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

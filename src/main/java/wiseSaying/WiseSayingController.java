package wiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WiseSayingController {

    private final WiseSayingService wiseSayingService;
    private final Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService(new WiseSayingMemRepository());
    }

    public void updateWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.getItem(targetId);

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

        wiseSayingService.modify(wiseSaying, newContent, newAuthor);
        System.out.println("%d번 명언이 수정되었습니다.".formatted(targetId));
    }

    public void deleteWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.getItem(targetId);

        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return ;
        }

        wiseSayingService.remove(wiseSaying);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
    }

    public void printWiseSayingList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<WiseSaying> originalList = wiseSayingService.getItems();
        ArrayList<WiseSaying> reversedList = new ArrayList<>(originalList);
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

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void makeTestData() {

        wiseSayingService.write("나의 멋진 우주여 안녕", "윤하");
        wiseSayingService.write("Dearest, darling, my universe", "아이유");
    }
}

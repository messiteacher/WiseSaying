package wiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WiseSayingController {

    private final WiseSayingService wiseSayingService;
    private final Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void updateWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.findWiseSaying(targetId);

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

        wiseSayingService.updateWiseSaying(wiseSaying, newContent, newAuthor);
        System.out.println("%d번 명언이 수정되었습니다.".formatted(targetId));
    }

//    public void deleteWiseSaying(int targetId) {
//
//        WiseSaying wiseSaying = wiseSayingService.findWiseSaying(targetId);
//
//        if (wiseSaying == null) {
//            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
//            return ;
//        }
//
//        wiseSayingList.remove(wiseSaying);
//        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
//    }
//
    public void printWiseSayingList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<WiseSaying> reversedList = wiseSayingService.findAll();
        Collections.reverse(reversedList);

        for (WiseSaying wiseSaying : reversedList) {

            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

//    public void writeWiseSaying() {
//
//        System.out.print("명언 : ");
//        String content = sc.nextLine();
//
//        System.out.print("작가 : ");
//        String author = sc.nextLine();
//
//        add(content, author);
//
//        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
//    }
//
    public void add(String content, String author) {
        wiseSayingService.add(content, author);
    }
}

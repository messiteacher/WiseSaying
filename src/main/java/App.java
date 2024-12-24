import java.util.Scanner;

public class App {

    private int lastId = 0;
    private int wiseSayingSize = 0;
    private final WiseSaying[] wiseSayingList = new WiseSaying[3];
    Scanner sc = new Scanner(System.in);

    public void run() {

        // 테스트 명언 데이터 1
        add("명언은 시간을 할 수 있습니다.", "모두");

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
            }
        }
    }

    private void printWiseSayingList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(int i = 0; i < wiseSayingSize; i++) {
            WiseSaying wiseSaying = wiseSayingList[i];
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
        wiseSayingList[wiseSayingSize++] = wiseSaying;
    }
}
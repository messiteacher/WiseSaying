import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }
}

class  App {
    public void run() {

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        int lastNo = 0;
        String[] contentList = new String[3];
        String[] authorList = new String[3];

        WiseSaying wiseSaying = new WiseSaying();

        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if (command.equals("등록")) {

                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                wiseSaying.id = ++lastNo;
                wiseSaying.content = content;
                wiseSaying.author = author;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo));
            } else if(command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
            }
        }
    }
}

class WiseSaying {
    int id;
    String content;
    String author;
}
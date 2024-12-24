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

        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;
            } else if (command.equals("등록")) {

                System.out.print("명언 : ");
                contentList[lastNo] = sc.nextLine();

                System.out.print("작가 : ");
                authorList[lastNo] = sc.nextLine();

                System.out.println("%d번 명언이 등록되었습니다.".formatted(++lastNo));
            } else if(command.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int i = 2; i >= 0; i--) {
                    System.out.println("%d / %s / %s".formatted(i, authorList[i], authorList[i]));
                }
            }
        }
    }
}

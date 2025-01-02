import wiseSaying.SystemController;
import wiseSaying.WiseSayingController;

import java.util.*;
import java.util.Scanner;

public class App {

    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;
    private final Scanner sc;

    public App() {
        sc = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(sc);
        systemController = new SystemController();
    }

    public void run() {

        wiseSayingController.add("나의 멋진 우주여 안녕", "윤하");
        wiseSayingController.add("Dearest, darling, my universe", "아이유");

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {

                systemController.exit();
                break;
            } else if (command.equals("등록")) {
//                wiseSayingController.writeWiseSaying();
            } else if(command.equals("목록")) {
//                wiseSayingController.printWiseSayingList();
            } else if(command.startsWith("삭제?id=")) {

                String strId = command.substring(6);
                int id = Integer.parseInt(strId);

//                wiseSayingController.deleteWiseSaying(id);

            } else if (command.startsWith("수정?id=")) {

                String strId = command.substring(6);
                int id = Integer.parseInt(strId);

                wiseSayingController.updateWiseSaying(id);
            }
        }
    }
}

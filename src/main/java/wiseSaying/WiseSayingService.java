package wiseSaying;

import java.util.ArrayList;

public class WiseSayingService {

    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();

    public WiseSaying findWiseSaying(int targetId) {

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                return wiseSaying;
            }
        }

        return null; // 자바에서 null은 객체가 없음을 의미
    }

    public void updateWiseSaying(WiseSaying wiseSaying, String newContent, String newAuthor) {

        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
    }
}

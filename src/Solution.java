import java.util.*;

public class Solution{
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>();
        List<String[]> result = new LinkedList<>();

        for (String records : record) {
            String[] keyWord = records.split(" ");

            if (keyWord[0].equals("Enter")) { // 들어오면 id 맵에 저장후, result에 추가
                idMap.put(keyWord[1], keyWord[2]);
                result.add(keyWord);
            } else if (keyWord[0].equals("Change")) { // 닉네임 업데이트만
                idMap.put(keyWord[1], keyWord[2]);
            } else { // 나가면 result에만 추가
                result.add(keyWord);
            }
        }

        String[] answer = new String[result.size()];
        int idx = 0;
        for (String[] keyWords : result){
            String nickName = idMap.get(keyWords[1]);

            if (keyWords[0].equals("Enter")) {
                answer[idx++] = nickName + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickName + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}

package programmers;

/**
 * created by victory_woo on 2020/08/11
 */
public class PGM49993 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        StringBuilder sb;
        int count = 0;
        for (String tree : skill_trees) {
            sb = new StringBuilder();

            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                if (skill.contains(String.valueOf(c))) sb.append(c);
            }

            boolean flag = true;
            tree = sb.toString();
            int minLength = Math.min(skill.length(), tree.length());

            for (int i = 0; i < minLength; i++) {
                if (skill.charAt(i) != tree.charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        return count;
    }
}

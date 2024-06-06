class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();        
        List<String> digits = new ArrayList<>();

        for (String log: logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);            
            } else {
                letters.add(log);
            }
        }

        letters.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letters.addAll(digits);
        return letters.toArray(new String[0]);
    }
}
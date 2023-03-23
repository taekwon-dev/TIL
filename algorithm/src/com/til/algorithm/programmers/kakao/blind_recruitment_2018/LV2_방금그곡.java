package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.HashMap;

public class LV2_방금그곡 {

    private HashMap<String, String> map = new HashMap<>(){{
        put("C#", "c");
        put("D#", "d");
        put("F#", "f");
        put("G#", "g");
        put("A#", "a");
    }};

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);

        int maxPlayTime = 0;
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int playTime = getPlayTime(info[0], info[1]);
            String title = info[2];
            String source = convert(info[3]);
            StringBuilder music = new StringBuilder(source);
            while (music.length() < playTime) {
                music.append(source);
            }
            String target = music.toString().substring(0, playTime);
            if (target.contains(m)) {
                if (maxPlayTime < playTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    private int getPlayTime(String startTime, String endTime) {
        String[] startSplit = startTime.split(":");
        String[] endSplit = endTime.split(":");

        int start = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
        int end = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);

        return end - start;
    }

    private String convert(String s) {
        for (String key : map.keySet()) {
            s = s.replace(key, map.get(key));
        }
        return s;
    }
}
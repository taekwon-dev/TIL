package com.til.algorithm.programmers.kit;

import java.util.*;

public class LV3_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playsPerGenre = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> playsPerIdx = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            playsPerGenre.put(genre, playsPerGenre.getOrDefault(genre, 0) + play);
            if (!playsPerIdx.containsKey(genre)) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, play);
                playsPerIdx.put(genre, map);
            } else {
                playsPerIdx.get(genre).put(i, plays[i]);
            }
        }
        List<String> playsPerGenreKeys = new ArrayList<>(playsPerGenre.keySet());
        Collections.sort(playsPerGenreKeys, (o1, o2) -> playsPerGenre.get(o2) - playsPerGenre.get(o1));
        List<Integer> answerList = new ArrayList<>();
        for (String genreKey : playsPerGenreKeys) {
            List<Integer> idxs = new ArrayList<>(playsPerIdx.get(genreKey).keySet());
            Collections.sort(idxs, (o1, o2) -> {
                if (playsPerIdx.get(genreKey).get(o1) == playsPerIdx.get(genreKey).get(o2)) {
                    return o1 - o2;
                }
                return playsPerIdx.get(genreKey).get(o2) - playsPerIdx.get(genreKey).get(o1);
            });
            answerList.add(idxs.get(0));
            if (idxs.size() > 1) {
                answerList.add(idxs.get(1));
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

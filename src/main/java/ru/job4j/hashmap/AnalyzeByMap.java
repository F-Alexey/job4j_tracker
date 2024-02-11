package ru.job4j.hashmap;

import java.util.*;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int index = 0;
        double average = 0D;
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                average += subject.score();
                index++;
            }
        }
        average = average / index;
        return average;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double average = 0D;
        List<Label> result = new ArrayList<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                average += subject.score();
            }
            Label answer = new Label(student.name(), average / student.subjects().size());
            result.add(answer);
            average = 0;
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                if (!map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                }
            }
        }
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            Label answer = new Label(key, value / pupils.size());
            result.add(answer);
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0D;
        List<Label> answer = new ArrayList<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                sum += subject.score();
            }
            answer.add(new Label(student.name(), sum));
            sum = 0;
        }
        Collections.sort(answer);
        return answer.get(answer.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                if (!map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                }
            }
        }
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            Label answer = new Label(key, value);
            result.add(answer);
        }
        Collections.sort(result);
        return result.get(result.size() - 1);
    }

}

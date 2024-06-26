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
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + newValue);
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
        Label result = answer.get(0);
        for (Label bestStudent : answer) {
            if (bestStudent.score() > result.score()) {
                result = bestStudent;
            }
        }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil student : pupils) {
            for (Subject subject : student.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + newValue);
            }
        }
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            Label answer = new Label(key, value);
            result.add(answer);
        }
        Label bestSubject = result.get(0);
        for (Label thatSubject : result) {
            if (thatSubject.score() > bestSubject.score()) {
                bestSubject = thatSubject;
            }
        }
        return bestSubject;
    }

}

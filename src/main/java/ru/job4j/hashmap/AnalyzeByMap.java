package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
       int totalScore = 0;
       double subjectCount = 0;
       for (Pupil person : pupils) {
           for (Subject subject : person.subjects()) {
               totalScore += subject.score();
               subjectCount++;
           }
       }
        return totalScore / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> average = new ArrayList<>();
        for (Pupil person : pupils) {
            int totalScore = 0;
            int subjectsCount = person.subjects().size();

            for (Subject subject : person.subjects()) {
                totalScore += subject.score();
            }
            double averageByPupil = (double) totalScore / subjectsCount;
            average.add(new Label(person.name(), averageByPupil));
                }
        return average;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();
        for (Pupil person : pupils) {
            for (Subject subject : person.subjects()) {
                String subjectName = subject.name();
                int subjectScore = subject.score();
                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + subjectScore);
                subjectCounts.put(subjectName, subjectCounts.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> averageBySubject = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            double count = subjectCounts.get(subjectName);
            double averageScore = totalScore / count;
            averageBySubject.add(new Label(subjectName, averageScore));
        }
        return averageBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil person : pupils) {
            int totalScore = 0;
            for (Subject subject : person.subjects()) {
                totalScore += subject.score();
            }
            score.add(new Label(person.name(), totalScore));
        }
       score.sort(Comparator.naturalOrder());
        return score.get(score.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil person : pupils) {
            for (Subject subject : person.subjects()) {
                String subjectName = subject.name();
                int subjectScore = subject.score();
                subjectScores.put(subjectName, subjectScores.getOrDefault(subjectName, 0) + subjectScore);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            labels.add(new Label(subjectName, totalScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
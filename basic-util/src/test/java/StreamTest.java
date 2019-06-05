import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @description:
 * @name: StreamTest
 * @author: Stars Hung
 * @date: 9:56 2019/5/5
 **/
public class StreamTest {

    private List<Student> students;

    @Before
    public void init() {
        Random random = new Random();
        students = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    @Test
    public void testStream() {
        List<String> studentList = students.stream().filter(student -> student.getScore() > 85)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());


        students.stream().filter(student -> student.getScore() > 90).map(student -> "优等生").forEach(System.out::println);
    }

    @Data
    class Student {
        private String name;
        private Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }
}

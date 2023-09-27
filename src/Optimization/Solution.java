package Optimization;

import java.io.*;
import java.util.*;

public class Solution {

    static class Course implements Comparable<Course> {
        int id;
        int deadline;
        int value;

        // Constructor
        Course(int id, int deadline, int value){
            this.id = id;
            this.deadline = deadline;
            this.value = value;
        }

        @Override
        public int compareTo(Course other){
            if(this.deadline != other.deadline){
                return this.deadline - other.deadline;
            }
            return other.value - this.value;
        }
    }

    private static int[] optimizeCourseSchedule(Course[] courses){
        Arrays.sort(courses);
        PriorityQueue<Integer> selectedCourses = new PriorityQueue<>();
        int totalValue = 0;
        int selectedCount = 0;
        for(Course course : courses){
            if (selectedCourses.size() < course.deadline){
                totalValue += course.value;
                selectedCourses.offer(course.value);
                selectedCount++;
            }else if(!selectedCourses.isEmpty() && selectedCourses.peek() < course.value){
                totalValue = totalValue - selectedCourses.poll() + course.value;
                selectedCourses.offer(course.value);
            }
        }
        return new int[]{selectedCount, totalValue};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCourses = scanner.nextInt();
        Course[] courses = new Course[numberOfCourses];

        for(int i = 0; i < numberOfCourses; i++){
            courses[i] = new Course(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        int[] results = optimizeCourseSchedule(courses);
        System.out.println(results[0] + " " + results[1]);
    }
}
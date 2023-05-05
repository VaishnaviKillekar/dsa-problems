// Link to problem - https://leetcode.com/problems/course-schedule/description/

/**
 * Intuition - Store the prerequisites for each course as an array of lists and 
 * maintain a 'visited' and 'dp' array. The 'dp' array stores if the course can
 * be completed and 'visited' array tracks all the courses where exploration of
 * prerequisites has started so as to avoid cycling i.e., [0,1] and [1,0].
 *
 * Go through all courses and explore all their prerequisites while storing all
 * results in 'dp' array whenever a course can be finished or not.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] prereq = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];

        // Store the prerequisites for all courses
        for(int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = prereq[prerequisites[i][0]];
            if(list == null) {
                list = new ArrayList();
            }
            list.add(prerequisites[i][1]);
            prereq[prerequisites[i][0]] = list;
        }

        // Go through prerequisites using DFS
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(prereq, visited, dp, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] prereq, boolean[] visited, boolean[] dp, int currCourse) {
        // This condition is to avoid infinite cycling
        if(visited[currCourse]) {
            return dp[currCourse];
        }
        // Mark course as visited
        visited[currCourse] = true;

        List<Integer> courses = prereq[currCourse];
        if(courses == null) {
            // Current course can be completed - no prerequisites 
            dp[currCourse] = true;
            return true;
        }

        // Check if all prerequisites can be completed
        for(int i = 0; i < courses.size(); i++) {
            if(!dfs(prereq, visited, dp, courses.get(i))) {
                dp[currCourse] = false;
                return false;
            }
        }
        dp[currCourse] = true;
        return true;
    }
}

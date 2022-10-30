// Link to problem - https://leetcode.com/contest/weekly-contest-317/problems/most-popular-video-creator/

/**
 * Weekly Contest 317
 *
 * Intuition - Compute the total views on all videos of each creator to determine popularity.
 * From total views, find the highest number of views. Now collect all creators whose views
 * are equal to highest.
 * Iterate on cerators list and find their videos with highest views.
 *
 * TODO - Optimise solution to use fewer data structures, iterations.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, Integer> totalViews = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        // Count all views for each creator - popularity
        for(int i = 0; i < n; i++) {
            Integer total = totalViews.get(creators[i]);
            if(total == null) {
                total = views[i];
            }
            else {
                total += views[i];
            }
            totalViews.put(creators[i], total);
        }
        
        // Find highest views
        int max = 0;
        for(Map.Entry<String, Integer> entry : totalViews.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        
        // Find creators with highest views (max)
        for(Iterator<Map.Entry<String, Integer>> it = totalViews.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() < max) {
                it.remove();
            }
        }
        
        // Find the video with highest views of all popular creators
        Set<String> popularCreators = totalViews.keySet();
        Map<String, List<Object>> creatorMostViewed = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(popularCreators.contains(creators[i])) {
                List<Object> videoViews = creatorMostViewed.get(creators[i]);
                // A video is already present for creator
                if(videoViews != null) {
                    // If current video has more views - replace with current 
                    // or if current video has same views, then use lexicographically smaller video ID
                    if(views[i] > (Integer) videoViews.get(1) || 
                       (views[i] == (Integer) videoViews.get(1) && videoViews.get(0).toString().compareTo(ids[i]) > 0 )) {
                        videoViews.clear();
                        videoViews.add(ids[i]);
                        videoViews.add(views[i]);
                        creatorMostViewed.put(creators[i], videoViews);
                    }
                }
                else {
                    videoViews = new ArrayList<>();
                    videoViews.add(ids[i]);
                    videoViews.add(views[i]);
                    creatorMostViewed.put(creators[i], videoViews);
                }
            }
        }
        
        for(Map.Entry<String, List<Object>> entry : creatorMostViewed.entrySet()) {
            List<String> curr = new ArrayList<>();
            curr.add(entry.getKey());
            curr.add(entry.getValue().get(0).toString());
            res.add(curr);
        }
        
        return res;
    }
}

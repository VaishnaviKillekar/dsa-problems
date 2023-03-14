// Link to problem - https://leetcode.com/problems/gas-station/description/

/**
 * Intuition - Greedy approach
 * Scan through all gas stations once and sum up all gas available and
 * the cost to cover all stations. If the gas in the tank at any station becomes
 * less than 0, then all stations between start and current i cannot be the starting
 * point. Hence, update start to the next station in sequence (i + 1) and recheck if
 * tank contains some gas until the end.
 * After going through all stations, we will have potential starting point, but that
 * is only valid if the total gas is at least as much as the total cost to cover all
 * stations.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank = tank + gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return totalCost > totalGas ? -1 : start;
    }
}

/**
 * Intuition - Brute Force approach (Time Limit exceeded for very large inputs)
 * We check if the current station can be reached after visiting all stations.
 * Every station is explored until a whole circuit is found.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] != 0 && journeyComplete(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean journeyComplete(int[] gas, int[] cost, int start) {
        int i = start;
        int count = 0;
        int tank = 0;
        while(count <= gas.length) {
            if((tank + gas[i]) - cost[i] >= 0) {
                // Can reach the next gas station
                count++;
                tank = tank + gas[i] - cost[i];
                i = (i + 1) % gas.length;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

package com.airaketa.leetcode.lc841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        keys.addAll(rooms.get(0));
        while (true) {
            boolean roomOpened = false;
            boolean closedRoomSpotted = false;
            for (int i = 1; i < rooms.size(); i++) {
                List<Integer> room = rooms.get(i);
                if (!room.isEmpty()) {
                    closedRoomSpotted = true;
                    if (keys.contains(i)) {
                        keys.addAll(room);
                        room.clear();
                        roomOpened = true;
                    }
                }
            }
            if (!roomOpened) {
                return !closedRoomSpotted;
            }
        }
    }
}
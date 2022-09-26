package com.jinfour.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    /*
     * @lc app=leetcode.cn id=460 lang=java
     *
     * [460] LFU 缓存
     *
     * https://leetcode.cn/problems/lfu-cache/description/
     *
     * algorithms
     * Hard (44.02%)
     * Likes:    569
     * Dislikes: 0
     * Total Accepted:    51.1K
     * Total Submissions: 116.2K
     * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
      '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
     *
     * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
     *
     * 实现 LFUCache 类：
     *
     *
     * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
     * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
     * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量
     * capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用
     * 的键。
     *
     *
     * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
     *
     * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
     *
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     *
     *
     * 示例：
     *
     *
     * 输入：
     * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
     * "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
     * 输出：
     * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
     *
     * 解释：
     * // cnt(x) = 键 x 的使用计数
     * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
     * LFUCache lfu = new LFUCache(2);
     * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
     * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
     * lfu.get(1);      // 返回 1
     *                   // cache=[1,2], cnt(2)=1, cnt(1)=2
     * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
     *                   // cache=[3,1], cnt(3)=1, cnt(1)=2
     * lfu.get(2);      // 返回 -1（未找到）
     * lfu.get(3);      // 返回 3
     *                   // cache=[3,1], cnt(3)=2, cnt(1)=2
     * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
     *                   // cache=[4,3], cnt(4)=1, cnt(3)=2
     * lfu.get(1);      // 返回 -1（未找到）
     * lfu.get(3);      // 返回 3
     *                   // cache=[3,4], cnt(4)=1, cnt(3)=3
     * lfu.get(4);      // 返回 4
     *                   // cache=[3,4], cnt(4)=2, cnt(3)=3
     *
     *
     *
     * 提示：
     *
     *
     * 0 <= capacity <= 10^4
     * 0 <= key <= 10^5
     * 0 <= value <= 10^9
     * 最多调用 2 * 10^5 次 get 和 put 方法
     *
     *
     */

    // 缓存内容
    private final Map<Integer, Integer> cache = new HashMap<>();
    // 各个key的访问频率
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    // 相同访问次数的所有key的集合
    private final Map<Integer, LinkedHashSet<Integer>> freqKeysMap = new HashMap<>();
    // 最小的访问次数
    private int minFreq;
    // 缓存容量
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            addFreq(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            return;
        }
        if (cache.containsKey(key)) {
            cache.put(key, value);
            addFreq(key);
            return;
        }
        if (cache.size() >= capacity) {
            // 删除最不经常使用的元素
            delRecentlyNotUse();
        }
        cache.put(key, value);
        addFreq(key);
    }

    private void delRecentlyNotUse() {
        LinkedHashSet<Integer> keys = freqKeysMap.get(minFreq);
        if (keys != null) {
            int key = keys.iterator().next();
            cache.remove(key);
            freqMap.remove(key);
            delFromFreqKeysMap(minFreq, key);
        }
    }

    // 更新key的使用频率（新增元素场景下）
    private void addFreq(int key) {
        // 频率map数字更新
        int count = -1;
        if (freqMap.containsKey(key)) {
            count = freqMap.get(key);
            freqMap.put(key, count + 1);
        } else {
            freqMap.put(key, 0);
        }

        // 访问次数集合的数据更新
        // 如果count == -1，代表key是新增
        if (count == -1) {
            addToFreqKeysMap(0, key);
        } else {
            delFromFreqKeysMap(count, key);
            addToFreqKeysMap(count + 1, key);
        }
    }

    /**
     * 从相同次数频率列表中删除key
     * 如果更新后列表数量为0，需要把最小值提升
     *
     * @param count
     * @param key
     */
    private void delFromFreqKeysMap(int count, int key) {
        LinkedHashSet<Integer> keys = freqKeysMap.get(count);
        if (keys != null && keys.contains(key)) {
            keys.remove(key);
        }
        if (keys.size() == 0 && count == minFreq) {
            minFreq++;
        }
    }

    private void addToFreqKeysMap(int count, int key) {
        if (freqKeysMap.containsKey(count)) {
            freqKeysMap.get(count).add(key);
        } else {
            LinkedHashSet<Integer> hs = new LinkedHashSet<>();
            hs.add(key);
            freqKeysMap.put(count, hs);
        }
        if (count < minFreq) {
            minFreq = count;
        }
    }
}

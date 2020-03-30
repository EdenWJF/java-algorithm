package com.jinfour.beautiful;

import java.util.Random;

public class ZSkipList {
    private static ZSkipListNode header ;

    private static ZSkipListNode tail;

    private static int level;

    private static int length;
    
    private final static int ZSKIPLIST_MAXLEVEL = 32;

    private final static double ZSKIPLIST_P = 0.25;

    //跳跃表
    private static class ZSkipListNode {
        ZSkipListNode backward;

        double score;

        String ele;

        ZSkipListLevel[] level;

        public ZSkipListNode getBackward() {
            return backward;
        }

        public void setBackward(ZSkipListNode backward) {
            this.backward = backward;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getVal() {
            return ele;
        }

        public void setVal(String val) {
            this.ele = val;
        }
    }

    private static class ZSkipListLevel {
        ZSkipListNode forward;

        int span;

        public ZSkipListNode getForward() {
            return forward;
        }

        public void setForward(ZSkipListNode forward) {
            this.forward = forward;
        }

        public int getSpan() {
            return span;
        }

        public void setSpan(int span) {
            this.span = span;
        }
    }

    public ZSkipList() {
        header = new ZSkipListNode();
        tail = new ZSkipListNode();
    }

    ZSkipListNode zslInsert(ZSkipList zsl, double score, String ele) {
        ZSkipListNode[] update = new ZSkipListNode[ZSKIPLIST_MAXLEVEL]; //update指向每一层需要修改的结点
        ZSkipListNode x;
        int[] rank = new int[ZSKIPLIST_MAXLEVEL]; //每一层要修改的结点在整个zset中的排名(根据score从小到大排序)
        int i, level;

        x = zsl.header;
        //从最顶层开始，一层一层往下找
        for (i = zsl.level-1; i >= 0; i--) {
            /* store rank that is crossed to reach the insert position */
            rank[i] = i == (zsl.level-1) ? 0 : rank[i+1];
            //在每一层中找到新结点要插入的位置的前一个结点，记录到update[i]中
            while (x.level[i].forward != null
                    && (x.level[i].forward.score < score
                        || (x.level[i].forward.score == score && !ele.equals(x.level[i].forward.ele)))) {
                rank[i] += x.level[i].span;
                x = x.level[i].forward;
            }
            update[i] = x;
        }
        /* we assume the element is not already inside, since we allow duplicated
         * scores, reinserting the same element should never happen since the
         * caller of zslInsert() should test in the hash table if the element is
         * already inside or not.
         */
        level = zslRandomLevel(); //按照随机算法计算新结点的level
        //如果新结点的level大于所有结点，则将header结点的新增level的span设为总结点数，此时forward指向NULL
        if (level > zsl.level) {
            for (i = zsl.level; i < level; i++) {
                rank[i] = 0;
                update[i] = zsl.header;
                update[i].level[i].span = zsl.length;
            }
            zsl.level = level;
        }
        x = zslCreateNode(level,score,ele);//创建新结点
        //更新每一层的链表
        for (i = 0; i < level; i++) {
            x.level[i].forward = update[i].level[i].forward;
            update[i].level[i].forward = x;

            /* update span covered by update[i] as x is inserted here */
            //rank[0]表示update[0]结点的排名，rank[i]表示update[i]结点的排名
            x.level[i].span = update[i].level[i].span - (rank[0] - rank[i]);
            update[i].level[i].span = (rank[0] - rank[i]) + 1;
        }

        /* increment span for untouched levels */
        for (i = level; i < zsl.level; i++) {
            update[i].level[i].span++;
        }

        x.backward = (update[0] == zsl.header) ? null : update[0];
        if (x.level[0].forward != null)
            x.level[0].forward.backward = x;
    else
        zsl.tail = x;
        zsl.length++;
        return x;
    }

    private ZSkipListNode zslCreateNode(int level, double score, String ele) {
        return null;
    }

    private int zslRandomLevel() {
        Random random = new Random();
        int level = 1;
        while ((random.nextInt() & 0xFFFF) < (ZSKIPLIST_P * 0xFFFF))
            level += 1;
        return (level<ZSKIPLIST_MAXLEVEL) ? level : ZSKIPLIST_MAXLEVEL;
    }

}

package com.jinfour.raft;

public class RaftServer {
    private static MemberState state = null;

    public static void main(String[] args) {
        state = new MemberState();

    }
}

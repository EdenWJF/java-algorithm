package com.jinfour.raft;

import java.util.List;

public class MemberState {
    private volatile MemberState.Role role;
    private volatile int term;
    private List<String> ipList;

    public MemberState() {

    }


    public static enum Role {
        UNKNOW,
        FLLOWER,
        CANDIDATE,
        LEADER,
        ;
        private Role() {

        }
    }
}

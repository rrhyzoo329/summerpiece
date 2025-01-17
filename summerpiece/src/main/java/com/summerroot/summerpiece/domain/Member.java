package com.summerroot.summerpiece.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private int id;

    private String email;
    private String pwd;
    private String name;
    private String nickname;
    private String phone;
    private LocalDateTime enrollDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToMany(mappedBy = "fileUploadMember", cascade = CascadeType.ALL)
    private List<FileBox> fileBoxes = new ArrayList<>();

    @OneToMany(mappedBy = "boardWriter", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "replyWriter", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "calendarWriter", cascade = CascadeType.ALL)
    private List<Calendar> calendars = new ArrayList<>();
}

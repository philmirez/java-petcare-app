package app.datastructure;

import app.objects.Member;

public class MemberNode {
    private Member member;
    private MemberNode link;

    public MemberNode() {
        this.member = new Member();
        this.link = null;
    }

    public MemberNode(Member member, MemberNode link) {
        this.member = member;
        this.link = link;
    }

    public Member getMember() {
        return this.member;
    }

    public MemberNode getLink() {
        return this.link;
    }

    public String getMembderData() {
        return this.member.toString();
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setLink(MemberNode link) {
        this.link = link;
    }

    public boolean hasNext() {
        if (this.link == null) {
            return false;
        }
        return true;
    }
}
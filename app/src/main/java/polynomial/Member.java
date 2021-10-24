package polynomial;

import exeption.ActionException;
import lombok.Data;

import java.util.Objects;

@Data
public class Member implements Comparable<Member> {
    private int c;
    private int n;

    Member(int c, int n) {
        this.c = c;
        if (c != 0) this.n = n;
        else this.n = 0;
    }

    Member() {
        this.c = 0;
        this.n = 0;
    }

    @Override
    public int compareTo(Member m) {
        return Integer.compare(this.getN(), m.getN());
    }

    public Member deferential() {
        return new Member(c * n, n - 1);
    }

    public Member minus() {
        return new Member(c * (-1), n);
    }

    public Member summarize(Member m) throws ActionException {
        if (this.n != m.getN()) throw new ActionException("degree n must be similar!");
        return new Member(this.c + m.getC(), this.n);
    }

    public Member subscription(Member m) throws ActionException {
        if (this.n != m.getN()) throw new ActionException("degree n must be similar!");
        return new Member(this.c - m.getC(), this.n);
    }

    public Member multiplication(Member m) {
        return new Member(this.c * m.getC(), this.n + m.getN());
    }

    public Double calculate(double x) {
        return c * Math.pow(x, n);
    }

    @Override
    public String toString() {
        return c + " (" + n + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return c == member.c && n == member.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, n);
    }
}
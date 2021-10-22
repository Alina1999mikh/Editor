package polynomial;

import lombok.Data;

import java.util.Objects;

@Data
public class Member {
    double c;
    double n;

    Member(double c, double n) {
        this.c = c;
        if (c != 0) this.n = n;
        else this.n = 0;
    }

    public Member deferential() {
        return new Member(c * n, n - 1);
    }

    public Double calculate(double x) {
        return c * Math.pow(x, n);
    }

    @Override
    public String toString() {
        return c + " * a (pow " + n + ")";
    }

    @Override
    public boolean equals(Object o) {
        double difference = 0.000000000001;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Math.abs(member.c - c) <= difference && Math.abs(member.n - n) <= difference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, n);
    }
}
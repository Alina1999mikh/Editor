package polynomial;

import exeption.ActionException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TPoly {
    private List<Member> list = new ArrayList<>();

    TPoly(Member m) {
        list.add(m);
    }

    public TPoly(List<Member> list) {
        this.list = list;
        list.sort(Member::compareTo);
        // Collections.sort(this.list);
    }

    public void add(Member m) {
        int n = m.getN();
        boolean flag = false;
        if (m.getC() != 0) {
            for (Member tmp : list) {
                if (tmp.getN() == n) {
                    tmp.setC(m.getC() + tmp.getC());
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(m);
        }
        //   Collections.sort(list);
    }

    public Integer degree() {
        int max = 0;
        for (Member member : list) {
            if (member.getN() > max) max = member.getN();
        }
        return max;
    }

    public Integer factor(int n) {
        if (n > degree()) return 0;
        else {
            for (Member member : list) {
                if (member.getN() == n) return member.getC();
            }
        }
        return 0;
    }

    public void remove(TPoly poly) {
        for (Member m : poly.getList()) {
            list.remove(m);
        }
    }

    public void remove(Member m) {
        remove(new TPoly(m));
    }

    public TPoly summarize(TPoly poly) throws ActionException {
        ArrayList<Member> l = new ArrayList<>();
        for (Member m1 : poly.getList()) {
            Member similar = similar(list, m1);
            if (similar != null) l.add(m1.summarize(similar));
            else l.add(m1);
        }
        return new TPoly(l);
    }

    //found c at this list like c at m
    public Member similar(TPoly list, Member m) {
        for (Member m2 : list.list) {
            if (m2.getN() == m.getN())
                return m2;
        }
        return null;
    }

    public Member similar(List<Member> list, Member m) {
        return similar(new TPoly(list), m);
    }

    public TPoly subscription(TPoly poly) throws ActionException {
        ArrayList<Member> rez = new ArrayList<>();
        for (Member m1 : poly.getList()) {
            Member similar = similar(list, m1);
            if (similar != null) rez.add(similar.subscription(m1));
            else rez.add(m1.minus());
        }
        return new TPoly(rez);
    }

    //
    public TPoly multiplication(TPoly poly) throws ActionException {
        ArrayList<Member> rez = new ArrayList<>();
        for (Member m1 : poly.getList()) {
            for (Member m2 : list) {
                Member multiplication = m1.multiplication(m2);
                Member similar = similar(rez, multiplication);
                if (similar != null) {
                    rez.remove(similar);
                    rez.add(multiplication.summarize(similar));
                } else rez.add(multiplication);


            }
        }
        return new TPoly(rez);
    }

    public TPoly minus(TPoly poly) {
        ArrayList<Member> l = new ArrayList<>();
        for (Member m1 : poly.getList()) {
            l.add(new Member(m1.getC() * (-1), m1.getN()));

        }
        return new TPoly(l);
    }

    public TPoly deferential() {
        ArrayList<Member> l = new ArrayList<>();
        for (Member m1 : list) {
            l.add(m1.deferential());
        }
        return new TPoly(l);
    }

    public double calculate(double x) {
        double rez = 0;
        System.out.println(list);
        for (Member m1 : list) {
            rez += m1.calculate(x);
        }
        return rez;
    }

    public Member getElement(int i) {
        return list.get(i);
    }

    @Override
    public String toString() {
        return "TPoly{" +
                "list=" + list +
                '}';
    }
}
package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


    public class ClubMember implements Comparable<week6.ClubMember>
    {
        private String name;
        private int height;
    public ClubMember(String name, int height)
    {
        this.name=name;
        this.height=height;
    }
    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }
    public String toString()
    {
        return this.getName() + this.getHeight();
    }

    @Override
    public int compareTo(ClubMember clubMember) {

        if(this.getHeight()==clubMember.getHeight())
        {
            return 0;
        } else if (this.getHeight()<clubMember.getHeight())
        {
             return -1;
        }
        else
        {
            return 1;
        }
    }
    public static void main(String[] args)
    {
        List<ClubMember> clubMembers=new ArrayList<ClubMember>();
        ClubMember clubMember=new ClubMember("Lamija", 165); // clubMembers.add(new ClubMember("mikael", 182));
        ClubMember clubMember1=new ClubMember("Becir", 180);
        ClubMember clubMember2=new ClubMember("Adnan", 185);

        clubMembers.add(clubMember);
        clubMembers.add(clubMember1);
        clubMembers.add(clubMember2);

        System.out.println(clubMembers);
        Collections.sort(clubMembers);   //Collections.sort() to sort a list of ClubMember objects based on their natural order.
        System.out.println(clubMembers);  //sorting(sorting values) from smallest to biggest

    }
}
